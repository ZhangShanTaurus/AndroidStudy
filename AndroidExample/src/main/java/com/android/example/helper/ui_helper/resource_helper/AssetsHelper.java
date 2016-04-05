package com.android.example.helper.ui_helper.resource_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.ui.resource.AssetsActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：View模块下Assets帮助类
 * Created by Administrator on 2016/1/14 0014.
 */
public class AssetsHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.assetManager:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.assetManager);
                IntentUtils.intent(context, bundle, AssetsActivity.class, false);
                break;
            default:
                break;
        }
    }
}
