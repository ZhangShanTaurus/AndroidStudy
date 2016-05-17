package com.zss.example.ui.anim.property_animation.evaluator;

import android.animation.TypeEvaluator;

import com.zss.example.ui.anim.property_animation.sample.Point;

/**
 * 描述：PointEvaluator
 * Created by Administrator on 2016/3/4 0004.
 */
public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int start = startValue.getRadius();
        int end = endValue.getRadius();
        int radius = (int) (start + fraction * (end - start));
        return new Point(radius);
    }
}
