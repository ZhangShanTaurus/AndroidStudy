package com.zss.example.helper.persistence_helper;

import android.content.Context;

import com.zss.example.ui.layout.FrameLayoutActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：FilePersistenceHelper
 * Created by Administrator on 2016/1/15 0015.
 */
public class FilePersistenceHelper {
    public static void goNext(Context context, int index) {
        switch (index) {
            case com.zss.example.R.string.internalFile:
                IntentUtils.intent(context, FrameLayoutActivity.class, false);
                break;
            case com.zss.example.R.string.externalFile:
                IntentUtils.intent(context, FrameLayoutActivity.class, false);
                break;
            default:
                break;
        }

    }
}
