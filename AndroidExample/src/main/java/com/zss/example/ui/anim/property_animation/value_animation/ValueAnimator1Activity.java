package com.zss.example.ui.anim.property_animation.value_animation;

import android.animation.Animator;
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
 * 描述：ValueAnimator1Activity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ValueAnimator1Activity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_animator;
    private Button btn_start_animator;
    private Button btn_cancel_animator;
    private Button btn_remove_update_listener;
    private Button btn_remove_state_listener;

    private ValueAnimator valueAnimator;
    private ValueAnimator cloneAnimator;//克隆的动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator1_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_animator = (TextView) findViewById(R.id.tv_animator);
        tv_animator.setOnClickListener(this);
        btn_start_animator = (Button) findViewById(R.id.btn_start_animator);
        btn_start_animator.setOnClickListener(this);
        btn_cancel_animator = (Button) findViewById(R.id.btn_cancel_animator);
        btn_cancel_animator.setOnClickListener(this);
        btn_remove_update_listener = (Button) findViewById(R.id.btn_remove_update_listener);
        btn_remove_update_listener.setOnClickListener(this);
        btn_remove_state_listener = (Button) findViewById(R.id.btn_remove_state_listener);
        btn_remove_state_listener.setOnClickListener(this);
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
        valueAnimator = ValueAnimator.ofInt(0, 600, 200);
        //设置监听动画的实时值
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //获取ValueAnimator运动时，运动点的值
                int curValue = (int) valueAnimator.getAnimatedValue();
                //通过layout函数改变TextView位置，改变的位置是永久性的
                tv_animator.layout(tv_animator.getLeft(), curValue, tv_animator.getRight(), curValue + tv_animator.getHeight());
            }
        });
        //设置监听动画变化的四个状态
        valueAnimator.addListener(new Animator.AnimatorListener() {
            //开始动画
            @Override
            public void onAnimationStart(Animator animator) {
                Toast.makeText(ValueAnimator1Activity.this, "开始动画", Toast.LENGTH_SHORT).show();
            }

            //动画结束
            @Override
            public void onAnimationEnd(Animator animator) {
                Toast.makeText(ValueAnimator1Activity.this, "结束动画", Toast.LENGTH_SHORT).show();
            }

            //取消动画
            @Override
            public void onAnimationCancel(Animator animator) {
                Toast.makeText(ValueAnimator1Activity.this, "取消动画", Toast.LENGTH_SHORT).show();
            }

            //动画重复
            @Override
            public void onAnimationRepeat(Animator animator) {
                Toast.makeText(ValueAnimator1Activity.this, "动画重复", Toast.LENGTH_SHORT).show();
            }
        });
        //设置循环次数，ValueAnimator.INFINITE表示无限循环,0表示不循环
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        //设置循环模式，RESTART,REVERSE
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        //设置动画时间
        valueAnimator.setDuration(3000);
        //设置动画延迟时间再开始
        valueAnimator.setStartDelay(500);
        //开始动画
        valueAnimator.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_start_animator:
                doAnimator();
                cloneAnimator = valueAnimator.clone();
                cloneAnimator.start();
                break;
            case R.id.btn_cancel_animator:
                if (valueAnimator != null) {
                    //取消动画
                    valueAnimator.cancel();
                }
                break;
            case R.id.btn_remove_update_listener:
                if (valueAnimator != null) {
                    //移除所有实时动作监听器
                    valueAnimator.removeAllUpdateListeners();
                }
                break;
            case R.id.btn_remove_state_listener:
                if (valueAnimator != null) {
                    //移除所有的状态监听器
                    valueAnimator.removeAllListeners();
                }
                break;
            case R.id.tv_animator:
                Toast.makeText(ValueAnimator1Activity.this, "ValueAnimator", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
