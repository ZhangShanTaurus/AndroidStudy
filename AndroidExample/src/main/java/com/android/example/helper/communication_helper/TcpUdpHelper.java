package com.android.example.helper.communication_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.communication.tcp_udp.TcpActivity;
import com.android.example.communication.tcp_udp.TcpUdpDiffActivity;
import com.android.example.communication.tcp_udp.UdpActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：HttpHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class TcpUdpHelper {
    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.udp:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.udp);
                IntentUtils.intent(context, bundle, UdpActivity.class, false);
                break;
            case R.string.tcp:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.tcp);
                IntentUtils.intent(context, bundle, TcpActivity.class, false);
                break;
            case R.string.udp_tcp_diff:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.udp_tcp_diff);
                IntentUtils.intent(context, bundle, TcpUdpDiffActivity.class, false);
                break;
            default:
                break;
        }

    }
}
