package com.android.example.helper.performance_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.ui.view.widgets.ButtonActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：UIOptimizeHelper
 * Created by Administrator on 2016/1/15 0015.
 */
public class UIOptimizeHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.layoutHierarchy:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.layoutHierarchy);
                IntentUtils.intent(context, bundle, ButtonActivity.class, false);
                break;
            case R.string.useAbstractLayout:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.useAbstractLayout);
                IntentUtils.intent(context, bundle, ButtonActivity.class, false);
                break;
            case R.string.hierarchyViewer:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.hierarchyViewer);
                IntentUtils.intent(context, bundle, ButtonActivity.class, false);
                break;
            case R.string.lintTool:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.lintTool);
                IntentUtils.intent(context, bundle, ButtonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
