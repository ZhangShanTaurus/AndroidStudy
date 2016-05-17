package com.zss.example.helper.ui_helper.custom_view;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.ui.custom_view.extends_view.CustomViewSetupActivity;
import com.zss.example.ui.custom_view.extends_view.bezier_view.BezierViewActivity;
import com.zss.example.ui.custom_view.extends_view.broken_view.BrokenViewActivity;
import com.zss.example.ui.custom_view.extends_view.validation_code.ValidationCodeActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：ExtendsViewHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class ExtendsViewHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.custom_view_setup:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.custom_view_setup);
                IntentUtils.intent(context, bundle, CustomViewSetupActivity.class, false);
                break;
            case R.string.flowery_validation_code:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.flowery_validation_code);
                IntentUtils.intent(context, bundle, ValidationCodeActivity.class, false);
                break;
            case R.string.broken_view:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.broken_view);
                IntentUtils.intent(context, bundle, BrokenViewActivity.class, false);
                break;
            case R.string.bezier_view:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.bezier_view);
                IntentUtils.intent(context, bundle, BezierViewActivity.class, false);
                break;
            default:
                break;
        }
    }
}
