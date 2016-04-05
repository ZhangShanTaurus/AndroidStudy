package com.android.example.ui.anim.view_animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：AnimationRotateActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimationRotateActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_rotate_xml;
    private TextView tv_rotate_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_rotate_layout);
        initView();
        initData();
        rotateAnimationByJava();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_rotate_xml = (TextView) findViewById(R.id.tv_rotate_xml);
        tv_rotate_java = (TextView) findViewById(R.id.tv_rotate_java);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_rotate);
        tv_rotate_xml.startAnimation(animation);
    }

    /**
     * 使用java代码实旋转放动画
     */
    public void rotateAnimationByJava() {
        AnimationSet animationSet = new AnimationSet(true);
        //参数1：从哪个角度开始
        //参数2：转到什么角度
        //后四个参数用于设置围绕着旋转的圆的圆心在哪里
        //参数3：确定x轴坐标类型，有ABSOLUT表示绝对坐标，RELATIVE_TO_SELF表示相对于自身坐标，RELATIVE_TO_PARENT相对于父控件的坐标
        //参数4：x轴的值，0.5f表明以自身控件的一半长度为x轴
        //参数5：确定y轴坐标类型
        //参数6：y轴的值，0.5f表明以自身控件的一半长度为y轴
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.1f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(3000);
        rotateAnimation.setRepeatCount(3);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        animationSet.addAnimation(rotateAnimation);
        tv_rotate_java.startAnimation(animationSet);
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
