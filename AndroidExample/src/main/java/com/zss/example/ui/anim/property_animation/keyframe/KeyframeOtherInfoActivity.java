package com.zss.example.ui.anim.property_animation.keyframe;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：KeyframeOtherInfoActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class KeyframeOtherInfoActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private ImageView imageView;
    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyframe_other_info_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        imageView = (ImageView) findViewById(R.id.imageView);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
    }

    public void doAnimator() {
        //rotate
        Keyframe keyframe01 = Keyframe.ofFloat(0f, 0f);
        Keyframe keyframe02 = Keyframe.ofFloat(0.2f, -20f);
        Keyframe keyframe03 = Keyframe.ofFloat(0.4f, 20f);
        Keyframe keyframe04 = Keyframe.ofFloat(0.6f, -20f);
        Keyframe keyframe05 = Keyframe.ofFloat(0.8f, 20f);
        Keyframe keyframe06 = Keyframe.ofFloat(1f, 0f);
        //scaleX
        Keyframe keyframe11 = Keyframe.ofFloat(0f, 1f);
        Keyframe keyframe12 = Keyframe.ofFloat(0.2f, 1.2f);
        Keyframe keyframe13 = Keyframe.ofFloat(0.4f, 1.2f);
        Keyframe keyframe14 = Keyframe.ofFloat(0.6f, 1.2f);
        Keyframe keyframe15 = Keyframe.ofFloat(0.8f, 1.2f);
        Keyframe keyframe16 = Keyframe.ofFloat(1f, 1f);
        //scaleY
        Keyframe keyframe21 = Keyframe.ofFloat(0f, 1f);
        Keyframe keyframe22 = Keyframe.ofFloat(0.2f, 1.2f);
        Keyframe keyframe23 = Keyframe.ofFloat(0.4f, 1.2f);
        Keyframe keyframe24 = Keyframe.ofFloat(0.6f, 1.2f);
        Keyframe keyframe25 = Keyframe.ofFloat(0.8f, 1.2f);
        Keyframe keyframe26 = Keyframe.ofFloat(1f, 1f);

        PropertyValuesHolder rotateHolder = PropertyValuesHolder.ofKeyframe("rotation", keyframe01, keyframe02, keyframe03, keyframe04, keyframe05, keyframe06);
        PropertyValuesHolder scaleXHolder = PropertyValuesHolder.ofKeyframe("scaleX", keyframe11, keyframe12, keyframe13, keyframe14, keyframe15, keyframe16);
        PropertyValuesHolder scaleYHolder = PropertyValuesHolder.ofKeyframe("scaleY", keyframe21, keyframe22, keyframe23, keyframe24, keyframe25, keyframe26);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView, rotateHolder, scaleXHolder, scaleYHolder);
        animator.setDuration(3000);
        animator.start();
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
                doAnimator();
                break;
            default:
                break;
        }
    }
}
