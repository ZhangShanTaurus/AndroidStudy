package com.zss.example.performance.memory.image_handle.multipoint_touch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 描述：多点触控的View
 * Created by Administrator on 2016/3/21 0021.
 */
public class ZoomImageView extends View {
    //初始化状态常量
    public static final int STATUS_INIT = 1;
    //图片放大状态常量
    public static final int STATUS_ZOOM_OUT = 2;
    //图片缩小状态常量
    public static final int STATUS_ZOOM_IN = 3;
    //图片拖动状态常量
    public static final int STATUS_MOVE = 4;
    //用于对图片进行拖动和缩放变换的矩阵
    private Matrix matrix = new Matrix();
    //待展示的Bitmap对象
    private Bitmap sourchBitmap;
    //记录当前操作的状态
    private int currentStatus;
    //ZoomImageView控件的宽度
    private int width;
    //ZoomImageView控件的高度
    private int height;
    //记录两指同时放在屏幕上，中心点的横坐标
    private float centerPointX;
    //记录两指同时放在屏幕上，中心点的纵坐标
    private float centerPointY;
    //记录当前图片的宽度，图片被缩放时，这个值会一起变动
    private float currentBitmapWidth;
    //记录当前图片的高度，图片被缩放时，这个值会一起变动
    private float currentBitmapHeight;
    //记录上次手指移动的横坐标
    private float lastXMove = -1;
    //记录上次手指移动的纵坐标
    private float lastYMove = -1;
    //记录手指在横坐标方向上移动的距离
    private float moveDistanceX;
    //记录手指在纵坐标方向上移动的距离
    private float moveDistanceY;
    //记录图片在矩阵上的横向偏移量
    private float totalTranslateX;
    //记录图片在矩阵上的纵向偏移量
    private float totalTranslateY;
    //记录图片在矩阵上的总缩放比例
    private float totalRatio;
    //记录手指移动距离所造成的缩放比例
    private float scaledRatio;
    //记录图片初始化时的缩放比例
    private float initRatio;
    //记录上次两指之间的距离
    private double lastFingerDis;

