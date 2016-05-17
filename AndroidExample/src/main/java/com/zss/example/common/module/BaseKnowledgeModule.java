package com.zss.example.common.module;

import android.content.Context;

import com.zss.example.common.Constance;
import com.zss.example.helper.base_knowledge_helper.ActionBarHelper;
import com.zss.example.helper.base_knowledge_helper.ActivityHelper;
import com.zss.example.helper.base_knowledge_helper.BroadcastReceiverHelper;
import com.zss.example.helper.base_knowledge_helper.ContentProviderHelper;
import com.zss.example.helper.base_knowledge_helper.DesignModeHelper;
import com.zss.example.helper.base_knowledge_helper.FragmentHelper;
import com.zss.example.helper.base_knowledge_helper.HandlerLooperMessageHelper;
import com.zss.example.helper.base_knowledge_helper.ServiceHelper;
import com.zss.example.helper.base_knowledge_helper.activity_lunch_mode.ActivityLunchModeHelper;

import java.util.List;

/**
 * 描述：BaseKnowledgeModule
 * Created by Administrator on 2016/3/31 0031.
 */
public class BaseKnowledgeModule extends BaseModule {
    private Context context;
    private List<Integer> list;

    public BaseKnowledgeModule(Context context, List<Integer> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void myModule(int type, int position) {
        baseKnowledgeModule(type, position);
        activityLunchMode(type, position);
    }

    /**
     * 方法描述:基础知识模块
     *
     * @param type:类型
     * @param position:位置
     */
    private void baseKnowledgeModule(int type, int position) {
        switch (type) {
            case Constance.JAVA_BASE:
                break;
            case Constance.DATA_STRUCTURE:
                break;
            case Constance.OBJECT_IDEAS:
                break;
            case Constance.DESIGN_MODE:
                DesignModeHelper.goNext(context, list.get(position));
                break;
            case Constance.ANDROID_SDK:
                break;
            case Constance.ACTIVITY:
                ActivityHelper.goNext(context, list.get(position));
                break;
            case Constance.SERVICE:
                ServiceHelper.goNext(context, list.get(position));
                break;
            case Constance.BROADCAST_RECEIVER:
                BroadcastReceiverHelper.goNext(context, list.get(position));
                break;
            case Constance.CONTENT_PROVIDER:
                ContentProviderHelper.goNext(context, list.get(position));
                break;
            case Constance.ACTION_BAR:
                ActionBarHelper.goNext(context, list.get(position));
                break;
            case Constance.FRAGMENT:
                FragmentHelper.goNext(context, list.get(position));
                break;
            case Constance.HANDLER_LOOPER_MESSAGE:
                HandlerLooperMessageHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }

    /**
     * Activity启动模式
     */
    private void activityLunchMode(int type, int position) {
        switch (type) {
            case Constance.ACTIVITY_LUNCHMODE:
                ActivityLunchModeHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }
}
