package com.zss.example.helper.base_knowledge_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.R;
import com.zss.example.base_knowledge.handler.HandlerCommonActivity;
import com.zss.example.common.Constance;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：ActivityHelper
 * Created by Administrator on 2016/2/22 0022.
 */
public class HandlerLooperMessageHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.handler_base_info:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.handler_base_info);
                IntentUtils.intent(context, bundle, HandlerCommonActivity.class, false);
                break;
            case R.string.looper_base_info:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.looper_base_info);
                IntentUtils.intent(context, bundle, HandlerCommonActivity.class, false);
                break;
            case R.string.message_base_info:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.message_base_info);
                IntentUtils.intent(context, bundle, HandlerCommonActivity.class, false);
                break;
            case R.string.message_queue_info:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.message_queue_info);
                IntentUtils.intent(context, bundle, HandlerCommonActivity.class, false);
                break;
            case R.string.handler_summary:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.handler_summary);
                IntentUtils.intent(context, bundle, HandlerCommonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
