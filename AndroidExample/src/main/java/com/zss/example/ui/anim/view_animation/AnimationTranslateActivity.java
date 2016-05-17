package com.zss.example.ui.anim.view_animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：AnimationTranslateActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimationTranslateActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_translate_xml;
    private TextView tv_translate_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_translate_layout);
        initView();
        initData();
        translateAnimationByJava();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_translate_xml = (TextView) findViewById(R.id.tv_translate_xml);
        tv_translate_java = (TextView) findViewById(R.id.tv_translate_java);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_translate);
        tv_translate_xml.startAnimation(animation);
    }

    /**
     * 使用java代码实现位移动画
     */
    public void translateAnimationByJava() {
        AnimationSet animationSet = new AnimationSet(true);
        //参数1-2：x轴的开始位置
        //参数3-4：x轴的结束位置
        //参数5-6：y轴的开始位置
        //参数7-8：y轴的结束位置
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        translateAnimation.setDuration(3000);
        translateAnimation.setRepeatCount(3);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        animationSet.addAnimation(translateAnimation);
        tv_translate_java.startAnimation(animationSet);
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
