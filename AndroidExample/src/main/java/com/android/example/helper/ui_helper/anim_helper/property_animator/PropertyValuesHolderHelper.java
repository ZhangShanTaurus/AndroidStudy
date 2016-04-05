package com.android.example.helper.ui_helper.anim_helper.property_animator;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.CommonActivity;
import com.android.example.common.Constance;
import com.android.example.common.DataResource;
import com.android.example.common.MyData;
import com.android.example.ui.anim.property_animation.property_value_holder.PropertyValueHolderInfoActivity;
import com.android.example.ui.anim.property_animation.property_value_holder.PropertyValueHolderMethod1Activity;
import com.android.example.ui.anim.property_animation.property_value_holder.PropertyValueHolderMethod2Activity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：ValueAnimatorHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class PropertyValuesHolderHelper {
    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.property_value_holder_info:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.property_value_holder_info);
                IntentUtils.intent(context, bundle, PropertyValueHolderInfoActivity.class, false);
                break;
            case R.string.property_value_holder_method:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.property_value_holder_method);
                IntentUtils.intent(context, bundle, PropertyValueHolderMethod1Activity.class, false);
                break;
            case R.string.property_value_holder_method2:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.property_value_holder_method2);
                IntentUtils.intent(context, bundle, PropertyValueHolderMethod2Activity.class, false);
                break;
            case R.string.property_value_holder_keyframe:
                MyData myData = new MyData(R.string.property_value_holder_keyframe,
                        new DataResource(Constance.PROPERTY_VALUES_HOLDER_KEYFRAME).getList(), Constance.PROPERTY_VALUES_HOLDER_KEYFRAME);
                bundle = new Bundle();
                bundle.putSerializable(Constance.MYDATA, myData);
                IntentUtils.intent(context, bundle, CommonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
