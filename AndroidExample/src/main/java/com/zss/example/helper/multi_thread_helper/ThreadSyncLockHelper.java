package com.zss.example.helper.multi_thread_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.common.Constance;
import com.zss.example.multi_thread.ThreadCommonInfoActivity;
import com.zss.example.multi_thread.sync_lock.ThreadSyncProblemActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：ThreadSyncLockHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class ThreadSyncLockHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case com.zss.example.R.string.thread_sync_problem:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_sync_problem);
                IntentUtils.intent(context, bundle, ThreadSyncProblemActivity.class, false);
                break;
            case com.zss.example.R.string.thread_sync_lock1:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_sync_lock1);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_static_method_sync:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_static_method_sync);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_not_get_lock:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_not_get_lock);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_when_sync:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_when_sync);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_safe_class:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_safe_class);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_dead_lock:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_dead_lock);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_sync_lock_summary:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_sync_lock_summary);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            default:
                break;
        }
    }
}
