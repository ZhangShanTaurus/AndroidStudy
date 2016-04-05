package com.android.example.helper.base_knowledge_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.base_knowledge.broadcast_receiver.DynamicBroadcastActivity;
import com.android.example.base_knowledge.broadcast_receiver.NormalBroadcastActivity;
import com.android.example.base_knowledge.broadcast_receiver.OrderBroadcastActivity;
import com.android.example.base_knowledge.broadcast_receiver.StaticBroadcastActivity;
import com.android.example.common.Constance;
import com.android.example.utils.IntentUtils;

/**
 * 描述：BroadcastReceiverHelper
 * Created by Administrator on 2016/2/22 0022.
 */
public class BroadcastReceiverHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle = null;
        switch (index) {
            case R.string.static_register:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.static_register);
                IntentUtils.intent(context, bundle, StaticBroadcastActivity.class, false);
                break;
            case R.string.dynamic_register:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.dynamic_register);
                IntentUtils.intent(context, bundle, DynamicBroadcastActivity.class, false);
                break;
            case R.string.normal_broadcast:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.normal_broadcast);
                IntentUtils.intent(context, bundle, NormalBroadcastActivity.class, false);
                break;
            case R.string.order_broadcast:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.order_broadcast);
                IntentUtils.intent(context, bundle, OrderBroadcastActivity.class, false);
                break;
            default:
                break;
        }
    }
}
