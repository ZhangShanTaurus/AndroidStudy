package com.android.example.helper.base_knowledge_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.base_knowledge.service.DestroySevWayActivity;
import com.android.example.base_knowledge.service.ForegroundServiceActivity;
import com.android.example.base_knowledge.service.IntentServiceActivity;
import com.android.example.base_knowledge.service.RemoteServiceActivity;
import com.android.example.base_knowledge.service.ServiceWithThreadActivity;
import com.android.example.base_knowledge.service.SevToActCommunicationActivity;
import com.android.example.base_knowledge.service.SimpleServiceActivity;
import com.android.example.common.Constance;
import com.android.example.utils.IntentUtils;

/**
 * 描述：ServiceHelper
 * Created by Administrator on 2016/2/22 0022.
 */
public class ServiceHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle = null;
        switch (index) {
            case R.string.simpleService:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.simpleService);
                IntentUtils.intent(context, bundle, SimpleServiceActivity.class, false);
                break;
            case R.string.serviceCommunicationToActivity:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.serviceCommunicationToActivity);
                IntentUtils.intent(context, bundle, SevToActCommunicationActivity.class, false);
                break;
            case R.string.serviceDestroyWay:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.serviceDestroyWay);
                IntentUtils.intent(context, bundle, DestroySevWayActivity.class, false);
                break;
            case R.string.serviceAndThread:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.serviceAndThread);
                IntentUtils.intent(context, bundle, ServiceWithThreadActivity.class, false);
                break;
            case R.string.foregroundService:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.foregroundService);
                IntentUtils.intent(context, bundle, ForegroundServiceActivity.class, false);
                break;
            case R.string.remoteService:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.remoteService);
                IntentUtils.intent(context, bundle, RemoteServiceActivity.class, false);
                break;
            case R.string.intentService:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.intentService);
                IntentUtils.intent(context, bundle, IntentServiceActivity.class, false);
                break;
            default:
                break;
        }
    }
}
