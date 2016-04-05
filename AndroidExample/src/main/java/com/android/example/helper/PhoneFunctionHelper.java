package com.android.example.helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.CommonActivity;
import com.android.example.common.Constance;
import com.android.example.common.DataResource;
import com.android.example.common.MyData;
import com.android.example.ui.layout.FrameLayoutActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：PhoneFunctionHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class PhoneFunctionHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.phone:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.phone);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.SMS:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.SMS);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.camera:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.camera);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.audio:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.audio);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.sd_card:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.sd_card);
                IntentUtils.intent(context, bundle, FrameLayoutActivity.class, false);
                break;
            case R.string.sensor:
                MyData myData = new MyData(R.string.sensor, new DataResource(Constance.PHONE_FUNCTION_SENSOR).getList(), Constance.PHONE_FUNCTION_SENSOR);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable(Constance.MYDATA, myData);
                IntentUtils.intent(context, bundle2, CommonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
