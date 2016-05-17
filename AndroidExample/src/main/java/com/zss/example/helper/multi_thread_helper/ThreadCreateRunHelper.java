package com.zss.example.helper.multi_thread_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.common.Constance;
import com.zss.example.multi_thread.ThreadCommonInfoActivity;
import com.zss.example.multi_thread.create_run.ThreadCreateRunActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：ThreadConceptHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class ThreadCreateRunHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case com.zss.example.R.string.thread_define:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_define);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_instantiation:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_instantiation);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_start:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_start);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_problem:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_problem);
                IntentUtils.intent(context, bundle, ThreadCommonInfoActivity.class, false);
                break;
            case com.zss.example.R.string.thread_sample:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.thread_sample);
                IntentUtils.intent(context, bundle, ThreadCreateRunActivity.class, false);
                break;
            default:
                break;
        }
    }
}
