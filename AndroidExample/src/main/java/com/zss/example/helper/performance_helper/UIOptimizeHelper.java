package com.zss.example.helper.performance_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.common.Constance;
import com.zss.example.ui.view.widgets.ButtonActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：UIOptimizeHelper
 * Created by Administrator on 2016/1/15 0015.
 */
public class UIOptimizeHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case com.zss.example.R.string.layoutHierarchy:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.layoutHierarchy);
                IntentUtils.intent(context, bundle, ButtonActivity.class, false);
                break;
            case com.zss.example.R.string.useAbstractLayout:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.useAbstractLayout);
                IntentUtils.intent(context, bundle, ButtonActivity.class, false);
                break;
            case com.zss.example.R.string.hierarchyViewer:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.hierarchyViewer);
                IntentUtils.intent(context, bundle, ButtonActivity.class, false);
                break;
            case com.zss.example.R.string.lintTool:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.lintTool);
                IntentUtils.intent(context, bundle, ButtonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
