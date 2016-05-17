package com.zss.example.ui.anim.view_animation;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：AnimationCommonPropertyActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimationListenerActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private ImageView imageView;
    private TextView tv_title;
    private ViewGroup linearLayout;
    private Button btn_add;
    private Button btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_listener_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.imageView);
        tv_title = (TextView) findViewById(R.id.tv_title);
        linearLayout = (ViewGroup) findViewById(R.id.linearLayout);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    public void addView() {
        //淡入
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setStartOffset(300);
        animationSet.addAnimation(alphaAnimation);
        //创建一个新的ImageView
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.style_character_sketch);
        linearLayout.addView(imageView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        imageView.startAnimation(animationSet);
    }

    public void deleteView() {
        //淡出
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setStartOffset(300);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new RemoveAnimationListener());
        imageView.startAnimation(animationSet);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_add:
                addView();
                break;
            case R.id.btn_delete:
                deleteView();
                break;
            default:
                break;
        }
    }

    private class RemoveAnimationListener implements Animation.AnimationListener {
        //动画开始时调用
        @Override
        public void onAnimationStart(Animation animation) {
            Toast.makeText(AnimationListenerActivity.this, "开始执行动画啦", Toast.LENGTH_SHORT).show();
        }

        //动画结束时调用
        @Override
        public void onAnimationEnd(Animation animation) {
            //动画效果执行完时remove
            if (linearLayout != null && imageView != null) {
                //此方法报空指针异常
//                linearLayout.removeView(imageView);
            }
            Toast.makeText(AnimationListenerActivity.this, "动画执行结束啦", Toast.LENGTH_SHORT).show();
        }

        //动画重复时调用
        @Override
        public void onAnimationRepeat(Animation animation) {
            Toast.makeText(AnimationListenerActivity.this, "重复执行动画啦", Toast.LENGTH_SHORT).show();
        }
    }
}
