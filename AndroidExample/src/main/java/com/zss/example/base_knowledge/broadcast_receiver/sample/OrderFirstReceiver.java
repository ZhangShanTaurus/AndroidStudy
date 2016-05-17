package com.zss.example.base_knowledge.broadcast_receiver.sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 描述：OrderFirstReceiver
 * Created by Administrator on 2016/2/26 0026.
 */
public class OrderFirstReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context, "OrderFirstReceiver->onReceive()--" + msg, Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("msg", msg + "-First");
        setResultExtras(bundle);
    }
}
