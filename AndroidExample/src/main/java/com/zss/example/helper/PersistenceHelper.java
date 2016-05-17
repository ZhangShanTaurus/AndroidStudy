package com.zss.example.helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.common.CommonActivity;
import com.zss.example.common.Constance;
import com.zss.example.common.DataResource;
import com.zss.example.common.MyData;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：
 * Created by Administrator on 2016/1/14 0014.
 */
public class PersistenceHelper {

    private static MyData myData;

    public static void goNext(Context context, int index) {
        switch (index) {
            case com.zss.example.R.string.SQLite:
                myData = new MyData(com.zss.example.R.string.SQLite, new DataResource(Constance.SQLITE).getList(), Constance.SQLITE);
                break;
            case com.zss.example.R.string.file:
                myData = new MyData(com.zss.example.R.string.file, new DataResource(Constance.FILE).getList(), Constance.FILE);
                break;
            case com.zss.example.R.string.sharedPreferences:
                IntentUtils.intent(context, CommonActivity.class, false);
                return;
            default:
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constance.MYDATA, myData);
        IntentUtils.intent(context, bundle, CommonActivity.class, false);
    }
}
