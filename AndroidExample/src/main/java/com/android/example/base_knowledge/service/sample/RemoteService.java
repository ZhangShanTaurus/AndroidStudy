package com.android.example.base_knowledge.service.sample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

import com.android.example.MyAIDLService;

/**
 * 描述：RemoteService
 * Created by Administrator on 2016/2/23 0023.
 */
public class RemoteService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "RemoteService---onDestroy()", Toast.LENGTH_SHORT).show();
    }

    /**
     * 该方法为Service抽象方法，必须实现
     * 返回null,表示客户端不能建立到此服务的连接
     */
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(), "RemoteService---onBind()", Toast.LENGTH_SHORT).show();
        return mBinder;
    }

    /**
     * MyAIDLService.Stub实现了IBinder接口
     */
    MyAIDLService.Stub mBinder = new MyAIDLService.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int add(int a, int b) throws RemoteException {
            return a + b;
        }

        @Override
        public String say(String str) throws RemoteException {
            if (str != null) {
                return str;
            }
            return null;
        }
    };
}
