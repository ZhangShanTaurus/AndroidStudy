package com.zss.example.app;

import android.app.Application;

/**
 * 描述：
 * Created by Administrator on 2016/1/12 0012.
 */
public class MyApplication extends Application {
    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //添加一条测试信息
    }
}
