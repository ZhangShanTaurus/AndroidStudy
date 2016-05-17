package com.zss.example.ui.anim.property_animation.animator_set_code;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：AnimatorSetSetActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimatorSetSetActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_one;
    private TextView tv_two;
    private Button btn_setInterpolator;
    private Button setTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set_set_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_one = (TextView) findViewById(R.id.tv_one);
        tv_two = (TextView) findViewById(R.id.tv_two);
        btn_setInterpolator = (Button) findViewById(R.id.btn_setInterpolator);
        btn_setInterpolator.setOnClickListener(this);
        setTarget = (Button) findViewById(R.id.btn_setTarget);
        setTarget.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 设置加速器
     */
    public void doSetInterpolator() {
        //为每个ObjectAnimator设置加速器
        ObjectAnimator oneBgAnimator = ObjectAnimator.ofInt(tv_one, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator oneAnimator = ObjectAnimator.ofFloat(tv_one, "translationY", 0f, 400f);
        oneAnimator.setInterpolator(new BounceInterpolator());
        ObjectAnimator twoAnimator = ObjectAnimator.ofFloat(tv_two, "translationY", 0f, 500f);
        twoAnimator.setInterpolator(new AccelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(oneBgAnimator, oneAnimator, twoAnimator);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }

    /**
     * 设置Target
     */
    public void doSetTarget() {
        ObjectAnimator oneBgAnimator = ObjectAnimator.ofInt(tv_one, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator oneAnimator = ObjectAnimator.ofFloat(tv_one, "translationY", 0f, 400f);
        oneAnimator.setInterpolator(new BounceInterpolator());
        ObjectAnimator twoAnimator = ObjectAnimator.ofFloat(tv_two, "translationY", 0f, 500f);
        twoAnimator.setInterpolator(new AccelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(oneBgAnimator, oneAnimator, twoAnimator);
        animatorSet.setDuration(3000);
        //设置动画执行目标
        animatorSet.setTarget(tv_two);
        animatorSet.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_setInterpolator:
                doSetInterpolator();
                break;
            case R.id.btn_setTarget:
                doSetTarget();
                break;
            default:
                break;
        }
    }
}
