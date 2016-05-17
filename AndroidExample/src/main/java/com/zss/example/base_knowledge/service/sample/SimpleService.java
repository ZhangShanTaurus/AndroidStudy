package com.zss.example.base_knowledge.service.sample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * 描述：简单的Service
 * Created by Administrator on 2016/2/23 0023.
 */
public class SimpleService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(), "SimpleService---onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "SimpleService---onStartCommand()", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "SimpleService---onDestroy()", Toast.LENGTH_SHORT).show();
    }

    /**
     * 该方法为Service抽象方法，必须实现
     * 返回null,表示客户端不能建立到此服务的连接
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
