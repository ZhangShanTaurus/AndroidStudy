package com.zss.example.base_knowledge.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.base_knowledge.service.sample.UploadImgService;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：IntentServiceActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class IntentServiceActivity extends BaseActivity implements View.OnClickListener {
    public static final String UPLOAD_RESULT = "IntentServiceActivity";
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_add_task;
    private LinearLayout ll_taskContainer;

    private BroadcastReceiver uploadReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(UPLOAD_RESULT)) {
                String path = intent.getStringExtra(UploadImgService.EXTRA_IMG_PATH);
                handleResult(path);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service_layout);
        initView();
        initData();
        registerReceiver();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        ll_taskContainer = (LinearLayout) findViewById(R.id.ll_taskContainer);
        btn_add_task = (Button) findViewById(R.id.btn_add_task);
        btn_add_task.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 注册广播接收器
     */
    public void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(IntentServiceActivity.UPLOAD_RESULT);
        registerReceiver(uploadReceiver, filter);
    }

    private int i = 0;

    /**
     * 添加任务
     */
    public void addTask() {
        String path = "/sdcard/img/" + (++i) + ".png";
        UploadImgService.startUploadImg(IntentServiceActivity.this, path);
        TextView textView = new TextView(this);
        ll_taskContainer.addView(textView);
        textView.setText(path + "is upload...");
        textView.setTag(path);
    }

    private void handleResult(String path) {
        TextView tv = (TextView) ll_taskContainer.findViewWithTag(path);
        tv.setText(path + " upload success ~~~ ");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_add_task:
                addTask();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(uploadReceiver);
    }
}
