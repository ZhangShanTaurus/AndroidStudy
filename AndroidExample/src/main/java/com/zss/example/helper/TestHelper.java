package com.zss.example.helper;

import android.content.Context;

import com.zss.example.R;
import com.zss.example.common.CommonActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：
 * Created by Administrator on 2016/1/14 0014.
 */
public class TestHelper {

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.monkey:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.monkey_runner:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.junit:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.robotium:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.appium:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.athrun:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            case R.string.ui_automator:
                IntentUtils.intent(context, CommonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
