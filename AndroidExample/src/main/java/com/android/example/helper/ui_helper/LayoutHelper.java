package com.android.example.helper.ui_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.ui.layout.DrawerLayoutActivity;
import com.android.example.ui.layout.FrameLayoutActivity;
import com.android.example.ui.layout.GridLayoutActivity;
import com.android.example.ui.layout.LinearLayoutActivity;
import com.android.example.ui.layout.RelativeLayoutActivity;
import com.android.example.ui.layout.SlidingPaneLayoutActivity;
import com.android.example.ui.layout.TableLayoutActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：UI模块下Layout帮助类
 * Created by Administrator on 2016/1/14 0014.
 */
public class LayoutHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.my_frameLayout:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.my_frameLayout);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.my_linearLayout:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.my_linearLayout);
                IntentUtils.intent(context, bundle, LinearLayoutActivity.class, false);
                break;
            case R.string.my_relativeLayout:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.my_relativeLayout);
                IntentUtils.intent(context, bundle, RelativeLayoutActivity.class, false);
                break;
            case R.string.my_gridLayout:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.my_gridLayout);
                IntentUtils.intent(context, bundle, GridLayoutActivity.class, false);
                break;
            case R.string.my_drawerLayout:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.my_drawerLayout);
                IntentUtils.intent(context, bundle, DrawerLayoutActivity.class, false);
                break;
            case R.string.my_tableLayout:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.my_tableLayout);
                IntentUtils.intent(context, bundle, TableLayoutActivity.class, false);
                break;
            case R.string.my_sliding_panel_layout:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.my_sliding_panel_layout);
                IntentUtils.intent(context, bundle, SlidingPaneLayoutActivity.class, false);
                break;
            default:
                break;
        }
    }
}
