package com.zss.example.base_knowledge.broadcast_receiver.sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 描述：OrderThirdReceiver
 * Created by Administrator on 2016/2/26 0026.
 */
public class OrderThirdReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = getResultExtras(true).getString("msg");
//        String msg = intent.getStringExtra("msg");
        Toast.makeText(context, "OrderThirdReceiver->onReceive()--" + msg, Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("msg", msg + "-Third");
        setResultExtras(bundle);
    }
}
