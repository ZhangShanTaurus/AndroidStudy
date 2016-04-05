package com.android.example.helper.phone_function_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.ui.layout.FrameLayoutActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：SensorHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class SensorHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.accelerate:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.accelerate);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.direction:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.direction);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.gravity:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.gravity);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.lightRay:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.lightRay);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.gyroscope:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.gyroscope);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.magneticField:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.magneticField);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.approach:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.approach);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.temperature:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.temperature);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.pressure:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.pressure);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.linearAcceleration:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.linearAcceleration);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.rotation:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.rotation);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            default:
                break;
        }
    }
}
