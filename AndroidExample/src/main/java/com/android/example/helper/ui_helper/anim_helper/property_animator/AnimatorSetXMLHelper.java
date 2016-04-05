package com.android.example.helper.ui_helper.anim_helper.property_animator;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.ui.anim.property_animation.animator_set_xml.AnimatorSetXMLAnimatorActivity;
import com.android.example.ui.anim.property_animation.animator_set_xml.AnimatorSetXMLCommonActivity;
import com.android.example.ui.anim.property_animation.animator_set_xml.AnimatorSetXMLObjectAnimatorActivity;
import com.android.example.ui.anim.property_animation.animator_set_xml.AnimatorSetXMLSampleActivity;
import com.android.example.ui.anim.property_animation.animator_set_xml.AnimatorSetXMLSetAnimatorActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：AnimatorSetXMLHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class AnimatorSetXMLHelper {
    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.animator_set_xml_common:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animator_set_xml_common);
                IntentUtils.intent(context, bundle, AnimatorSetXMLCommonActivity.class, false);
                break;
            case R.string.animator_set_xml_animator:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animator_set_xml_animator);
                IntentUtils.intent(context, bundle, AnimatorSetXMLAnimatorActivity.class, false);
                break;
            case R.string.animator_set_xml_object_animator:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animator_set_xml_object_animator);
                IntentUtils.intent(context, bundle, AnimatorSetXMLObjectAnimatorActivity.class, false);
                break;
            case R.string.animator_set_xml_set:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animator_set_xml_set);
                IntentUtils.intent(context, bundle, AnimatorSetXMLSetAnimatorActivity.class, false);
                break;
            case R.string.animator_set_xml_sample:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.animator_set_xml_sample);
                IntentUtils.intent(context, bundle, AnimatorSetXMLSampleActivity.class, false);
                break;
            default:
                break;
        }
    }
}
