package com.zss.example.helper.persistence_helper;

import android.content.Context;

import com.zss.example.ui.layout.FrameLayoutActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：SQLitePersistenceHelper
 * Created by Administrator on 2016/1/15 0015.
 */
public class SQLitePersistenceHelper {
    public static void goNext(Context context, int index) {
        switch (index) {
            case com.zss.example.R.string.SQLiteOpenHelper:
                IntentUtils.intent(context, FrameLayoutActivity.class, false);
                break;
            case com.zss.example.R.string.contentProvider:
                IntentUtils.intent(context, FrameLayoutActivity.class, false);
                break;
            default:
                break;
        }

    }
}
