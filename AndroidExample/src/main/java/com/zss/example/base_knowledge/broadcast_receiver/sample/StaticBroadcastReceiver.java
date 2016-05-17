package com.zss.example.base_knowledge.broadcast_receiver.sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 描述：StaticBroadcastReceiver
 * Created by Administrator on 2016/2/26 0026.
 */
public class StaticBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context, "StaticBroadcastReceiver->onReceive()--" + msg, Toast.LENGTH_SHORT).show();
    }
}
