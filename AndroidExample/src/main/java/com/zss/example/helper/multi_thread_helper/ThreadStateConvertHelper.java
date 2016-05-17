package com.zss.example.helper.multi_thread_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.multi_thread.ThreadCommonInfoActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：ThreadStateConvertHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class ThreadStateConvertHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.thread_state:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_state);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case R.string.thread_priority:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_priority);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case R.string.thread_sleep1:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_sleep1);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case R.string.thread_yield:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_yield);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case R.string.thread_join:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_join);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case R.string.thread_state_convert_summary:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.thread_state_convert_summary);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            default:
                break;
        }
    }
}
