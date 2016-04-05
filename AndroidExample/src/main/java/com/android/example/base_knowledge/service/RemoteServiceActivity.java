package com.android.example.base_knowledge.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.MyAIDLService;
import com.android.example.R;
import com.android.example.base_knowledge.service.sample.RemoteService;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：RemoteServiceActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class RemoteServiceActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView textView;
    private Button btn_start_service;
    private Button btn_stop_service;
    private boolean isBind = false;

    private MyAIDLService myAIDLService;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myAIDLService = MyAIDLService.Stub.asInterface(iBinder);
            try {
                int value = myAIDLService.add(15, 16);
                String info = myAIDLService.say("hello world");
                if (textView != null) {
                    textView.setText("以下的值来自AIDL计算结果:" + "\n" + "15+" + "16=" + value + "\n" + info);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_service_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        textView = (TextView) findViewById(R.id.textView);
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
                Intent intent = new Intent(RemoteServiceActivity.this, RemoteService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
                isBind = true;
                break;
            case R.id.btn_stop_service:
                if (isBind) {
                    unbindService(connection);
                    isBind = false;
                } else {
                    Toast.makeText(RemoteServiceActivity.this, "UnbindService不可重复点击", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }
    }
}
