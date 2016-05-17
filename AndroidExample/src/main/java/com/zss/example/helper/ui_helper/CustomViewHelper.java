package com.zss.example.helper.ui_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.R;
import com.zss.example.common.CommonActivity;
import com.zss.example.common.Constance;
import com.zss.example.common.DataResource;
import com.zss.example.common.MyData;
import com.zss.example.ui.custom_view.ViewCoordinateActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：CustomViewHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class CustomViewHelper {
    private static MyData myData;

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.extends_system_view:
                myData = new MyData(R.string.extends_system_view, new DataResource(Constance.EXTENDS_SYSTEM_VIEW).getList(), Constance.EXTENDS_SYSTEM_VIEW);
                break;
            case R.string.extends_view:
                myData = new MyData(R.string.extends_view, new DataResource(Constance.EXTENDS_VIEW).getList(), Constance.EXTENDS_VIEW);
                break;
            case R.string.combination_view:
                myData = new MyData(R.string.combination_view, new DataResource(Constance.COMBINATION_VIEW).getList(), Constance.COMBINATION_VIEW);
                break;
            case R.string.view_coordinate_info:
                Bundle bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.view_coordinate_info);
                IntentUtils.intent(context, bundle, ViewCoordinateActivity.class, false);
                return;
            default:
                break;
        }

        Bundle bundle = new Bundle();
        bundle.putSerializable(Constance.MYDATA, myData);
        IntentUtils.intent(context, bundle, CommonActivity.class, false);
    }

}
