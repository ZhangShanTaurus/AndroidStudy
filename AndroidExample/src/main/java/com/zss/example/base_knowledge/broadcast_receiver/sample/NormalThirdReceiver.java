package com.zss.example.base_knowledge.broadcast_receiver.sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 描述：NormalThirdReceiver
 * Created by Administrator on 2016/2/26 0026.
 */
public class NormalThirdReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context, "NormalThirdReceiver->onReceive()--" + msg, Toast.LENGTH_SHORT).show();
    }
}
