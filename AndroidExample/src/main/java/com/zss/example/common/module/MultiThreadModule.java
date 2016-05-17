package com.zss.example.common.module;

import android.content.Context;

import com.zss.example.common.Constance;
import com.zss.example.helper.multi_thread_helper.ThreadConceptHelper;
import com.zss.example.helper.multi_thread_helper.ThreadConcurrentHelper;
import com.zss.example.helper.multi_thread_helper.ThreadCreateRunHelper;
import com.zss.example.helper.multi_thread_helper.ThreadDispatchHelper;
import com.zss.example.helper.multi_thread_helper.ThreadInteractionHelper;
import com.zss.example.helper.multi_thread_helper.ThreadNewCharacterHelper;
import com.zss.example.helper.multi_thread_helper.ThreadStackModeltHelper;
import com.zss.example.helper.multi_thread_helper.ThreadStateConvertHelper;
import com.zss.example.helper.multi_thread_helper.ThreadSyncLockHelper;

import java.util.List;

/**
 * 描述：MultiThreadModule
 * Created by Administrator on 2016/3/31 0031.
 */
public class MultiThreadModule extends BaseModule {
    private Context context;
    private List<Integer> list;

    public MultiThreadModule(Context context, List<Integer> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void myModule(int type, int position) {
        threadModule(type, position);
    }

    /**
     * 方法描述:多线程模块的goNext
     *
     * @param type:类型
     * @param position:位置
     */
    private void threadModule(int type, int position) {
        switch (type) {
            case Constance.MULTI_THREAD_CONCEPT:
                ThreadConceptHelper.goNext(context, list.get(position));
                break;
            case Constance.MULTI_THREAD_CREATE_RUN:
                ThreadCreateRunHelper.goNext(context, list.get(position));
                break;
            case Constance.MULTI_THREAD_STACK_MODEL:
                ThreadStackModeltHelper.goNext(context, list.get(position));
                break;
            case Constance.MULTI_THREAD_CONVERT:
                ThreadStateConvertHelper.goNext(context, list.get(position));
                break;
            case Constance.MULTI_THREAD_SYNC_LOCK:
                ThreadSyncLockHelper.goNext(context, list.get(position));
                break;
            case Constance.MULTI_THREAD_INTERACTION:
                ThreadInteractionHelper.goNext(context, list.get(position));
                break;
            case Constance.MULTI_THREAD_DISPATCH:
                ThreadDispatchHelper.goNext(context, list.get(position));
                break;
            case Constance.MULTI_THREAD_CONCURRENT:
                ThreadConcurrentHelper.goNext(context, list.get(position));
                break;
            case Constance.MULTI_THREAD_NEW_CHARACTER:
                ThreadNewCharacterHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }
}
