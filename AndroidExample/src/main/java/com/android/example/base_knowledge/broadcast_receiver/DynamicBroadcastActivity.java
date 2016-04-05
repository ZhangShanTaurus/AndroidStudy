package com.android.example.base_knowledge.broadcast_receiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.base_knowledge.broadcast_receiver.sample.DynamicBroadcastReceiver;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：DynamicBroadcastActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class DynamicBroadcastActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_send;
    private final String ACTION = "android.intent.action.DynamicBroadcastActivity";
    private DynamicBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_broadcast_layout);
        initView();
        initData();
        registerReceiver();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 注册动态广播
     */
    public void registerReceiver() {
        receiver = new DynamicBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION);
        registerReceiver(receiver, filter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_send:
                Intent intent = new Intent(ACTION);
                intent.putExtra("msg", "这是'动态注册'广播出去的消息");
                sendBroadcast(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver != null) {
            unregisterReceiver(receiver);
        }
    }
}
