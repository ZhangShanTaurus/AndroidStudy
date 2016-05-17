package com.zss.example.ui.custom_view.extends_view.bezier_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

/**
 * 描述：贝塞尔曲线
 * Created by Administrator on 2016/4/1 0001.
 */
public class BezierView extends View {
    private Paint paint;
    private Path path;
    private Point startPoint;
    private Point endPoint;
    private Point assistPoint; //辅助点
    private int screenWidth;
    private int screenHeight;

    public BezierView(Context context) {
        this(context, null);
    }

    public BezierView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
        paint.setDither(true);//防抖动
        path = new Path();
        startPoint = new Point(300, 600);
        endPoint = new Point(900, 600);
        assistPoint = new Point(600, 900);
        getScreenSize(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measure(widthMeasureSpec), measure(heightMeasureSpec));
    }

    /**
     * 测量
     */
    private int measure(int measureSpec) {
        int result;
        int measureSize = MeasureSpec.getSize(measureSpec);
        int measureMode = MeasureSpec.getMode(measureSpec);
        if (measureMode == MeasureSpec.EXACTLY) {
            result = measureSize;
        } else {
            result = 600;//单位是px
            if (measureMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, measureSize);
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);//黑色
        paint.setStrokeWidth(2);//画笔宽
        paint.setStyle(Paint.Style.STROKE);//空心
        path.reset();//重置路径
        path.moveTo(startPoint.x, startPoint.y);//起点
        path.quadTo(assistPoint.x, assistPoint.y, endPoint.x, endPoint.y);//重点是这句
        canvas.drawPath(path, paint);//画路径
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        canvas.drawPoint(assistPoint.x, assistPoint.y, paint);//画辅助点
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                assistPoint.x = (int) event.getX();
                assistPoint.y = (int) event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    /**
     * 获取屏幕宽高尺寸
     */
    private void getScreenSize(Context context) {
        //DisplayMetrics dm=new DisplayMetrics();
        //getWindowManager().getDefaultDisplay().getMetrics(dm);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
    }
}
