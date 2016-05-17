package com.zss.example.ui.anim.property_animation.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 描述：MyTextView
 * Created by Administrator on 2016/3/7 0007.
 */
public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 设置文字
     */
    public void setCharText(Character character) {
        setText(String.valueOf(character));
    }
}
