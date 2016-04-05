package com.android.example.multi_thread.create_run;

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
 * 描述：ThreadCreateRunActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ThreadCreateRunActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_start;
    private static TextView textView;
    private MyHandler handler = new MyHandler(ThreadCreateRunActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_create_run_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        textView = (TextView) findViewById(R.id.textView);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
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
            case R.id.btn_start:
                //清空StringBuilder中数据
                sb.replace(0, sb.length(), "");
                start();
                break;
            default:
                break;
        }
    }

    /**
     * 开启线程
     */
    public void start() {
        Thread threadA = new MyThread("ThreadA");
        Thread threadB = new MyThread("ThreadB");
        threadA.start();
        threadB.start();

        Thread runnableA = new Thread(new MyRunnable("RunnableA"));
        Thread runnableB = new Thread(new MyRunnable("RunnableB"));
        runnableA.start();
        runnableB.start();
    }


    /**
     * 扩展Thread
     */
    class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 100000000; j++) ;
                Message message = Message.obtain();
                message.obj = getName() + "--" + i + "--次";
                handler.sendMessage(message);
            }
        }
    }

    /**
     * 实现Runnable接口
     */
    class MyRunnable implements Runnable {
        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                //模拟耗时任务
                for (int j = 0; j < 100000000; j++) {
                }
                Message message = Message.obtain();
                message.obj = name + "--" + i + "--次";
                handler.sendMessage(message);
            }
        }
    }

    private static StringBuilder sb = new StringBuilder("");

    /**
     * 静态内部类，防止Handler引起内存泄漏
     */
    private static class MyHandler extends Handler {
        //弱引用
        private final WeakReference<ThreadCreateRunActivity> activity;

        public MyHandler(ThreadCreateRunActivity activity) {
            this.activity = new WeakReference<ThreadCreateRunActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            sb.append(msg.obj.toString() + "\n");
            textView.setText(sb);
        }
    }
}
