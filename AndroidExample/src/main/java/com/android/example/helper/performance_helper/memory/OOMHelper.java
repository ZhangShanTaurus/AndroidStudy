package com.android.example.helper.performance_helper.memory;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.performance.memory.oom.WhyOOMActivity;
import com.android.example.ui.view.widgets.ButtonActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：OOMHelper
 * Created by Administrator on 2016/1/15 0015.
 */
public class OOMHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.why_produce:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.why_produce);
                IntentUtils.intent(context, bundle, WhyOOMActivity.class, false);
                break;
            case R.string.avoid_oom:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.avoid_oom);
                IntentUtils.intent(context, bundle, ButtonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
