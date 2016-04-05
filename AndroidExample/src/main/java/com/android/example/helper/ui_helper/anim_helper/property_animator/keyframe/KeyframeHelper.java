package com.android.example.helper.ui_helper.anim_helper.property_animator.keyframe;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.ui.anim.property_animation.keyframe.KeyframeBaseInfoActivity;
import com.android.example.ui.anim.property_animation.keyframe.KeyframeInterpolatorActivity;
import com.android.example.ui.anim.property_animation.keyframe.KeyframeMethod1Activity;
import com.android.example.ui.anim.property_animation.keyframe.KeyframeMethod2Activity;
import com.android.example.ui.anim.property_animation.keyframe.KeyframeOtherInfoActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：KeyframeHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class KeyframeHelper {
    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.keyframe_base_info:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.keyframe_base_info);
                IntentUtils.intent(context, bundle, KeyframeBaseInfoActivity.class, false);
                break;
            case R.string.keyframe_method:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.keyframe_method);
                IntentUtils.intent(context, bundle, KeyframeMethod1Activity.class, false);
                break;
            case R.string.keyframe_method2:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.keyframe_method2);
                IntentUtils.intent(context, bundle, KeyframeMethod2Activity.class, false);
                break;
            case R.string.keyframe_interpolator:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.keyframe_interpolator);
                IntentUtils.intent(context, bundle, KeyframeInterpolatorActivity.class, false);
                break;
            case R.string.keyframe_other_info:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.keyframe_other_info);
                IntentUtils.intent(context, bundle, KeyframeOtherInfoActivity.class, false);
                break;
            default:
                break;
        }
    }
}
