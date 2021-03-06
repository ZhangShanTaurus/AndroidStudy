package com.zss.example.helper.base_knowledge_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.R;
import com.zss.example.base_knowledge.design_mode.builder.BuilderActivity;
import com.zss.example.base_knowledge.design_mode.proxy.ProxyActivity;
import com.zss.example.base_knowledge.design_mode.singleton.SingletonActivity;
import com.zss.example.common.Constance;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：DesignModeHelper
 * Created by Administrator on 2016/2/22 0022.
 */
public class DesignModeHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle = null;
        switch (index) {
            case R.string.singleton:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.singleton);
                IntentUtils.intent(context, bundle, SingletonActivity.class, false);
                break;
            case R.string.proxy:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.proxy);
                IntentUtils.intent(context, bundle, ProxyActivity.class, false);
                break;
            case R.string.builder:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.builder);
                IntentUtils.intent(context, bundle, BuilderActivity.class, false);
                break;
            default:
                break;
        }
    }
}
