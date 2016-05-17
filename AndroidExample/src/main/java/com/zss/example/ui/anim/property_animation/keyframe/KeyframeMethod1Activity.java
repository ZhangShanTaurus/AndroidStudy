package com.zss.example.ui.anim.property_animation.keyframe;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：KeyframeMethod1Activity
 * Created by Administrator on 2016/1/21 0021.
 */
public class KeyframeMethod1Activity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_start;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyframe_method1_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void doAnimator() {
        Keyframe kf0 = Keyframe.ofFloat(0.0f, 20f);
        Keyframe kf1 = Keyframe.ofFloat(0.1f, -20f);
        Keyframe kf2 = Keyframe.ofFloat(0.2f, 20f);
        Keyframe kf3 = Keyframe.ofFloat(0.3f, -20f);
        Keyframe kf4 = Keyframe.ofFloat(0.4f, 20f);
        Keyframe kf5 = Keyframe.ofFloat(0.5f, -20f);
        Keyframe kf6 = Keyframe.ofFloat(0.6f, 20f);
        Keyframe kf7 = Keyframe.ofFloat(0.7f, -20f);
        Keyframe kf8 = Keyframe.ofFloat(0.8f, 20f);
        Keyframe kf9 = Keyframe.ofFloat(0.9f, -20f);
        Keyframe kf10 = Keyframe.ofFloat(1f, 0f);
        PropertyValuesHolder rotateHolder = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1, kf2,
                kf3, kf4, kf5, kf6, kf7, kf8, kf9, kf10);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView, rotateHolder);
        animator.setDuration(2000);
        animator.start();
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_start:
                doAnimator();
                break;
            default:
                break;
        }
    }
}
