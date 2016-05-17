package com.zss.example.helper.ui_helper.custom_view;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.common.Constance;
import com.zss.example.ui.layout.FrameLayoutActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：ExtendsViewHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class CombinationViewHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case com.zss.example.R.string.combination_view_test:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.combination_view_test);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            default:
                break;
        }
    }
}
