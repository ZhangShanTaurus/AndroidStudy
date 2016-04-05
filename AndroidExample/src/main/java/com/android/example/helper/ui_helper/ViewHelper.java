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
 * 描述：
 * Created by Administrator on 2016/1/14 0014.
 */
public class ViewHelper {
    private static MyData myData;

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.widgets:
                myData = new MyData(R.string.widgets, new DataResource(Constance.WIDGETS).getList(), Constance.WIDGETS);
                break;
            case R.string.containers:
                myData = new MyData(R.string.containers, new DataResource(Constance.CONTAINER).getList(), Constance.CONTAINER);
                break;
            case R.string.data_time:
                myData = new MyData(R.string.data_time, new DataResource(Constance.DATA_TIME).getList(), Constance.DATA_TIME);
                break;
            case R.string.expert:
                myData = new MyData(R.string.expert, new DataResource(Constance.EXPERT).getList(), Constance.EXPERT);
                break;
            case R.string.custom:
                myData = new MyData(R.string.custom, new DataResource(Constance.CUSTOM).getList(), Constance.CUSTOM);
                break;
            default:
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constance.MYDATA, myData);
        IntentUtils.intent(context, bundle, CommonActivity.class, false);
    }
}
