package com.android.example.base_knowledge.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.R;
import com.android.example.base_knowledge.service.sample.ToActCommunicationService;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：ButtonActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class SevToActCommunicationActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_bind_service;
    private Button btn_unbind_service;
    private TextView textView;
    private boolean isBind = false;

    private ToActCommunicationService.MyBinder myBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Toast.makeText(getApplicationContext(), "Activity---onServiceConnected()", Toast.LENGTH_SHORT).show();
            myBinder = (ToActCommunicationService.MyBinder) iBinder;
            //执行方法
            myBinder.communication(textView);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Toast.makeText(getApplicationContext(), "Activity---onServiceDisconnected()", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sevtoact_communication_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        textView = (TextView) findViewById(R.id.textView);
        btn_bind_service = (Button) findViewById(R.id.btn_bind_service);
        btn_bind_service.setOnClickListener(this);
        btn_unbind_service = (Button) findViewById(R.id.btn_unbind_service);
        btn_unbind_service.setOnClickListener(this);
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
            case R.id.btn_bind_service:
                Intent startIntent = new Intent(SevToActCommunicationActivity.this, ToActCommunicationService.class);
                //BIND_AUTO_CREATE表示在Activity和Service建立关联后自动创建Service，这会使得MyService中的onCreate()方法得到执行，但onStartCommand()方法不会执行
                bindService(startIntent, connection, BIND_AUTO_CREATE);
                isBind = true;
                break;
            case R.id.btn_unbind_service:
                //多次调用 unbindService 来释放相同的连接会抛出异常
                if (isBind) {
                    unbindService(connection);
                    isBind = false;
                }
                break;
            default:
                break;
        }
    }
}
