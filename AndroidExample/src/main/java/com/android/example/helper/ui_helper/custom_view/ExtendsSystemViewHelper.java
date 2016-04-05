package com.android.example.helper.ui_helper.custom_view;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.ui.layout.FrameLayoutActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：ExtendsViewHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class ExtendsSystemViewHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.extends_linearLayout:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.extends_linearLayout);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            default:
                break;
        }
    }
}
