package com.android.example.helper.multi_thread_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.multi_thread.ThreadCommonInfoActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：ThreadStackModeltHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class ThreadStackModeltHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.thread_process:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_process);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case R.string.thread_in_java:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_in_java);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            default:
                break;
        }
    }
}
