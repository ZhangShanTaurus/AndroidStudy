package com.android.example.helper.ui_helper.anim_helper.property_animator;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.ui.anim.property_animation.value_animation.ValueAnimator1Activity;
import com.android.example.ui.anim.property_animation.value_animation.ValueAnimator2Activity;
import com.android.example.ui.anim.property_animation.value_animation.ValueAnimator3Activity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：ValueAnimatorHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class ValueAnimatorHelper {
    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.value_animator_use1:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.value_animator_use1);
                IntentUtils.intent(context, bundle, ValueAnimator1Activity.class, false);
                break;
            case R.string.value_animator_use2:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.value_animator_use2);
                IntentUtils.intent(context, bundle, ValueAnimator2Activity.class, false);
                break;
            case R.string.value_animator_use3:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.value_animator_use3);
                IntentUtils.intent(context, bundle, ValueAnimator3Activity.class, false);
                break;
            default:
                break;
        }
    }
}
