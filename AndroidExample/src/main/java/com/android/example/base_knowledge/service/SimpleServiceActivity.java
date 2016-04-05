package com.android.example.base_knowledge.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.base_knowledge.service.sample.SimpleService;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：SimpleServiceActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class SimpleServiceActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_start_service;
    private Button btn_stop_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_service_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_start_service = (Button) findViewById(R.id.btn_start_service);
        btn_start_service.setOnClickListener(this);
        btn_stop_service = (Button) findViewById(R.id.btn_stop_service);
        btn_stop_service.setOnClickListener(this);
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
            case R.id.btn_start_service:
                startService(new Intent(SimpleServiceActivity.this, SimpleService.class));
                break;
            case R.id.btn_stop_service:
                stopService(new Intent(SimpleServiceActivity.this, SimpleService.class));
                break;
            default:
                break;
        }
    }
}
