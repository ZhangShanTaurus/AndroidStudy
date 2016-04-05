package com.android.example.common.module;

import android.content.Context;

import com.android.example.common.Constance;
import com.android.example.helper.performance_helper.MemoryOptimizeHelper;
import com.android.example.helper.performance_helper.UIOptimizeHelper;
import com.android.example.helper.performance_helper.memory.ANRHelper;
import com.android.example.helper.performance_helper.memory.AnalyzeHelper;
import com.android.example.helper.performance_helper.memory.CacheMachiningHelper;
import com.android.example.helper.performance_helper.memory.ImageHandleHelper;
import com.android.example.helper.performance_helper.memory.OOMHelper;

import java.util.List;

/**
 * 描述：PerformanceModule
 * Created by Administrator on 2016/3/31 0031.
 */
public class PerformanceModule extends BaseModule {
    private Context context;
    private List<Integer> list;

    public PerformanceModule(Context context, List<Integer> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void myModule(int type, int position) {
        performanceModule(type, position);
        memoryOptimizeModule(type, position);
    }

    /**
     * 方法描述:performance
     *
     * @param type:类型
     * @param position:位置
     */
    private void performanceModule(int type, int position) {
        switch (type) {
            case Constance.PERFORMANCE_UI_OPTIMIZE:
                UIOptimizeHelper.goNext(context, list.get(position));
                break;
            case Constance.PERFORMANCE_MEMORY_OPTIMIZE:
                MemoryOptimizeHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }

    /**
     * 内存优化
     */
    private void memoryOptimizeModule(int type, int position) {
        switch (type) {
            case Constance.PERFORMANCE_MEMORY_OPTIMIZE_OOM:
                OOMHelper.goNext(context, list.get(position));
                break;
            case Constance.PERFORMANCE_MEMORY_OPTIMIZE_IMAGE_HANDLE:
                ImageHandleHelper.goNext(context, list.get(position));
                break;
            case Constance.PERFORMANCE_MEMORY_OPTIMIZE_CACHE_MACHING:
                CacheMachiningHelper.goNext(context, list.get(position));
                break;
            case Constance.PERFORMANCE_MEMORY_OPTIMIZE_ANR:
                ANRHelper.goNext(context, list.get(position));
                break;
            case Constance.PERFORMANCE_MEMORY_OPTIMIZE_ANALYZE:
                AnalyzeHelper.goNext(context, list.get(position));
                break;
        }
    }
}
