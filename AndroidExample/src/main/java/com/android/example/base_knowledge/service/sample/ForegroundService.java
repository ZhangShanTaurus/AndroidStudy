package com.android.example.base_knowledge.service.sample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.android.example.R;
import com.android.example.base_knowledge.service.ForegroundServiceActivity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 描述：ForegroundService
 * Created by Administrator on 2016/2/23 0023.
 */
public class ForegroundService extends Service {
    private static final Class[] mStartForegroundSignature = new Class[]{int.class, Notification.class};
    private static final Class[] mStopForegroundSignature = new Class[]{boolean.class};
    private NotificationManager mNM;
    private Method mStartForeground;
    private Method mStopForeground;
    private Object[] mStartForegroundArgs = new Object[2];
    private Object[] mStopForegroundArgs = new Object[1];

    @Override
    public void onCreate() {
        super.onCreate();
        mNM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        try {
            mStartForeground = ForegroundService.class.getMethod("startForeground", mStartForegroundSignature);
            mStopForeground = ForegroundService.class.getMethod("stopForeground", mStopForegroundSignature);
        } catch (NoSuchMethodException e) {
            mStartForeground = mStopForeground = null;
        }

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, ForegroundServiceActivity.class), 0);

        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("Title")
                .setContentText("Content")
                .setSmallIcon(R.drawable.icon_qq)
                .setContentIntent(contentIntent)
                .setWhen(System.currentTimeMillis())
//                .setLargeIcon(aBitmap)
                .build();

        startForegroundCompat(1, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForegroundCompat(1);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // 以兼容性方式开始前台服务
    private void startForegroundCompat(int id, Notification n) {
        if (mStartForeground != null) {
            mStartForegroundArgs[0] = id;
            mStartForegroundArgs[1] = n;

            try {
                mStartForeground.invoke(this, mStartForegroundArgs);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return;
        }
//        setForeground(true);
        mNM.notify(id, n);
    }

    // 以兼容性方式停止前台服务
    private void stopForegroundCompat(int id) {
        if (mStopForeground != null) {
            mStopForegroundArgs[0] = Boolean.TRUE;
            try {
                mStopForeground.invoke(this, mStopForegroundArgs);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return;
        }
        //  在 setForeground 之前调用 cancel，因为我们有可能在取消前台服务之后
        //  的那一瞬间被kill掉。这个时候 notification 便永远不会从通知一栏移除
        mNM.cancel(id);
//        setForeground(false);
    }
}
