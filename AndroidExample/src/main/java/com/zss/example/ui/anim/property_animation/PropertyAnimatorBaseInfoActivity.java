package com.zss.example.ui.anim.property_animation;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：PropertyAnimatorBaseInfoActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class PropertyAnimatorBaseInfoActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_property_animator_base_info_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
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
            case com.zss.example.R.id.iv_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}
