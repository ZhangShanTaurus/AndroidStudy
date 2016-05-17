package com.zss.example.ui.anim.property_animation.animator_set_xml;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：AnimatorSetXMLAnimatorActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimatorSetXMLAnimatorActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView textView;
    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_animator_set_xml_animator_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        textView = (TextView) findViewById(com.zss.example.R.id.textView);
        btn_start = (Button) findViewById(com.zss.example.R.id.btn_start);
        btn_start.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 顺序一次执行
     */
    public void doAnimator() {
        ValueAnimator animator = (ValueAnimator) AnimatorInflater.loadAnimator(this, com.zss.example.R.animator.animator);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int offset = (int) valueAnimator.getAnimatedValue();
                textView.layout(offset, offset, textView.getWidth() + offset, textView.getHeight() + offset);
            }
        });
        animator.start();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case com.zss.example.R.id.iv_back:
                onBackPressed();
                break;
            case com.zss.example.R.id.btn_start:
                doAnimator();
                break;
            default:
                break;
        }
    }
}
