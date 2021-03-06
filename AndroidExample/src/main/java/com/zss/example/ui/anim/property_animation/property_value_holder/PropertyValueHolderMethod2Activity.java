package com.zss.example.ui.anim.property_animation.property_value_holder;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;
import com.zss.example.ui.anim.property_animation.evaluator.CharEvaluator;
import com.zss.example.ui.anim.property_animation.sample.MyTextView;

/**
 * 描述：PropertyValueHolderMethod2Activity
 * Created by Administrator on 2016/1/21 0021.
 */
public class PropertyValueHolderMethod2Activity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private MyTextView textView;
    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_value_holder_method2_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        textView = (MyTextView) findViewById(R.id.textView);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 执行动画
     */
    public void doAnimator() {
        PropertyValuesHolder rotateHolder = PropertyValuesHolder.ofObject("charText", new CharEvaluator(), new Character('A'), new Character('Z'));
        rotateHolder.setEvaluator(new CharEvaluator());
        PropertyValuesHolder colorHolder = PropertyValuesHolder.ofInt("BackgroundColor", 0xffffffff, 0xffff00ff, 0xffffff00, 0xffffffff);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(textView, rotateHolder, colorHolder);
        objectAnimator.setDuration(3000);
        objectAnimator.setInterpolator(new AccelerateInterpolator());
        objectAnimator.start();
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
