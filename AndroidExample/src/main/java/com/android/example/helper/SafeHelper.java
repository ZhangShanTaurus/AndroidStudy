package com.android.example.helper;

import android.content.Context;

import com.android.example.R;
import com.android.example.common.CommonActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：
 * Created by Administrator on 2016/1/14 0014.
 */
public class SafeHelper {

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.server_safe:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.communication_safe:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.data_encryption:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.data_attestation:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.code_confusion:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.call_safe:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.other_safe:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
