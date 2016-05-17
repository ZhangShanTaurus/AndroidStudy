package com.zss.example.ui.anim.view_animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：AnimationSetActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimationSetActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_animation_set_xml;
    private TextView tv_animation_set_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_set_layout);
        initView();
        initData();
        animationSetByJava();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_animation_set_xml = (TextView) findViewById(R.id.tv_animation_set_xml);
        tv_animation_set_java = (TextView) findViewById(R.id.tv_animation_set_java);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        Animation set = AnimationUtils.loadAnimation(this, R.anim.animation_set);
        tv_animation_set_xml.startAnimation(set);

    }

    public void animationSetByJava() {
        AnimationSet animationSet = new AnimationSet(true);

        AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setRepeatCount(3);

        ScaleAnimation scaleAnimation = new ScaleAnimation(
                0, 2.0f,
                0, 2.0f,
                Animation.RELATIVE_TO_SELF, 0.3f,
                Animation.RELATIVE_TO_SELF, 0.8f);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setRepeatCount(3);

        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        tv_animation_set_java.startAnimation(animationSet);
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
