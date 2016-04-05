package com.android.example.helper;

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
public class PersistenceHelper {

    private static MyData myData;

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.SQLite:
                myData = new MyData(R.string.SQLite, new DataResource(Constance.SQLITE).getList(), Constance.SQLITE);
                break;
            case R.string.file:
                myData = new MyData(R.string.file, new DataResource(Constance.FILE).getList(), Constance.FILE);
                break;
            case R.string.sharedPreferences:
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
