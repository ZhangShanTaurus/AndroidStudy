package com.android.example.multi_thread.sync_lock;

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
 * 描述：ThreadSyncProblemActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ThreadSyncProblemActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_not_sync;
    private Button btn_sync;
    private static TextView textView;
    private MyHandler handler = new MyHandler(ThreadSyncProblemActivity.this);
    private static StringBuilder sb = new StringBuilder("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_sync_problem_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        textView = (TextView) findViewById(R.id.textView);
        btn_not_sync = (Button) findViewById(R.id.btn_not_sync);
        btn_not_sync.setOnClickListener(this);
        btn_sync = (Button) findViewById(R.id.btn_sync);
        btn_sync.setOnClickListener(this);
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
            case R.id.btn_not_sync:
                //清空StringBuilder中数据
                sb.replace(0, sb.length(), "");
                startNotSyncThread();
                break;
            case R.id.btn_sync:
                //清空StringBuilder中数据
                sb.replace(0, sb.length(), "");
                startSyncThread();
                break;
            default:
                break;
        }
    }

    /**
     * 启动没有同步的线程
     */
    public void startNotSyncThread() {
        Runnable runnable = new MyRunnable();
        Thread threadA = new Thread(runnable, "ThreadA");
        Thread threadB = new Thread(runnable, "ThreadB");
        threadA.start();
        threadB.start();
    }

    /**
     * 启动同步线程
     */
    public void startSyncThread() {
        Runnable runnable = new MyRunnable1();
        Thread threadA = new Thread(runnable, "ThreadA");
        Thread threadB = new Thread(runnable, "ThreadB");
        threadA.start();
        threadB.start();
    }

    /**
     * 静态内部类，防止Handler引起内存泄漏
     */
    private static class MyHandler extends Handler {

        //弱引用
        private final WeakReference<ThreadSyncProblemActivity> activity;

        public MyHandler(ThreadSyncProblemActivity activity) {
            this.activity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            sb.append(msg.obj.toString() + "\n");
            textView.setText(sb);
        }
    }

    /**
     * 线程类
     */
    public class MyRunnable implements Runnable {
        private Food food = new Food();

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(Thread.currentThread().getName() + "访问前x=" + food.getX() + ",");
                food.fix(20);
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sb.append(Thread.currentThread().getName() + "访问后x=" + food.getX());
                Message message = Message.obtain();
                message.obj = sb;
                handler.sendMessage(message);
            }
        }
    }

    /**
     * 线程类
     */
    public class MyRunnable1 implements Runnable {
        private Money money = new Money();

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(Thread.currentThread().getName() + "访问前x=" + money.getX() + ",");
                money.fix(20);
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sb.append(Thread.currentThread().getName() + "访问后x=" + money.getX());
                Message message = Message.obtain();
                message.obj = sb;
                handler.sendMessage(message);
            }
        }
    }

    /**
     * 线程访问的实体类
     */
    public class Food {
        private int x = 90;

        public int getX() {
            return x;
        }

        public int fix(int y) {
            return x -= y;
        }
    }

    /**
     * 线程访问同步类
     */
    public class Money {
        private int x = 90;

        public synchronized int getX() {
            return x;
        }

        public int fix(int y) {
            synchronized (this) {
                return x -= y;
            }
        }
    }
}
