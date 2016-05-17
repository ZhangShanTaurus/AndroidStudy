package com.zss.example.helper.base_knowledge_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.R;
import com.zss.example.base_knowledge.activity.ActivityLifeCycleActivity;
import com.zss.example.common.CommonActivity;
import com.zss.example.common.Constance;
import com.zss.example.common.DataResource;
import com.zss.example.common.MyData;
import com.zss.example.ui.view.widgets.ButtonActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：ActivityHelper
 * Created by Administrator on 2016/2/22 0022.
 */
public class ActivityHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle = null;
        switch (index) {
            case R.string.activity_lifecycle:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.activity_lifecycle);
                IntentUtils.intent(context, bundle, ActivityLifeCycleActivity.class, false);
                break;
            case R.string.activity_data_transmit:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.activity_data_transmit);
                IntentUtils.intent(context, bundle, ButtonActivity.class, false);
                break;
            case R.string.activity_launchMode:
                MyData myData = new MyData(R.string.activity_launchMode, new DataResource(Constance.ACTIVITY_LUNCHMODE).getList(), Constance.ACTIVITY_LUNCHMODE);
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable(Constance.MYDATA, myData);
                IntentUtils.intent(context, bundle1, CommonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
