package com.android.example.helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.CommonActivity;
import com.android.example.common.Constance;
import com.android.example.common.DataResource;
import com.android.example.common.MyData;
import com.android.example.performance.ElectricOptimizeActivity;
import com.android.example.performance.FlowOptimizeActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：PerformanceHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class PerformanceHelper {

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.ui_optimize:
                MyData myData1 = new MyData(R.string.ui_optimize, new DataResource(Constance.PERFORMANCE_UI_OPTIMIZE).getList(), Constance.PERFORMANCE_UI_OPTIMIZE);
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable(Constance.MYDATA, myData1);
                IntentUtils.intent(context, bundle1, CommonActivity.class, false);
                break;
            case R.string.memory_optimize:
                MyData myData2 = new MyData(R.string.memory_optimize, new DataResource(Constance.PERFORMANCE_MEMORY_OPTIMIZE).getList(), Constance.PERFORMANCE_MEMORY_OPTIMIZE);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable(Constance.MYDATA, myData2);
                IntentUtils.intent(context, bundle2, CommonActivity.class, false);
                break;
            case R.string.electric_optimize:
                Bundle bundle3 = new Bundle();
                bundle3.putInt(Constance.TITLE, R.string.electric_optimize);
                IntentUtils.intent(context, bundle3, ElectricOptimizeActivity.class, false);
                break;
            case R.string.flow_optimize:
                Bundle bundle4 = new Bundle();
                bundle4.putInt(Constance.TITLE, R.string.flow_optimize);
                IntentUtils.intent(context, bundle4, FlowOptimizeActivity.class, false);
                break;
            default:
                break;
        }
    }
}
