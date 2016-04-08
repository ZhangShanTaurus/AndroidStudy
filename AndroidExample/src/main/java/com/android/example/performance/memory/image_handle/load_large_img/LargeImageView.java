package com.android.example.performance.memory.image_handle.load_large_img;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.io.InputStream;

/**
 * 描述：LargeImageView(加载高清大图，不压缩，采用局部展示方式)
 * Created by Administrator on 2016/4/8 0008.
 */
public class LargeImageView extends View {
    private BitmapRegionDecoder regionDecoder;
    /**
     * 图片的宽度和高度
     */
    private int imageWidth, imageHeight;
    /**
     * 绘制区域
     */
    private volatile Rect rect = new Rect();
    /**
     *
     * */
    private static final BitmapFactory.Options options = new BitmapFactory.Options();
    /**
     * 手势
     */
    MoveGestureDetector detector;

    static {
        options.inPreferredConfig = Bitmap.Config.RGB_565;
    }

    public LargeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = regionDecoder.decodeRegion(rect, options);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap, 0, 0, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int imageW = imageWidth;
        int imageH = imageHeight;
        //默认显示图片的中心区域
        rect.left = imageW / 2 - width / 2;
        rect.top = imageH / 2 - height / 2;
        rect.right = rect.left + width;
        rect.bottom = rect.top + height;
    }

    public void setInputStream(InputStream inputStream) {
        try {
            regionDecoder = BitmapRegionDecoder.newInstance(inputStream, false);
            BitmapFactory.Options tempOptions = new BitmapFactory.Options();
            tempOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);
            imageHeight = options.outHeight;
            imageWidth = options.outWidth;

            requestLayout();
            invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void init() {
        detector = new MoveGestureDetector(getContext(), new MoveGestureDetector.SimpleMoveGestureDetector() {
            @Override
            public boolean onMove(MoveGestureDetector detector) {
                int moveX = (int) detector.getMoveX();
                int moveY = (int) detector.getMoveY();
                if (imageWidth > getWidth()) {
                    rect.offset(-moveX, 0);
                    checkWidth();
                    invalidate();
                }
                if (imageHeight > getHeight()) {
                    rect.offset(0, -moveY);
                    checkHeight();
                    invalidate();
                }
                return true;
            }
        });
    }

    public void checkWidth() {
        Rect tempRect = rect;
        int imageW = imageWidth;
        int imageH = imageHeight;
        if (tempRect.right > imageW) {
            tempRect.right = imageW;
            tempRect.left = imageW - getWidth();
        }
        if (tempRect.left < 0) {
            tempRect.left = 0;
            tempRect.right = getWidth();
        }
    }

    public void checkHeight() {
        Rect tempRect = rect;
        int imageW = imageWidth;
        int imageH = imageHeight;
        if (tempRect.bottom > imageH) {
            tempRect.bottom = imageH;
            tempRect.top = imageH - getHeight();
        }
        if (tempRect.top < 0) {
            tempRect.top = 0;
            tempRect.bottom = getHeight();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onToucEvent(event);
        return true;
    }
}
