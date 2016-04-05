package com.android.example.helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.CommonActivity;
import com.android.example.common.Constance;
import com.android.example.common.DataResource;
import com.android.example.common.MyData;
import com.android.example.ui.event_dispatch.EventDispatchActivity;
import com.android.example.ui.openGL.OpenGLActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：
 * Created by Administrator on 2016/1/14 0014.
 */
public class UIHelper {
    private static MyData myData;

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.Layout:
                myData = new MyData(R.string.Layout, new DataResource(Constance.LAYOUT).getList(), Constance.LAYOUT);
                break;
            case R.string.View:
                myData = new MyData(R.string.View, new DataResource(Constance.VIEW).getList(), Constance.VIEW);
                break;
            case R.string.CustomView:
                myData = new MyData(R.string.CustomView, new DataResource(Constance.CUSTOM_VIEW).getList(), Constance.CUSTOM_VIEW);
                break;
            case R.string.anim:
                myData = new MyData(R.string.anim, new DataResource(Constance.ANIM).getList(), Constance.ANIM);
                break;
            case R.string.Resource:
                myData = new MyData(R.string.Resource, new DataResource(Constance.RESOURCE).getList(), Constance.RESOURCE);
                break;
            case R.string.OpenGL:
                //跳转到特定的activity，不是commonActivity,要return
                Bundle bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.OpenGL);
                IntentUtils.intent(context, bundle, OpenGLActivity.class, false);
                return;
            case R.string.event_dispatch:
                Bundle bundle1 = new Bundle();
                bundle1.putInt(Constance.TITLE, R.string.event_dispatch);
                IntentUtils.intent(context, bundle1, EventDispatchActivity.class, false);
                return;
            default:
                myData = new MyData(R.string.Layout, new DataResource(Constance.LAYOUT).getList(), Constance.LAYOUT);
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constance.MYDATA, myData);
        IntentUtils.intent(context, bundle, CommonActivity.class, false);
    }
}
