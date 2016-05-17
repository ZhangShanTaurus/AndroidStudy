package com.zss.example.helper.ui_helper.anim_helper.view_animation;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.ui.anim.view_animation.AnimationListActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：FrameAnimationHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class FrameAnimationHelper {
    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.animation_list:
                Bundle bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animation_list);
                IntentUtils.intent(context, bundle, AnimationListActivity.class, false);
                break;
            default:
                break;
        }
    }
}
