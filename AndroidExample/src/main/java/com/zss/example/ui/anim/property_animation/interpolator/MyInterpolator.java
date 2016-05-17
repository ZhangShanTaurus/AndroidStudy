package com.zss.example.ui.anim.property_animation.interpolator;

import android.animation.TimeInterpolator;

/**
 * 描述：MyInterpolator
 * Created by Administrator on 2016/3/4 0004.
 */
public class MyInterpolator implements TimeInterpolator {
    //好好理解这个方法的参数跟返回值
    @Override
    public float getInterpolation(float input) {
        return 1 - input;
    }
}
