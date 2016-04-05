package com.android.example.ui.anim.property_animation.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 描述：ObjectAnimatorPointView
 * Created by Administrator on 2016/3/4 0004.
 */
public class ObjectAnimatorPointView extends View {
    private Point mPoint = new Point(100);

    public ObjectAnimatorPointView(Context context) {
        super(context);
    }

    public ObjectAnimatorPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPoint != null) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(500, 200, mPoint.getRadius(), paint);
        }
    }

    public int getPointRadius() {
        return 0;
    }

    public void setPointRadius(int radius) {
        mPoint.setRadius(radius);
        //刷新
        invalidate();
    }
}
