package com.android.example.communication.http;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

import java.lang.ref.WeakReference;

/**
 * 描述：HttpClientActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class HttpClientActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_get;
    private Button btn_post;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_get = (Button) findViewById(R.id.btn_get);
        btn_get.setOnClickListener(this);
        btn_post = (Button) findViewById(R.id.btn_post);
        btn_post.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.textView);
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
            case R.id.btn_get:
                result = "";
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        result = httpByGet();
                    }
                }).start();
                break;
            case R.id.btn_post:
                result = "";
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        result = httpByPost();
                    }
                }).start();
                break;
            default:
                break;
        }
    }

    private String str_post = "http://2ciyuanjie.com/api.php";
    private String str_get = "http://2ciyuanjie.com/api.php?token=866001029216760&apiUrl=getoken&apiVersion=K10";
    private String result;

    /**
     * Get请求
     */
    public String httpByGet() {
//        HttpClient client;
        return result;
    }

    /**
     * Post请求
     */
    public String httpByPost() {
        return result;
    }

    private MyHandler handler = new MyHandler(this);

    /**
     * 静态内部类Handler，防止内存泄漏，使用弱引用
     */
    private static class MyHandler extends Handler {
        private WeakReference<HttpClientActivity> activity;

        public MyHandler(HttpClientActivity activity) {
            this.activity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {

        }
    }
}
