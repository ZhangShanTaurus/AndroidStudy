package com.android.example.ui.anim.property_animation.object_animation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;
import com.android.example.ui.anim.property_animation.sample.ObjectAnimatorPointView;

/**
 * 描述：ObjectAnimatorDefineActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ObjectAnimatorDefineActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_start_animator;
    private ObjectAnimatorPointView pointView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator_define_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_start_animator = (Button) findViewById(R.id.btn_start_animator);
        btn_start_animator.setOnClickListener(this);
        pointView = (ObjectAnimatorPointView) findViewById(R.id.objectAnimatorPointView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    public void startAnimator() {
        ObjectAnimator animator = ObjectAnimator.ofInt(pointView, "pointRadius", 0, 400, 100);
        animator.setDuration(2000);
        animator.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_start_animator:
                startAnimator();
                break;
            default:
                break;
        }
    }
}
