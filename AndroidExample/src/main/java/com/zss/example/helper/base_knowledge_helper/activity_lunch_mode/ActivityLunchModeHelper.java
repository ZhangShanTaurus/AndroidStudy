package com.zss.example.helper.base_knowledge_helper.activity_lunch_mode;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.R;
import com.zss.example.base_knowledge.activity.lunch_mode.LunchModeSingleInstanceActivity;
import com.zss.example.base_knowledge.activity.lunch_mode.LunchModeSingleTaskActivity;
import com.zss.example.base_knowledge.activity.lunch_mode.LunchModeSingleTopActivity;
import com.zss.example.base_knowledge.activity.lunch_mode.LunchModeStandardActivity;
import com.zss.example.common.Constance;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：ActivityLunchModeHelper
 * Created by Administrator on 2016/2/22 0022.
 */
public class ActivityLunchModeHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle = null;
        switch (index) {
            case R.string.activity_lunchMode_standard:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.activity_lunchMode_standard);
                IntentUtils.intent(context, bundle, LunchModeStandardActivity.class, false);
                break;
            case R.string.activity_lunchMode_singleTop:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.activity_lunchMode_singleTop);
                IntentUtils.intent(context, bundle, LunchModeSingleTopActivity.class, false);
                break;
            case R.string.activity_lunchMode_singleTask:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.activity_lunchMode_singleTask);
                IntentUtils.intent(context, bundle, LunchModeSingleTaskActivity.class, false);
                break;
            case R.string.activity_lunchMode_singleInstance:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.activity_lunchMode_singleInstance);
                IntentUtils.intent(context, bundle, LunchModeSingleInstanceActivity.class, false);
                break;
            default:
                break;
        }
    }
}
