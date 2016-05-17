package com.zss.example.helper.base_knowledge_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.base_knowledge.broadcast_receiver.DynamicBroadcastActivity;
import com.zss.example.base_knowledge.broadcast_receiver.NormalBroadcastActivity;
import com.zss.example.base_knowledge.broadcast_receiver.OrderBroadcastActivity;
import com.zss.example.base_knowledge.broadcast_receiver.StaticBroadcastActivity;
import com.zss.example.common.Constance;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：BroadcastReceiverHelper
 * Created by Administrator on 2016/2/22 0022.
 */
public class BroadcastReceiverHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle = null;
        switch (index) {
            case com.zss.example.R.string.static_register:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.static_register);
                IntentUtils.intent(context, bundle, StaticBroadcastActivity.class, false);
                break;
            case com.zss.example.R.string.dynamic_register:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.dynamic_register);
                IntentUtils.intent(context, bundle, DynamicBroadcastActivity.class, false);
                break;
            case com.zss.example.R.string.normal_broadcast:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.normal_broadcast);
                IntentUtils.intent(context, bundle, NormalBroadcastActivity.class, false);
                break;
            case com.zss.example.R.string.order_broadcast:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.order_broadcast);
                IntentUtils.intent(context, bundle, OrderBroadcastActivity.class, false);
                break;
            default:
                break;
        }
    }
}
