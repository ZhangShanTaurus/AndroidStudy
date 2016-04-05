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
public class ResourceHelper {
    private static MyData myData;

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.res:
                myData = new MyData(R.string.res, new DataResource(Constance.RES).getList(), Constance.RES);
                break;
            case R.string.assets:
                myData = new MyData(R.string.assets, new DataResource(Constance.ASSETS).getList(), Constance.ASSETS);
                break;
            default:
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constance.MYDATA, myData);
        IntentUtils.intent(context, bundle, CommonActivity.class, false);
    }
}
