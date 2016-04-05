package com.android.example.ui.view.expert;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：ViewAnimatorActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ViewAnimatorActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private ViewAnimator viewAnimator;
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_back_one;
    private Button btn_back_two;
    private Button btn_back_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animator_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_back_one = (Button) findViewById(R.id.btn_back_one);
        btn_back_one.setOnClickListener(this);
        btn_back_two = (Button) findViewById(R.id.btn_back_two);
        btn_back_two.setOnClickListener(this);
        btn_back_three = (Button) findViewById(R.id.btn_back_three);
        btn_back_three.setOnClickListener(this);
        viewAnimator = (ViewAnimator) findViewById(R.id.viewAnimator);
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
            case R.id.btn_one:
                viewAnimator.setDisplayedChild(1);
                break;
            case R.id.btn_two:
                viewAnimator.setDisplayedChild(2);
                break;
            case R.id.btn_three:
                viewAnimator.setDisplayedChild(3);
                break;
            case R.id.btn_back_one:
                viewAnimator.setDisplayedChild(0);
                break;
            case R.id.btn_back_two:
                viewAnimator.setDisplayedChild(0);
                break;
            case R.id.btn_back_three:
                viewAnimator.setDisplayedChild(0);
                break;
            default:
                break;
        }
    }
}
