package com.android.example.helper;

import android.content.Context;

import com.android.example.R;
import com.android.example.common.CommonActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：
 * Created by Administrator on 2016/1/14 0014.
 */
public class DebugHelper {

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.logcat:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.adb:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.traceview:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.heap:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.lint:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.hierarchy_viewer:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
