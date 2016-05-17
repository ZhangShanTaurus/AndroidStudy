package com.zss.example.helper;

import android.content.Context;

import com.zss.example.common.CommonActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：
 * Created by Administrator on 2016/1/14 0014.
 */
public class DebugHelper {

    public static void goNext(Context context, int index) {
        switch (index) {
            case com.zss.example.R.string.logcat:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case com.zss.example.R.string.adb:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case com.zss.example.R.string.traceview:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case com.zss.example.R.string.heap:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case com.zss.example.R.string.lint:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case com.zss.example.R.string.hierarchy_viewer:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
