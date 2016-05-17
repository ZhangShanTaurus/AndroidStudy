package com.zss.example.ui.anim.property_animation.animator_set_code;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：AnimatorSetListenerActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimatorSetListenerActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_one;
    private TextView tv_two;
    private Button btn_start;
    private Button btn_cancel;
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set_listener_layout);
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
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 顺序一次执行
     */
    public AnimatorSet doListenerAnimation() {
        ObjectAnimator oneBgAnimator = ObjectAnimator.ofInt(tv_one, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator oneAnimator = ObjectAnimator.ofFloat(tv_one, "translationY", 0f, 300f);
        ObjectAnimator twoAnimator = ObjectAnimator.ofFloat(tv_two, "translationY", 0f, 300f);
        //第二个动画设置无线循环
        twoAnimator.setRepeatCount(ValueAnimator.INFINITE);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(oneAnimator).with(twoAnimator).after(oneBgAnimator);
        animatorSet.addListener(new Animator.AnimatorListener() {
            /**
             * 当AnimatorSet开始时调用
             * */
            @Override
            public void onAnimationStart(Animator animator) {
                Toast.makeText(AnimatorSetListenerActivity.this, "onAnimationStart()", Toast.LENGTH_SHORT).show();
            }

            /**
             * 当AnimatorSet结束时调用
             * */
            @Override
            public void onAnimationEnd(Animator animator) {
                Toast.makeText(AnimatorSetListenerActivity.this, "onAnimationEnd()", Toast.LENGTH_SHORT).show();
            }

            /**
             * 当AnimatorSet被取消时调用
             * */
            @Override
            public void onAnimationCancel(Animator animator) {
                Toast.makeText(AnimatorSetListenerActivity.this, "onAnimationCancel()", Toast.LENGTH_SHORT).show();
            }

            /**
             * 当AnimatorSet重复执行时调用，由于AnimatorSet没有设置repeat的函数，所以这个方法永远不会被调用
             * */
            @Override
            public void onAnimationRepeat(Animator animator) {
                Toast.makeText(AnimatorSetListenerActivity.this, "onAnimationRepeat()", Toast.LENGTH_SHORT).show();
            }
        });
        animatorSet.setDuration(3000);
        animatorSet.start();
        return animatorSet;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_start:
                animatorSet = doListenerAnimation();
                break;
            case R.id.btn_cancel:
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                break;
            default:
                break;
        }
    }
}
