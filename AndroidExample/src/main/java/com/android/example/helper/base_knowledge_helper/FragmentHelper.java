package com.android.example.helper.base_knowledge_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.base_knowledge.fragment.FragmentChangeActivity;
import com.android.example.base_knowledge.fragment.FragmentCommunicationToActivity;
import com.android.example.base_knowledge.fragment.FragmentDialogActivity;
import com.android.example.base_knowledge.fragment.FragmentDynamicAddActivity;
import com.android.example.base_knowledge.fragment.FragmentEmptyActivity;
import com.android.example.base_knowledge.fragment.FragmentIntegrationActivity;
import com.android.example.base_knowledge.fragment.FragmentIntroduceActivity;
import com.android.example.base_knowledge.fragment.FragmentLifecycleActivity;
import com.android.example.base_knowledge.fragment.FragmentStaticAddActivity;
import com.android.example.base_knowledge.fragment.ManageFragmentStackActivity;
import com.android.example.common.Constance;
import com.android.example.utils.IntentUtils;

/**
 * 描述：FragmentHelper
 * Created by Administrator on 2016/2/22 0022.
 */
public class FragmentHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle = null;
        switch (index) {
            case R.string.fragment_introduce:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.fragment_introduce);
                IntentUtils.intent(context, bundle, FragmentIntroduceActivity.class, false);
                break;
            case R.string.fragment_lifecycle:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.fragment_lifecycle);
                IntentUtils.intent(context, bundle, FragmentLifecycleActivity.class, false);
                break;
            case R.string.fragment_data_transmit:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.fragment_data_transmit);
                IntentUtils.intent(context, bundle, FragmentDynamicAddActivity.class, false);
                break;
            case R.string.fragment_static_add:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.fragment_static_add);
                IntentUtils.intent(context, bundle, FragmentStaticAddActivity.class, false);
                break;
            case R.string.fragment_dynamic_add:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.fragment_dynamic_add);
                IntentUtils.intent(context, bundle, FragmentDynamicAddActivity.class, false);
                break;
            case R.string.manage_fragment_stack:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.manage_fragment_stack);
                IntentUtils.intent(context, bundle, ManageFragmentStackActivity.class, false);
                break;
            case R.string.fragment_communication_activity:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.fragment_communication_activity);
                IntentUtils.intent(context, bundle, FragmentCommunicationToActivity.class, false);
                break;
            case R.string.fragment_change:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.fragment_change);
                IntentUtils.intent(context, bundle, FragmentChangeActivity.class, false);
                break;
            case R.string.fragment_with_actionBar_menuItem:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.fragment_with_actionBar_menuItem);
                IntentUtils.intent(context, bundle, FragmentIntegrationActivity.class, false);
                break;
            case R.string.fragment_null:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.fragment_null);
                IntentUtils.intent(context, bundle, FragmentEmptyActivity.class, false);
                break;
            case R.string.dialog_fragment:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.dialog_fragment);
                IntentUtils.intent(context, bundle, FragmentDialogActivity.class, false);
                break;
            default:
                break;
        }
    }
}
