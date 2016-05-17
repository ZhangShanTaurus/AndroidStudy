package com.zss.example.helper.communication_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.common.Constance;
import com.zss.example.communication.tcp_udp.TcpActivity;
import com.zss.example.communication.tcp_udp.TcpUdpDiffActivity;
import com.zss.example.communication.tcp_udp.UdpActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：HttpHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class TcpUdpHelper {
    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case com.zss.example.R.string.udp:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.udp);
                IntentUtils.intent(context, bundle, UdpActivity.class, false);
                break;
            case com.zss.example.R.string.tcp:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.tcp);
                IntentUtils.intent(context, bundle, TcpActivity.class, false);
                break;
            case com.zss.example.R.string.udp_tcp_diff:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.udp_tcp_diff);
                IntentUtils.intent(context, bundle, TcpUdpDiffActivity.class, false);
                break;
            default:
                break;
        }

    }
}
