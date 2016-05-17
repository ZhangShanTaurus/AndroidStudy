package com.zss.example.helper.ui_helper.resource_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.ui.resource.ResourceCommonActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：View模块下Res帮助类
 * Created by Administrator on 2016/1/14 0014.
 */
public class ResHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle = null;
        switch (index) {
            case R.string.anim1:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.anim1);
                break;
            case R.string.animator:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animator);
                break;
            case R.string.color:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.color);
                break;
            case R.string.drawable:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.drawable);
                break;
            case R.string.interpolator:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.interpolator);
                break;
            case R.string.layout:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.layout);
                break;
            case R.string.menu:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.menu);
                break;
            case R.string.raw:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.raw);
                break;
            case R.string.values:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.values);
                break;
            case R.string.xml:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.xml);
                break;
            default:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.title);
                break;
        }
        IntentUtils.intent(context, bundle, ResourceCommonActivity.class, false);
    }
}
