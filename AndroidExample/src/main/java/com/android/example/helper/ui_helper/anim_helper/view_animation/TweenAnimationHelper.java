package com.android.example.helper.ui_helper.anim_helper.view_animation;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.ui.anim.view_animation.AnimationAlphaActivity;
import com.android.example.ui.anim.view_animation.AnimationCommonPropertyActivity;
import com.android.example.ui.anim.view_animation.AnimationInterpolatorActivity;
import com.android.example.ui.anim.view_animation.AnimationLayoutControllerActivity;
import com.android.example.ui.anim.view_animation.AnimationListenerActivity;
import com.android.example.ui.anim.view_animation.AnimationRotateActivity;
import com.android.example.ui.anim.view_animation.AnimationScaleActivity;
import com.android.example.ui.anim.view_animation.AnimationSetActivity;
import com.android.example.ui.anim.view_animation.AnimationTranslateActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：TweenAnimationHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class TweenAnimationHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.commonProperty:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.commonProperty);
                IntentUtils.intent(context, bundle, AnimationCommonPropertyActivity.class, false);
                break;
            case R.string.alpha:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.alpha);
                IntentUtils.intent(context, bundle, AnimationAlphaActivity.class, false);
                break;
            case R.string.scale:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.scale);
                IntentUtils.intent(context, bundle, AnimationScaleActivity.class, false);
                break;
            case R.string.translate:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.translate);
                IntentUtils.intent(context, bundle, AnimationTranslateActivity.class, false);
                break;
            case R.string.rotate:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.rotate);
                IntentUtils.intent(context, bundle, AnimationRotateActivity.class, false);
                break;
            case R.string.animation_set:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animation_set);
                IntentUtils.intent(context, bundle, AnimationSetActivity.class, false);
                break;
            case R.string.interpolator1:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.interpolator1);
                IntentUtils.intent(context, bundle, AnimationInterpolatorActivity.class, false);
                break;
            case R.string.layout_animation_controller:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.layout_animation_controller);
                IntentUtils.intent(context, bundle, AnimationLayoutControllerActivity.class, false);
                break;
            case R.string.animation_listener:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animation_listener);
                IntentUtils.intent(context, bundle, AnimationListenerActivity.class, false);
                break;
            default:
                break;
        }
    }
}