    /**
     * 构造函数，将当前状态设置为STATUS_INIT
     */
    public ZoomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        currentStatus = STATUS_INIT;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            //分别获取ZoomImageView的宽度和高度
            width = getWidth();
            height = getHeight();
        }
    }

    /**
     * 根据currentStatus的值来决定对图片进行什么样的绘制操作
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (currentStatus) {
            case STATUS_INIT:
                initBitmap(canvas);
                break;
            case STATUS_ZOOM_IN:
            case STATUS_ZOOM_OUT:
                zoom(canvas);
                break;
            case STATUS_MOVE:
                move(canvas);
                break;
            default:
                canvas.drawBitmap(sourchBitmap, matrix, null);
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_POINTER_DOWN:
                if (event.getPointerCount() == 2) {
                    //当有两个手指按在屏幕上时，计算两指之间的距离
                    lastFingerDis = distanceBetweenFingers(event);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getPointerCount() == 1) {
                    //只有单指按在屏幕上移动时，为拖动状态
                    float xMove = event.getX();
                    float yMove = event.getY();
                    if (lastXMove == -1 && lastYMove == -1) {
                        lastXMove = xMove;
                        lastYMove = yMove;
                    }
                    currentStatus = STATUS_MOVE;
                    moveDistanceX = xMove - lastXMove;
                    moveDistanceY = yMove - lastYMove;
                    //进行边界检查，不允许将图片拖出边界
                    if (totalTranslateX + moveDistanceX > 0) {
                        moveDistanceX = 0;
                    } else if (width - (totalTranslateX + moveDistanceX) > currentBitmapWidth) {
                        moveDistanceX = 0;
                    }

                    if (totalTranslateY + moveDistanceY > 0) {
                        moveDistanceY = 0;
                    } else if (height - (totalTranslateY + moveDistanceY) > currentBitmapHeight) {
                        moveDistanceY = 0;
                    }
                    invalidate();
                    lastYMove = yMove;
                    lastXMove = xMove;
                } else if (event.getPointerCount() == 2) {
                    //有两个手指在屏幕上移动时，为缩放状态
                    centerPointBetweenFingers(event);
                    double fingerDis = distanceBetweenFingers(event);
                    if (fingerDis > lastFingerDis) {
                        currentStatus = STATUS_ZOOM_OUT;
                    } else {
                        currentStatus = STATUS_ZOOM_IN;
                    }
                    //进行缩放倍数检查，最大只允许将图片放大四倍，最小缩小到初始化比例
                    if ((currentStatus == STATUS_ZOOM_OUT && totalRatio < 4 * initRatio) ||
                            (currentStatus == STATUS_ZOOM_IN && totalRatio > initRatio)) {
                        scaledRatio = (float) (fingerDis / lastFingerDis);
                        totalRatio = totalRatio * scaledRatio;
                        if (totalRatio > initRatio * 4) {
                            totalRatio = initRatio * 4;
                        } else if (totalRatio < initRatio) {
                            totalRatio = initRatio;
                        }
                        //调用onDraw()方法绘制图片
                        invalidate();
                        lastFingerDis = fingerDis;
                    }
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                if (event.getPointerCount() == 2) {
                    //手指离开屏幕时将临界值还原
                    lastXMove = -1;
                    lastYMove = -1;
                }
                break;
            case MotionEvent.ACTION_UP:
                //手指离开屏幕时将临界值还原
                lastXMove = -1;
                lastYMove = -1;
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * 对图片进行初始化工作，包括让图片居中，以及图片大于屏幕宽高时对图片进行压缩
     */
    public void initBitmap(Canvas canvas) {
        if (sourchBitmap != null) {
            matrix.reset();
            int bitmapWidth = sourchBitmap.getWidth();
            int bitmapHeight = sourchBitmap.getHeight();
            if (bitmapHeight > height || bitmapWidth > width) {
                //当图片宽度大于屏幕宽度时，将图片等比压缩，使其显示在屏幕上
                if (bitmapWidth - width > bitmapHeight - height) {
                    float ratio = width / (bitmapWidth * 1.0f);
                    matrix.postScale(ratio, ratio);
                    float translateY = (height - (bitmapHeight * ratio)) / 2f;
                    //在纵坐标上偏移，以保证图片居中显示
                    matrix.postTranslate(0, translateY);
                    totalTranslateY = translateY;
                    totalRatio = initRatio = ratio;
                } else {// 当图片高度大于屏幕高度时，将图片等比例压缩，使它可以完全显示出来
                    float ratio = height / (bitmapHeight * 1.0f);
                    matrix.postScale(ratio, ratio);
                    float translateX = (width - (bitmapWidth * ratio)) / 2f;
                    matrix.postTranslate(translateX, 0);
                    totalTranslateX = translateX;
                    totalRatio = initRatio = ratio;
                }

            } else {//如果图片款到都小于屏幕宽高，居中显示
                float translateX = (width - sourchBitmap.getWidth()) / 2f;
                float translateY = (height = sourchBitmap.getHeight()) / 2f;
                matrix.postTranslate(translateX, translateY);
                totalTranslateX = translateX;
                totalTranslateY = translateY;
                totalRatio = initRatio = 1f;
                currentBitmapWidth = bitmapWidth;
                currentBitmapHeight = bitmapHeight;
            }
            canvas.drawBitmap(sourchBitmap, matrix, null);
        }
    }

    /**
     * 对图片进行缩放处理
     */
    public void zoom(Canvas canvas) {
        matrix.reset();
        // 将图片按总缩放比例进行缩放
        matrix.postScale(totalRatio, totalRatio);
        float scaledWidth = sourchBitmap.getWidth() * totalRatio;
        float scaledHeight = sourchBitmap.getHeight() * totalRatio;
        float translateX = 0f;
        float translateY = 0f;
        // 如果当前图片宽度小于屏幕宽度，则按屏幕中心的横坐标进行水平缩放。否则按两指的中心点的横坐标进行水平缩放
        if (currentBitmapWidth < width) {
            translateX = (width - scaledWidth) / 2f;
        } else {
            translateX = totalTranslateX * scaledRatio + centerPointX * (1 - scaledRatio);
            // 进行边界检查，保证图片缩放后在水平方向上不会偏移出屏幕
            if (translateX > 0) {
                translateX = 0;
            } else if (width - translateX > scaledWidth) {
                translateX = width - scaledWidth;
            }
        }
        // 如果当前图片高度小于屏幕高度，则按屏幕中心的纵坐标进行垂直缩放。否则按两指的中心点的纵坐标进行垂直缩放
        if (currentBitmapHeight < height) {
            translateY = (height - scaledHeight) / 2f;
        } else {
            translateY = totalTranslateY * scaledRatio + centerPointY * (1 - scaledRatio);
            // 进行边界检查，保证图片缩放后在垂直方向上不会偏移出屏幕
            if (translateY > 0) {
                translateY = 0;
            } else if (height - translateY > scaledHeight) {
                translateY = height - scaledHeight;
            }
        }
        // 缩放后对图片进行偏移，以保证缩放后中心点位置不变
        matrix.postTranslate(translateX, translateY);
        totalTranslateX = translateX;
        totalTranslateY = translateY;
        currentBitmapWidth = scaledWidth;
        currentBitmapHeight = scaledHeight;
        canvas.drawBitmap(sourchBitmap, matrix, null);
    }

    /**
     * 对图片进行平移处理
     */
    public void move(Canvas canvas) {
        matrix.reset();
        //根据手指移动的距离计算出总偏移量
        float translateX = totalTranslateX + moveDistanceX;
        float translateY = totalTranslateY + moveDistanceY;
        //先按照已有的缩放比例对图片进行缩放
        matrix.postScale(totalRatio, totalRatio);
        //再根据移动距离进行偏移
        matrix.postTranslate(translateX, translateY);
        totalTranslateX = translateX;
        totalTranslateY = translateY;
        canvas.drawBitmap(sourchBitmap, matrix, null);
    }

    /**
     * 计算两个手指之间的距离
     */
    public double distanceBetweenFingers(MotionEvent event) {
        float disX = Math.abs(event.getX(0) - event.getX(1));
        float disY = Math.abs(event.getY(0) - event.getY(1));
        return Math.sqrt(disX * disX + disY * disY);
    }

    /**
     * 计算两指中心点坐标
     */
    public void centerPointBetweenFingers(MotionEvent event) {
        float xPoint0 = event.getX(0);
        float yPoint0 = event.getY(0);
        float xPoint1 = event.getX(1);
        float yPoint1 = event.getY(1);
        centerPointX = (int) ((xPoint0 + xPoint1) / 2);
        centerPointY = (int) ((yPoint0 + yPoint1) / 2);
    }

    /**
     * 将待展示的图片设置进来
     */
    public void setImageBitmap(Bitmap bitmap) {
        sourchBitmap = bitmap;
        invalidate();
    }
}
