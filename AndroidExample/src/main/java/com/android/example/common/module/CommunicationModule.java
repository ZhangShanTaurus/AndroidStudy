package com.android.example.common.module;

import android.content.Context;

import com.android.example.common.Constance;
import com.android.example.helper.communication_helper.HttpHelper;
import com.android.example.helper.communication_helper.SocketHelper;
import com.android.example.helper.communication_helper.TcpUdpHelper;

import java.util.List;

/**
 * 描述：CommunicationModule
 * Created by Administrator on 2016/3/31 0031.
 */
public class CommunicationModule extends BaseModule {
    private Context context;
    private List<Integer> list;

    public CommunicationModule(Context context, List<Integer> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void myModule(int type, int position) {
        communicationModule(type, position);
    }

    /**
     * 方法描述:Communication
     *
     * @param type:类型
     * @param position:位置
     */
    private void communicationModule(int type, int position) {
        switch (type) {
            case Constance.TCP_UDP:
                TcpUdpHelper.goNext(context, list.get(position));
                break;
            case Constance.HTTP:
                HttpHelper.goNext(context, list.get(position));
                break;
            case Constance.SOCKET:
                SocketHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }
}
