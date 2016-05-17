package com.zss.example.helper.ui_helper.anim_helper.property_animator;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.ui.anim.property_animation.animator_set_code.AnimatorSetBuilderActivity;
import com.zss.example.ui.anim.property_animation.animator_set_code.AnimatorSetDelayActivity;
import com.zss.example.ui.anim.property_animation.animator_set_code.AnimatorSetListenerActivity;
import com.zss.example.ui.anim.property_animation.animator_set_code.AnimatorSetPlayOrderActivity;
import com.zss.example.ui.anim.property_animation.animator_set_code.AnimatorSetSetActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：AnimatorSetCodeHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class AnimatorSetCodeHelper {
    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.animator_set_play_order:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animator_set_play_order);
                IntentUtils.intent(context, bundle, AnimatorSetPlayOrderActivity.class, false);
                break;
            case R.string.animator_set_builder:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animator_set_builder);
                IntentUtils.intent(context, bundle, AnimatorSetBuilderActivity.class, false);
                break;
            case R.string.animator_set_listener:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animator_set_listener);
                IntentUtils.intent(context, bundle, AnimatorSetListenerActivity.class, false);
                break;
            case R.string.animator_set_set:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animator_set_set);
                IntentUtils.intent(context, bundle, AnimatorSetSetActivity.class, false);
                break;
            case R.string.animator_set_set_delay:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animator_set_set_delay);
                IntentUtils.intent(context, bundle, AnimatorSetDelayActivity.class, false);
                break;
            default:
                break;
        }
    }
}
