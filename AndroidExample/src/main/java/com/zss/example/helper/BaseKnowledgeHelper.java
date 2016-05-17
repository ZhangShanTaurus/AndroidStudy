package com.zss.example.helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.R;
import com.zss.example.common.CommonActivity;
import com.zss.example.common.Constance;
import com.zss.example.common.DataResource;
import com.zss.example.common.MyData;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：BaseKnowledgeHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class BaseKnowledgeHelper {
    private static MyData myData;

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.JavaBase:
                myData = new MyData(R.string.JavaBase, new DataResource(Constance.JAVA_BASE).getList(), Constance.JAVA_BASE);
                break;
            case R.string.data_structure:
                myData = new MyData(R.string.data_structure, new DataResource(Constance.DATA_STRUCTURE).getList(), Constance.DATA_STRUCTURE);
                break;
            case R.string.object_oriented_ideas:
                myData = new MyData(R.string.object_oriented_ideas, new DataResource(Constance.OBJECT_IDEAS).getList(), Constance.OBJECT_IDEAS);
                break;
            case R.string.design_mode:
                myData = new MyData(R.string.design_mode, new DataResource(Constance.DESIGN_MODE).getList(), Constance.DESIGN_MODE);
                break;
            case R.string.android_sdk:
                myData = new MyData(R.string.android_sdk, new DataResource(Constance.ANDROID_SDK).getList(), Constance.ANDROID_SDK);
                break;
            case R.string.activity:
                myData = new MyData(R.string.activity, new DataResource(Constance.ACTIVITY).getList(), Constance.ACTIVITY);
                break;
            case R.string.service:
                myData = new MyData(R.string.service, new DataResource(Constance.SERVICE).getList(), Constance.SERVICE);
                break;
            case R.string.broadcast_receiver:
                myData = new MyData(R.string.broadcast_receiver, new DataResource(Constance.BROADCAST_RECEIVER).getList(), Constance.BROADCAST_RECEIVER);
                break;
            case R.string.content_provider:
                myData = new MyData(R.string.content_provider, new DataResource(Constance.CONTENT_PROVIDER).getList(), Constance.CONTENT_PROVIDER);
                break;
            case R.string.action_bar:
                myData = new MyData(R.string.action_bar, new DataResource(Constance.ACTION_BAR).getList(), Constance.ACTION_BAR);
                break;
            case R.string.fragment:
                myData = new MyData(R.string.fragment, new DataResource(Constance.FRAGMENT).getList(), Constance.FRAGMENT);
                break;
            case R.string.handler_looper_message:
                myData = new MyData(R.string.handler_looper_message, new DataResource(Constance.HANDLER_LOOPER_MESSAGE).getList(), Constance.HANDLER_LOOPER_MESSAGE);
                break;
            default:
                return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constance.MYDATA, myData);
        IntentUtils.intent(context, bundle, CommonActivity.class, false);
    }
}
