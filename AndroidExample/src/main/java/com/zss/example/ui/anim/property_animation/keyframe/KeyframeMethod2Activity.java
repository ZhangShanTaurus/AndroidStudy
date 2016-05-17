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
import com.zss.example.ui.anim.property_animation.evaluator.CharEvaluator;
import com.zss.example.ui.anim.property_animation.sample.MyTextView;

/**
 * 描述：KeyframeMethod2Activity
 * Created by Administrator on 2016/1/21 0021.
 */
public class KeyframeMethod2Activity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_start;
    private MyTextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyframe_method2_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
        textView = (MyTextView) findViewById(R.id.textView);
    }

    public void doAnimator() {
        Keyframe kf0 = Keyframe.ofObject(0, new Character('A'));
        Keyframe kf1 = Keyframe.ofObject(0.3f, new Character('L'));
        Keyframe kf2 = Keyframe.ofObject(1, new Character('Z'));
        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("CharText", kf0, kf1, kf2);
        //一定要设置Evaluator
        holder.setEvaluator(new CharEvaluator());
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(textView, holder);
        animator.setDuration(2000);
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
