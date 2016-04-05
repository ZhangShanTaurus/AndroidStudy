package com.android.example.helper.persistence_helper;

import android.content.Context;

import com.android.example.R;
import com.android.example.ui.layout.FrameLayoutActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：SQLitePersistenceHelper
 * Created by Administrator on 2016/1/15 0015.
 */
public class SQLitePersistenceHelper {
    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.SQLiteOpenHelper:
                IntentUtils.intent(context, FrameLayoutActivity.class, false);
                break;
            case R.string.contentProvider:
                IntentUtils.intent(context, FrameLayoutActivity.class, false);
                break;
            default:
                break;
        }

    }
}
