package com.android.example.ui.anim.property_animation.sample;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.android.example.ui.anim.property_animation.evaluator.PointEvaluator;

/**
 * 描述：ValueAnimatorPointView
 * Created by Administrator on 2016/3/4 0004.
 */
public class ValueAnimatorPointView extends View {
    private Point mPoint;

    public ValueAnimatorPointView(Context context) {
        super(context);
    }

    public ValueAnimatorPointView(Context context, AttributeSet attrs) {
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
            canvas.drawCircle(300, 300, mPoint.getRadius(), paint);
        }
    }

    private ValueAnimator animator;

    /**
     * 执行动画
     */
    public void doAnimation() {
        animator = ValueAnimator.ofObject(new PointEvaluator(), new Point(20), new Point(200));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mPoint = (Point) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(5000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

    /**
     * 停止动画
     */
    public void cancelAnimation() {
        if (animator != null) {
            animator.cancel();
        }
    }
}
