package com.zss.example.base_knowledge.service.sample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 描述：
 * Created by Administrator on 2016/2/23 0023.
 */
public class ToActCommunicationService extends Service {
    private MyBinder binder;
    private TextView textView1;

    @Override
    public void onCreate() {
        super.onCreate();
        binder = new MyBinder();
        Toast.makeText(getApplicationContext(), "Service---onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(), "Service---onBind()", Toast.LENGTH_SHORT).show();
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(getApplicationContext(), "Service---onUnbind()", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Service---onDestroy()", Toast.LENGTH_SHORT).show();
        if (textView1 != null) {
            textView1.setText("Service与Activity解除关联");
        }
    }

    /**
     * 我们直接继承Binder而不是IBinder,因为Binder实现了IBinder接口，这样我们可以少做很多工作
     */
    public class MyBinder extends Binder {
        /**
         * 获取Service实例
         */
        public ToActCommunicationService getService() {
            return ToActCommunicationService.this;
        }

        public void communication(TextView textView) {
            textView1 = textView;
            textView.setText("Service与Activity关联起来啦");
            Toast.makeText(getApplicationContext(), "Binder---communication()", Toast.LENGTH_SHORT).show();
        }
    }
}
