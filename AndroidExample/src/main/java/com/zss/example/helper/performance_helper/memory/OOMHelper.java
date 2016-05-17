package com.zss.example.helper.performance_helper.memory;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.common.Constance;
import com.zss.example.performance.memory.oom.WhyOOMActivity;
import com.zss.example.ui.view.widgets.ButtonActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：OOMHelper
 * Created by Administrator on 2016/1/15 0015.
 */
public class OOMHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case com.zss.example.R.string.why_produce:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.why_produce);
                IntentUtils.intent(context, bundle, WhyOOMActivity.class, false);
                break;
            case com.zss.example.R.string.avoid_oom:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.avoid_oom);
                IntentUtils.intent(context, bundle, ButtonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
