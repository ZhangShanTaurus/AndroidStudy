package com.android.example.helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.CommonActivity;
import com.android.example.common.Constance;
import com.android.example.common.DataResource;
import com.android.example.common.MyData;
import com.android.example.utils.IntentUtils;

/**
 * 描述：MultiThreadHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class MultiThreadHelper {
    private static MyData myData;

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.thread_concept:
                myData = new MyData(R.string.thread_concept, new DataResource(Constance.MULTI_THREAD_CONCEPT).getList(), Constance.MULTI_THREAD_CONCEPT);
                break;
            case R.string.thread_create_run:
                myData = new MyData(R.string.thread_create_run, new DataResource(Constance.MULTI_THREAD_CREATE_RUN).getList(), Constance.MULTI_THREAD_CREATE_RUN);
                break;
            case R.string.thread_stack_model:
                myData = new MyData(R.string.thread_stack_model, new DataResource(Constance.MULTI_THREAD_STACK_MODEL).getList(), Constance.MULTI_THREAD_STACK_MODEL);
                break;
            case R.string.thread_state_convert:
                myData = new MyData(R.string.thread_state_convert, new DataResource(Constance.MULTI_THREAD_CONVERT).getList(), Constance.MULTI_THREAD_CONVERT);
                break;
            case R.string.thread_sync_lock:
                myData = new MyData(R.string.thread_sync_lock, new DataResource(Constance.MULTI_THREAD_SYNC_LOCK).getList(), Constance.MULTI_THREAD_SYNC_LOCK);
                break;
            case R.string.thread_interaction:
                myData = new MyData(R.string.thread_interaction, new DataResource(Constance.MULTI_THREAD_INTERACTION).getList(), Constance.MULTI_THREAD_INTERACTION);
                break;
            case R.string.thread_dispatch:
                myData = new MyData(R.string.thread_dispatch, new DataResource(Constance.MULTI_THREAD_DISPATCH).getList(), Constance.MULTI_THREAD_DISPATCH);
                break;
            case R.string.thread_concurrent:
                myData = new MyData(R.string.thread_concurrent, new DataResource(Constance.MULTI_THREAD_CONCURRENT).getList(), Constance.MULTI_THREAD_CONCURRENT);
                break;
            case R.string.thread_new_character:
                myData = new MyData(R.string.thread_new_character, new DataResource(Constance.MULTI_THREAD_NEW_CHARACTER).getList(), Constance.MULTI_THREAD_NEW_CHARACTER);
                break;
            default:
                return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constance.MYDATA, myData);
        IntentUtils.intent(context, bundle, CommonActivity.class, false);
    }
}
