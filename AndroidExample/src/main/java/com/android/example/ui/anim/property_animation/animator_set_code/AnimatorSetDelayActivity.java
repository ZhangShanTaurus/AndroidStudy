package com.android.example.ui.anim.property_animation.animator_set_code;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：AnimatorSetDelayActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimatorSetDelayActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_one;
    private TextView tv_two;
    private Button btn_one_delay;
    private Button btn_two_delay;
    private Button btn_set_delay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set_delay_layout);
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
        btn_one_delay = (Button) findViewById(R.id.btn_one_delay);
        btn_one_delay.setOnClickListener(this);
        btn_two_delay = (Button) findViewById(R.id.btn_two_delay);
        btn_two_delay.setOnClickListener(this);
        btn_set_delay = (Button) findViewById(R.id.btn_set_delay);
        btn_set_delay.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 第一个动画延迟
     */
    public void doOneDelay() {
        ObjectAnimator oneBgAnimator = ObjectAnimator.ofInt(tv_one, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator oneAnimator = ObjectAnimator.ofFloat(tv_one, "translationY", 0f, 300f);
        oneAnimator.setStartDelay(2000);
        ObjectAnimator twoAnimator = ObjectAnimator.ofFloat(tv_two, "translationY", 0f, 300f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(oneBgAnimator).with(oneAnimator).with(twoAnimator);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }

    /**
     * 第二个动画延迟
     */
    public void doTwoDelay() {
        ObjectAnimator oneBgAnimator = ObjectAnimator.ofInt(tv_one, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator oneAnimator = ObjectAnimator.ofFloat(tv_one, "translationY", 0f, 300f);
        ObjectAnimator twoAnimator = ObjectAnimator.ofFloat(tv_two, "translationY", 0f, 300f);
        twoAnimator.setStartDelay(2000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(oneBgAnimator).with(oneAnimator).with(twoAnimator);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }

    /**
     * AnimatorSet延迟
     */
    public void doSetDelay() {
        ObjectAnimator oneBgAnimator = ObjectAnimator.ofInt(tv_one, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator oneAnimator = ObjectAnimator.ofFloat(tv_one, "translationY", 0f, 300f);
        ObjectAnimator twoAnimator = ObjectAnimator.ofFloat(tv_two, "translationY", 0f, 300f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(oneBgAnimator).with(oneAnimator).with(twoAnimator);
        animatorSet.setStartDelay(2000);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_one_delay:
                doOneDelay();
                break;
            case R.id.btn_two_delay:
                doTwoDelay();
                break;
            case R.id.btn_set_delay:
                doSetDelay();
                break;
            default:
                break;
        }
    }
}
