package com.android.example.helper.multi_thread_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.multi_thread.ThreadCommonInfoActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：ThreadInteractionHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class ThreadInteractionHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.thread_base_knowledge:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_base_knowledge);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case R.string.thread_more_wait_lock:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_more_wait_lock);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            default:
                break;
        }
    }
}
