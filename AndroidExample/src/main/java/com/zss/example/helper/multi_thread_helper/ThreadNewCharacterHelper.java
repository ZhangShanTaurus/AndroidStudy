package com.zss.example.helper.multi_thread_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.common.Constance;
import com.zss.example.multi_thread.ThreadCommonInfoActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：ThreadNewCharacterHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class ThreadNewCharacterHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case com.zss.example.R.string.thread_pool:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_pool);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_return_value:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_return_value);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_lock_one:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_lock_one);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_lock_two:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_lock_two);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_semaphore:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_semaphore);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_blocking_queue:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_blocking_queue);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_blocking_stack:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_blocking_stack);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_condition_variable:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_condition_variable);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_atomic_mass:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_atomic_mass);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_obstruction_marker:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_obstruction_marker);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            default:
                break;
        }
    }
}
