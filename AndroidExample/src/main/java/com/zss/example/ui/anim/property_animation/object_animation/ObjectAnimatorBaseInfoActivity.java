package com.zss.example.ui.anim.property_animation.object_animation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：ObjectAnimatorBaseInfoActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ObjectAnimatorBaseInfoActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView textView;
    private Button btn_alpha;
    private Button btn_rotation;
    private Button btn_rotationX;
    private Button btn_rotationY;
    private Button btn_translationX;
    private Button btn_translationY;
    private Button btn_scaleX;
    private Button btn_scaleY;

    private ObjectAnimator objectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator_base_info_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        textView = (TextView) findViewById(R.id.textView);

        btn_alpha = (Button) findViewById(R.id.btn_alpha);
        btn_alpha.setOnClickListener(this);
        btn_rotation = (Button) findViewById(R.id.btn_rotation);
        btn_rotation.setOnClickListener(this);
        btn_rotationX = (Button) findViewById(R.id.btn_rotationX);
        btn_rotationX.setOnClickListener(this);
        btn_rotationY = (Button) findViewById(R.id.btn_rotationY);
        btn_rotationY.setOnClickListener(this);
        btn_translationX = (Button) findViewById(R.id.btn_translationX);
        btn_translationX.setOnClickListener(this);
        btn_translationY = (Button) findViewById(R.id.btn_translationY);
        btn_translationY.setOnClickListener(this);
        btn_scaleX = (Button) findViewById(R.id.btn_scaleX);
        btn_scaleX.setOnClickListener(this);
        btn_scaleY = (Button) findViewById(R.id.btn_scaleY);
        btn_scaleY.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 开启动画
     */
    public void startAnimator() {
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_alpha:
                objectAnimator = ObjectAnimator.ofFloat(textView, "alpha", 0, 1);
                startAnimator();
                break;
            case R.id.btn_rotation:
                objectAnimator = ObjectAnimator.ofFloat(textView, "rotation", 0, 180, 0);
                startAnimator();
                break;
            case R.id.btn_rotationX:
                objectAnimator = ObjectAnimator.ofFloat(textView, "rotationX", 0, 270, 0);
                startAnimator();
                break;
            case R.id.btn_rotationY:
                objectAnimator = ObjectAnimator.ofFloat(textView, "rotationY", 0, 180, 0);
                startAnimator();
                break;
            case R.id.btn_translationX:
                objectAnimator = ObjectAnimator.ofFloat(textView, "translationX", 0, 200, -200, 0);
                startAnimator();
                break;
            case R.id.btn_translationY:
                objectAnimator = ObjectAnimator.ofFloat(textView, "translationY", 0, 200, -180, 0);
                startAnimator();
                break;
            case R.id.btn_scaleX:
                objectAnimator = ObjectAnimator.ofFloat(textView, "scaleX", 0, 2, 1);
                startAnimator();
                break;
            case R.id.btn_scaleY:
                objectAnimator = ObjectAnimator.ofFloat(textView, "scaleY", 0, 3, 1);
                startAnimator();
                break;
            default:
                break;
        }
    }
}
