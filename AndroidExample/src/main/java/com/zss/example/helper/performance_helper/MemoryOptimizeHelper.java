package com.zss.example.helper.performance_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.common.CommonActivity;
import com.zss.example.common.Constance;
import com.zss.example.common.DataResource;
import com.zss.example.common.MyData;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：MemoryOptimizeHelper
 * Created by Administrator on 2016/1/15 0015.
 */
public class MemoryOptimizeHelper {

    public static void goNext(Context context, int index) {
        MyData myData = null;
        switch (index) {
            case com.zss.example.R.string.oom:
                myData = new MyData(com.zss.example.R.string.oom, new DataResource(Constance.PERFORMANCE_MEMORY_OPTIMIZE_OOM).getList(), Constance.PERFORMANCE_MEMORY_OPTIMIZE_OOM);
                break;
            case com.zss.example.R.string.image_handle:
                myData = new MyData(com.zss.example.R.string.image_handle, new DataResource(Constance.PERFORMANCE_MEMORY_OPTIMIZE_IMAGE_HANDLE).getList(), Constance.PERFORMANCE_MEMORY_OPTIMIZE_IMAGE_HANDLE);
                break;
            case com.zss.example.R.string.cache_machining:
                myData = new MyData(com.zss.example.R.string.cache_machining, new DataResource(Constance.PERFORMANCE_MEMORY_OPTIMIZE_CACHE_MACHING).getList(), Constance.PERFORMANCE_MEMORY_OPTIMIZE_CACHE_MACHING);
                break;
            case com.zss.example.R.string.anr:
                myData = new MyData(com.zss.example.R.string.anr, new DataResource(Constance.PERFORMANCE_MEMORY_OPTIMIZE_ANR).getList(), Constance.PERFORMANCE_MEMORY_OPTIMIZE_ANR);
                break;
            case com.zss.example.R.string.analyze:
                myData = new MyData(com.zss.example.R.string.analyze, new DataResource(Constance.PERFORMANCE_MEMORY_OPTIMIZE_ANALYZE).getList(), Constance.PERFORMANCE_MEMORY_OPTIMIZE_ANALYZE);
                break;
            default:
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constance.MYDATA, myData);
        IntentUtils.intent(context,bundle, CommonActivity.class, false);
    }
}
