package com.zss.example.ui.anim.property_animation.value_animation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;
import com.zss.example.ui.anim.property_animation.evaluator.CharEvaluator;
import com.zss.example.ui.anim.property_animation.sample.ValueAnimatorPointView;

/**
 * 描述：ValueAnimator3Activity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ValueAnimator3Activity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_animator;
    private Button btn_start_animator;
    private Button btn_cancel_animator;
    private ValueAnimatorPointView valueAnimatorPointView;
    private ValueAnimator valueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_value_animator3_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        tv_animator = (TextView) findViewById(com.zss.example.R.id.tv_animator);
        btn_start_animator = (Button) findViewById(com.zss.example.R.id.btn_start_animator);
        btn_start_animator.setOnClickListener(this);
        btn_cancel_animator = (Button) findViewById(com.zss.example.R.id.btn_cancel_animator);
        btn_cancel_animator.setOnClickListener(this);
        valueAnimatorPointView = (ValueAnimatorPointView) findViewById(com.zss.example.R.id.pointView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 执行动画
     */
    public void doAnimator() {
        valueAnimator = ValueAnimator.ofObject(new CharEvaluator(), new Character('A'), new Character('z'));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                char curValue = (char) valueAnimator.getAnimatedValue();
                tv_animator.setText(String.valueOf(curValue));
            }
        });
        //设置动画时间
        valueAnimator.setDuration(5000);
        //开始动画
        valueAnimator.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case com.zss.example.R.id.iv_back:
                onBackPressed();
                break;
            case com.zss.example.R.id.btn_start_animator:
                doAnimator();
                valueAnimatorPointView.doAnimation();
                break;
            case com.zss.example.R.id.btn_cancel_animator:
                if (valueAnimator != null) {
                    //取消动画
                    valueAnimator.cancel();
                }
                valueAnimatorPointView.cancelAnimation();
                break;
            default:
                break;
        }
    }
}
