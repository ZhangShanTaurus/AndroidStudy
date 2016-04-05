package com.android.example.helper.multi_thread_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.multi_thread.ThreadCommonInfoActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：ThreadDispatchHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class ThreadDispatchHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.thread_sleep:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_sleep);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case R.string.thread_priority1:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_priority1);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case R.string.thread_concession:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_concession);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case R.string.thread_merge:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_merge);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case R.string.thread_guard:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_guard);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case R.string.thread_sync_method:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_sync_method);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case R.string.thread_sync_block:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_sync_block);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            default:
                break;
        }
    }
}
