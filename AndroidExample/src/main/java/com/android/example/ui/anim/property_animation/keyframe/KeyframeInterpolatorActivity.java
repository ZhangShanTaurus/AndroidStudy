package com.android.example.ui.anim.property_animation.keyframe;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：KeyframeInterpolatorActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class KeyframeInterpolatorActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_start;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyframe_interpolator_layout);
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
        textView = (TextView) findViewById(R.id.textView);
    }

    public void doAnimator() {
        Keyframe kf0 = Keyframe.ofFloat(0.0f, 20f);
        Keyframe kf5 = Keyframe.ofFloat(0.5f, -20f);
        Keyframe kf10 = Keyframe.ofFloat(1f, 0f);
        kf5.setInterpolator(new BounceInterpolator());
        kf10.setInterpolator(new AccelerateInterpolator());
        PropertyValuesHolder rotateHolder = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf5, kf10);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(textView, rotateHolder);
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
