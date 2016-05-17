package com.zss.example.ui.anim.view_animation;

import android.os.Bundle;
import android.view.View;
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
 * 描述：AnimationScaleActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimationScaleActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_scale_xml;
    private TextView tv_scale_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_scale_layout);
        initView();
        initData();
        scaleAnimationByJava();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_scale_xml = (TextView) findViewById(R.id.tv_scale_xml);
        tv_scale_java = (TextView) findViewById(R.id.tv_scale_java);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_scale);
        tv_scale_xml.startAnimation(animation);
    }

    /**
     * 使用java代码实现缩放动画
     */
    public void scaleAnimationByJava() {
        AnimationSet animationSet = new AnimationSet(true);
        //参数1：x轴的初始值
        //参数2：x轴收缩后的值
        //参数3：y轴的初始值
        //参数4：y轴收缩后的值
        //参数5：确定x轴坐标的类型
        //参数6：x轴的值，0.5f表示是以自身这个控件的一半长度为x轴
        //参数7：确定y轴坐标的类型
        //参数8：y轴的值，0.5f表示是以自身这个控件的一半长度为y轴
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                0, 2.0f,
                0, 2.0f,
                Animation.RELATIVE_TO_SELF, 0.3f,
                Animation.RELATIVE_TO_SELF, 0.8f);

        scaleAnimation.setDuration(3000);
        scaleAnimation.setRepeatCount(3);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        animationSet.addAnimation(scaleAnimation);
        tv_scale_java.startAnimation(animationSet);
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
