package com.zss.example.ui.anim.property_animation.evaluator;

import android.animation.TypeEvaluator;

/**
 * 描述：MyEvaluator
 * Created by Administrator on 2016/3/4 0004.
 */
public class MyEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        return (int) (endValue - fraction * (endValue - startInt));
    }
}
