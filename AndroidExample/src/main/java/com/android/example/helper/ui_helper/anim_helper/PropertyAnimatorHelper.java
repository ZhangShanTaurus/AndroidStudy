package com.android.example.helper.ui_helper.anim_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.CommonActivity;
import com.android.example.common.Constance;
import com.android.example.common.DataResource;
import com.android.example.common.MyData;
import com.android.example.ui.anim.property_animation.PropertyAnimatorBaseInfoActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：View模块下PropertyAnimation帮助类
 * Created by Administrator on 2016/1/14 0014.
 */
public class PropertyAnimatorHelper {
    private static MyData myData;

    public static void goNext(Context context, int index) {

        switch (index) {
            case R.string.property_animation_base_info:
                Bundle bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.property_animation_base_info);
                IntentUtils.intent(context, bundle, PropertyAnimatorBaseInfoActivity.class, false);
                return;
            case R.string.valueAnimator:
                myData = new MyData(R.string.valueAnimator, new DataResource(Constance.VALUE_ANIMATOR).getList(), Constance.VALUE_ANIMATOR);
                break;
            case R.string.objectAnimator:
                myData = new MyData(R.string.objectAnimator, new DataResource(Constance.OBJECT_ANIMATOR).getList(), Constance.OBJECT_ANIMATOR);
                break;
            case R.string.propertyValuesHolder:
                myData = new MyData(R.string.propertyValuesHolder, new DataResource(Constance.PROPERTY_VALUES_HOLDER).getList(), Constance.PROPERTY_VALUES_HOLDER);
                break;
            case R.string.animator_set_code:
                myData = new MyData(R.string.animator_set_code, new DataResource(Constance.ANIMATOR_SET_CODE).getList(), Constance.ANIMATOR_SET_CODE);
                break;
            case R.string.animator_set_xml:
                myData = new MyData(R.string.animator_set_xml, new DataResource(Constance.ANIMATOR_SET_XML).getList(), Constance.ANIMATOR_SET_XML);
                break;
            default:
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constance.MYDATA, myData);
        IntentUtils.intent(context, bundle, CommonActivity.class, false);
    }
}
