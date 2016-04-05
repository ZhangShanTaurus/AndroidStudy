package com.android.example.helper.communication_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.communication.http.HttpClientActivity;
import com.android.example.communication.http.HttpConnectionActivity;
import com.android.example.communication.http.HttpSpecialtyActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：HttpHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class HttpHelper {
    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.httpConnection:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.httpConnection);
                IntentUtils.intent(context, bundle, HttpConnectionActivity.class, false);
                break;
            case R.string.httpClient:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.httpClient);
                IntentUtils.intent(context, bundle, HttpClientActivity.class, false);
                break;
            case R.string.http_specialty:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.http_specialty);
                IntentUtils.intent(context, bundle, HttpSpecialtyActivity.class, false);
                break;
            default:
                break;
        }

    }
}
