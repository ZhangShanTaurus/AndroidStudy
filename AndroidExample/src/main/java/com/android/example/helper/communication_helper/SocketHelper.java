package com.android.example.helper.communication_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.communication.socket.SocketActivity;
import com.android.example.communication.socket.SocketAndHttpActivity;
import com.android.example.communication.socket.SocketAndTcpActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：HttpHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class SocketHelper {
    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.socket_use:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.socket_use);
                IntentUtils.intent(context, bundle, SocketActivity.class, false);
                break;
            case R.string.socket_tcp:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.socket_tcp);
                IntentUtils.intent(context, bundle, SocketAndTcpActivity.class, false);
                break;
            case R.string.socket_http:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.socket_http);
                IntentUtils.intent(context, bundle, SocketAndHttpActivity.class, false);
                break;
            default:
                break;
        }

    }
}
