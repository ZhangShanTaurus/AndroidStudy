package com.zss.example.ui.anim.view_animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：AnimationInterpolatorActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimationInterpolatorActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_interpolator;
    private Button btn_accelerate;
    private Button btn_decelerate;
    private Button btn_accelerate_decelerate;
    private Button btn_anticipate;
    private Button btn_overshoot;
    private Button btn_anticipate_overshoot;
    private Button btn_bounce;
    private Button btn_linear;
    private Button btn_cycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_interpolator_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_interpolator = (TextView) findViewById(R.id.tv_interpolator);
        btn_accelerate = (Button) findViewById(R.id.btn_accelerate);
        btn_accelerate.setOnClickListener(this);
        btn_decelerate = (Button) findViewById(R.id.btn_decelerate);
        btn_decelerate.setOnClickListener(this);
        btn_accelerate_decelerate = (Button) findViewById(R.id.btn_accelerate_decelerate);
        btn_accelerate_decelerate.setOnClickListener(this);
        btn_anticipate = (Button) findViewById(R.id.btn_anticipate);
        btn_anticipate.setOnClickListener(this);
        btn_overshoot = (Button) findViewById(R.id.btn_overshoot);
        btn_overshoot.setOnClickListener(this);
        btn_anticipate_overshoot = (Button) findViewById(R.id.btn_anticipate_overshoot);
        btn_anticipate_overshoot.setOnClickListener(this);
        btn_bounce = (Button) findViewById(R.id.btn_bounce);
        btn_bounce.setOnClickListener(this);
        btn_linear = (Button) findViewById(R.id.btn_linear);
        btn_linear.setOnClickListener(this);
        btn_cycle = (Button) findViewById(R.id.btn_cycle);
        btn_cycle.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 设置插值器
     */
    public void setInterpolator(Interpolator interpolator) {
        AnimationSet animationSet = new AnimationSet(true);
        //如果共享interpolator，可以在animation中设置interpolator
        animationSet.setInterpolator(interpolator);
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0.8f,
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0f);

        translateAnimation.setDuration(3000);
//        translateAnimation.setRepeatCount(3);
        //如果不共享interpolator，可以在每个animation中设置interpolator
//        translateAnimation.setInterpolator(interpolator);
//        translateAnimation.setRepeatMode(Animation.REVERSE);
        animationSet.addAnimation(translateAnimation);
        tv_interpolator.startAnimation(animationSet);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_accelerate:
                setInterpolator(new AccelerateInterpolator());
                break;
            case R.id.btn_decelerate:
                setInterpolator(new DecelerateInterpolator());
                break;
            case R.id.btn_accelerate_decelerate:
                setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            case R.id.btn_anticipate:
                setInterpolator(new AnticipateInterpolator());
                break;
            case R.id.btn_overshoot:
                setInterpolator(new OvershootInterpolator());
                break;
            case R.id.btn_anticipate_overshoot:
                setInterpolator(new AnticipateOvershootInterpolator());
                break;
            case R.id.btn_bounce:
                setInterpolator(new BounceInterpolator());
                break;
            case R.id.btn_linear:
                setInterpolator(new LinearInterpolator());
                break;
            case R.id.btn_cycle:
                setInterpolator(new CycleInterpolator(0.5f));
                break;
            default:
                break;
        }
    }
}
