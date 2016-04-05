package com.android.example.ui.anim.property_animation.evaluator;

import android.animation.TypeEvaluator;

/**
 * 描述：CharEvaluator
 * Created by Administrator on 2016/3/4 0004.
 */
public class CharEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt = startValue;
        return (char) (startInt + fraction * (endValue - startInt));
    }
}
