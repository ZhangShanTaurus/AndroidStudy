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
public class CacheMachiningHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.ram_cache:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.ram_cache);
                IntentUtils.intent(context, bundle, WhyOOMActivity.class, false);
                break;
            case R.string.file_cache:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.file_cache);
                IntentUtils.intent(context, bundle, ButtonActivity.class, false);
                break;
            case R.string.net_cache:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.net_cache);
                IntentUtils.intent(context, bundle, WhyOOMActivity.class, false);
                break;
            default:
                break;
        }
    }
}
