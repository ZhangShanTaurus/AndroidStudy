package com.zss.example.base_knowledge.broadcast_receiver.sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 描述：OrderSecondReceiver
 * Created by Administrator on 2016/2/26 0026.
 */
public class OrderSecondReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = getResultExtras(true).getString("msg");
//        String msg = intent.getStringExtra("msg");
        Toast.makeText(context, "OrderSecondReceiver->onReceive()--" + msg, Toast.LENGTH_SHORT).show();
        //终止广播继续向下传递
//        abortBroadcast();
        Bundle bundle = new Bundle();
        bundle.putString("msg", msg + "-Second");
        setResultExtras(bundle);
    }
}
