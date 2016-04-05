package com.android.example.helper.ui_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.CommonActivity;
import com.android.example.common.Constance;
import com.android.example.common.DataResource;
import com.android.example.common.MyData;
import com.android.example.utils.IntentUtils;

/**
 * 描述：AnimHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class AnimHelper {
    private static MyData myData;

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.view_animation:
                myData = new MyData(R.string.view_animation, new DataResource(Constance.VIEW_ANIMATION).getList(), Constance.VIEW_ANIMATION);
                break;
            case R.string.property_animation:
                myData = new MyData(R.string.property_animation, new DataResource(Constance.PROPERTY_ANIMATOR).getList(), Constance.PROPERTY_ANIMATOR);
                break;
            default:
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constance.MYDATA, myData);
        IntentUtils.intent(context, bundle, CommonActivity.class, false);
    }
}
