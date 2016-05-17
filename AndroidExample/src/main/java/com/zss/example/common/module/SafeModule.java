package com.zss.example.common.module;

import android.content.Context;

import java.util.List;

/**
 * 描述：SafeModule
 * Created by Administrator on 2016/3/31 0031.
 */
public class SafeModule extends BaseModule {
    private Context context;
    private List<Integer> list;

    public SafeModule(Context context, List<Integer> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void myModule(int type, int position) {
        safeModule(type, position);
    }

    /**
     * 方法描述:基础知识模块
     *
     * @param type:类型
     * @param position:位置
     */
    private void safeModule(int type, int position) {
        switch (type) {
            default:
                break;
        }
    }
}
