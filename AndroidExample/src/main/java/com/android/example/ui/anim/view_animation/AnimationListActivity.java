package com.android.example.ui.anim.view_animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：AnimationListActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimationListActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private ImageView imageView;
    private Button btn_start;
    private Button btn_one_shot;
    private AnimationDrawable animationDrawable;
    private boolean isOneshot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_list_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        imageView = (ImageView) findViewById(R.id.imageView);
        animationDrawable = (AnimationDrawable) imageView.getDrawable();
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
        btn_one_shot = (Button) findViewById(R.id.btn_one_shot);
        btn_one_shot.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_start:
                startAnimation();
                break;
            case R.id.btn_one_shot:
                if (isOneshot) {
                    btn_one_shot.setText("Once");
                } else {
                    btn_one_shot.setText("Repeat");
                }
                animationDrawable.setOneShot(!isOneshot);
                isOneshot = !isOneshot;
                break;
            default:
                break;
        }
    }

    /**
     * 通过AnimationDrawable的start函数播放动画，
     * stop函数停止动画播放，
     * isRunning来判断动画是否正在播放。
     */
    public void startAnimation() {
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
            btn_start.setText("Start");
        } else {
            animationDrawable.stop();
            animationDrawable.start();
            btn_start.setText("Stop");
        }
    }
}
