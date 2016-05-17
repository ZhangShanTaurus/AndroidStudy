package com.zss.example.helper;

import android.content.Context;

import com.zss.example.R;
import com.zss.example.common.CommonActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：OtherHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class OtherHelper {

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.intent:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.android_manifest:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.aidl:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.wifi:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.Internationalization:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.popupWindow:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
