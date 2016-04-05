package com.android.example.ui.anim.property_animation.value_animation;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;
import com.android.example.ui.anim.property_animation.evaluator.MyEvaluator;
import com.android.example.ui.anim.property_animation.interpolator.MyInterpolator;

/**
 * 描述：ValueAnimator2Activity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ValueAnimator2Activity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_animator;
    private TextView tv_info;
    private Button btn_start_animator;
    private Button btn_cancel_animator;
    private Button btn_interpolator;
    private Button btn_evaluator;

    private ValueAnimator valueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator2_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_animator = (TextView) findViewById(R.id.tv_animator);
        btn_start_animator = (Button) findViewById(R.id.btn_start_animator);
        btn_start_animator.setOnClickListener(this);
        btn_cancel_animator = (Button) findViewById(R.id.btn_cancel_animator);
        btn_cancel_animator.setOnClickListener(this);
        btn_interpolator = (Button) findViewById(R.id.btn_interpolator);
        btn_interpolator.setOnClickListener(this);
        btn_evaluator = (Button) findViewById(R.id.btn_evaluator);
        btn_evaluator.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 执行颜色变化动画
     */
    public void doAgbAnimator() {
        ValueAnimator animator = ValueAnimator.ofInt(0xffffff00, 0xff0000ff);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int backgroundColor = (int) valueAnimator.getAnimatedValue();
                tv_info.setBackgroundColor(backgroundColor);
            }
        });
        animator.start();
    }

    /**
     * 执行动画
     */
    public void doAnimator(TimeInterpolator interpolator, TypeEvaluator evaluator) {
        valueAnimator = ValueAnimator.ofInt(0, 400);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //获取ValueAnimator运动时，运动点的值
                int curValue = (int) valueAnimator.getAnimatedValue();
                //通过layout函数改变TextView位置，改变的位置是永久性的
                tv_animator.layout(tv_animator.getLeft(), curValue, tv_animator.getRight(), curValue + tv_animator.getHeight());
            }
        });
        if (interpolator != null) {
            valueAnimator.setInterpolator(interpolator);
        }
        if (evaluator != null) {
            valueAnimator.setEvaluator(evaluator);
        }
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.setDuration(1000);
        valueAnimator.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_start_animator:
                doAnimator(null, null);
                doAgbAnimator();
                break;
            case R.id.btn_cancel_animator:
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                break;
            case R.id.btn_interpolator:
                doAnimator(new MyInterpolator(), null);
                break;
            case R.id.btn_evaluator:
                doAnimator(null, new MyEvaluator());
                break;
            default:
                break;
        }
    }
}
