package com.zss.example.ui.view.widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：SwitchActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class SwitchActivity extends BaseActivity {
    private ImageView iv_back;
    private TextView tv_title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_switch_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }
}
