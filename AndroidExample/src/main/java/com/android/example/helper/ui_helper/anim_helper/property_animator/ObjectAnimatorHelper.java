package com.android.example.helper.ui_helper.anim_helper.property_animator;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.ui.anim.property_animation.object_animation.ObjectAnimatorBaseInfoActivity;
import com.android.example.ui.anim.property_animation.object_animation.ObjectAnimatorDefineActivity;
import com.android.example.ui.anim.property_animation.object_animation.ObjectAnimatorPrincipleActivity;
import com.android.example.ui.anim.property_animation.object_animation.ObjectAnimatorMethodActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：ObjectAnimatorHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class ObjectAnimatorHelper {
    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.object_animation_base_info:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.object_animation_base_info);
                IntentUtils.intent(context, bundle, ObjectAnimatorBaseInfoActivity.class, false);
                break;
            case R.string.object_animation_principle:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.object_animation_principle);
                IntentUtils.intent(context, bundle, ObjectAnimatorPrincipleActivity.class, false);
                break;
            case R.string.object_animation_define:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.object_animation_define);
                IntentUtils.intent(context, bundle, ObjectAnimatorDefineActivity.class, false);
                break;
            case R.string.object_animation_method:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.object_animation_method);
                IntentUtils.intent(context, bundle, ObjectAnimatorMethodActivity.class, false);
                break;
            default:
                break;
        }
    }
}
