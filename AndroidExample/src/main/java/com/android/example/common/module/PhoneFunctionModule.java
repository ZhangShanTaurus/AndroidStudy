package com.android.example.common.module;

import android.content.Context;

import com.android.example.common.Constance;
import com.android.example.helper.phone_function_helper.SensorHelper;

import java.util.List;

/**
 * 描述：PhoneFunctionModule
 * Created by Administrator on 2016/3/31 0031.
 */
public class PhoneFunctionModule extends BaseModule {
    private Context context;
    private List<Integer> list;

    public PhoneFunctionModule(Context context, List<Integer> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void myModule(int type, int position) {
        phoneFunctionModule(type, position);
    }

    /**
     * 方法描述:PhoneFunction
     *
     * @param type:类型
     * @param position:位置
     */
    private void phoneFunctionModule(int type, int position) {
        switch (type) {
            case Constance.PHONE_FUNCTION_SENSOR:
                SensorHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }
}
