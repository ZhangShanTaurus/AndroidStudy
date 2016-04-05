package com.android.example.helper;

import android.content.Context;

import com.android.example.R;
import com.android.example.common.CommonActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：NDKHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class NDKHelper {

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.jni:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.c:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.c1:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
