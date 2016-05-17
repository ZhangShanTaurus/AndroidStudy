package com.zss.example.base_knowledge.service.sample;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * 描述：WithThreadService
 * 在onStartCommand()或者onBind()方法中创建一个线程执行耗时操作,从而不阻塞主线程
 * Created by Administrator on 2016/2/24 0024.
 */
public class WithThreadService extends Service {
    private boolean isDestroy = false;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int info = msg.arg1;
            Toast.makeText(getApplicationContext(), "WithThreadService中Thread发送的消息---" + info, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }


    private static int time = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isDestroy) {
                    try {
                        Message msg = Message.obtain();
                        msg.arg1 = time;
                        handler.sendMessage(msg);
                        time++;
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isDestroy = true;
    }
}
