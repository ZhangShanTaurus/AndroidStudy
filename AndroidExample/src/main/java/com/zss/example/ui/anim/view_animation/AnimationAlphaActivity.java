package com.zss.example.ui.anim.view_animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：AnimationAlphaActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimationAlphaActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_alpha_xml;
    private TextView tv_alpha_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_alpha_layout);
        initView();
        initData();
        alphaAnimationByJava();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_alpha_xml = (TextView) findViewById(R.id.tv_alpha_xml);
        tv_alpha_java = (TextView) findViewById(R.id.tv_alpha_java);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_alpha);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(AnimationAlphaActivity.this, "onAnimationStart()", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(AnimationAlphaActivity.this, "onAnimationEnd()", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Toast.makeText(AnimationAlphaActivity.this, "onAnimationRepeat()", Toast.LENGTH_SHORT).show();
            }
        });
        tv_alpha_xml.startAnimation(animation);
    }

    /**
     * 使用java代码实现淡入淡出动画
     */
    public void alphaAnimationByJava() {
        //创建一个AnimationSet对象，参数为boolean类型，true表示使用Animation的interpolator，false表示使用自己的
        AnimationSet animationSet = new AnimationSet(true);
        //创建一个AlphaAnimation对象，参数从完全不透明到完全透明
        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        //设置动画执行时间
        alphaAnimation.setDuration(2000);
        //设置动画执行次数
        alphaAnimation.setRepeatCount(3);
        //设置动画重复模式
        alphaAnimation.setRepeatMode(Animation.RESTART);
        //将alphaAnimation对象添加到animationSet当中
        animationSet.addAnimation(alphaAnimation);
        //使用startAnimation方法开始执行动画
        tv_alpha_java.startAnimation(animationSet);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}
