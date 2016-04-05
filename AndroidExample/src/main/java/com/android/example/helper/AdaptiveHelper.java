package com.android.example.helper;

import android.content.Context;

import com.android.example.R;
import com.android.example.common.CommonActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：
 * Created by Administrator on 2016/1/14 0014.
 */
public class AdaptiveHelper {

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.os_version:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.screen_size:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.screen_px:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
