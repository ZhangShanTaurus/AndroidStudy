package com.zss.example.helper.multi_thread_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.common.Constance;
import com.zss.example.multi_thread.ThreadCommonInfoActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：ThreadConcurrentHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class ThreadConcurrentHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case com.zss.example.R.string.thread_producer_consumer:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_producer_consumer);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_dead_lock1:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_dead_lock1);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_volatile:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_volatile);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            default:
                break;
        }
    }
}
