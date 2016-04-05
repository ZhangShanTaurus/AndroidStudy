package com.android.example.common.module;

import android.content.Context;

import com.android.example.common.Constance;
import com.android.example.helper.ui_helper.AnimHelper;
import com.android.example.helper.ui_helper.CustomViewHelper;
import com.android.example.helper.ui_helper.LayoutHelper;
import com.android.example.helper.ui_helper.ResourceHelper;
import com.android.example.helper.ui_helper.ViewHelper;
import com.android.example.helper.ui_helper.anim_helper.PropertyAnimatorHelper;
import com.android.example.helper.ui_helper.anim_helper.ViewAnimationHelper;
import com.android.example.helper.ui_helper.anim_helper.property_animator.AnimatorSetCodeHelper;
import com.android.example.helper.ui_helper.anim_helper.property_animator.AnimatorSetXMLHelper;
import com.android.example.helper.ui_helper.anim_helper.property_animator.ObjectAnimatorHelper;
import com.android.example.helper.ui_helper.anim_helper.property_animator.PropertyValuesHolderHelper;
import com.android.example.helper.ui_helper.anim_helper.property_animator.ValueAnimatorHelper;
import com.android.example.helper.ui_helper.anim_helper.property_animator.keyframe.KeyframeHelper;
import com.android.example.helper.ui_helper.anim_helper.view_animation.FrameAnimationHelper;
import com.android.example.helper.ui_helper.anim_helper.view_animation.TweenAnimationHelper;
import com.android.example.helper.ui_helper.custom_view.CombinationViewHelper;
import com.android.example.helper.ui_helper.custom_view.ExtendsSystemViewHelper;
import com.android.example.helper.ui_helper.custom_view.ExtendsViewHelper;
import com.android.example.helper.ui_helper.resource_helper.AssetsHelper;
import com.android.example.helper.ui_helper.resource_helper.ResHelper;
import com.android.example.helper.ui_helper.view_helper.ViewContainerHelper;
import com.android.example.helper.ui_helper.view_helper.ViewCustomHelper;
import com.android.example.helper.ui_helper.view_helper.ViewDataTimeHelper;
import com.android.example.helper.ui_helper.view_helper.ViewExpertHelper;
import com.android.example.helper.ui_helper.view_helper.ViewWidgetsHelper;

import java.util.List;

/**
 * 描述：UIModule
 * Created by Administrator on 2016/3/31 0031.
 */
public class UIModule extends BaseModule {
    private Context context;
    private List<Integer> list;

    public UIModule(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void myModule(int type, int position) {
        uiModule(type, position);
        viewModule(type, position);
        customViewModule(type, position);
        animModule(type, position);
        viewAnimationModule(type, position);
        propertyAnimatorModule(type, position);
        resourceModule(type, position);
    }

    /**
     * 方法描述:UI模块的goNext
     *
     * @param type:类型
     * @param position:位置
     */
    private void uiModule(int type, int position) {
        switch (type) {
            case Constance.LAYOUT:
                LayoutHelper.goNext(context, list.get(position));
                break;
            case Constance.VIEW:
                ViewHelper.goNext(context, list.get(position));
                break;
            case Constance.CUSTOM_VIEW:
                CustomViewHelper.goNext(context, list.get(position));
                break;
            case Constance.ANIM:
                AnimHelper.goNext(context, list.get(position));
                break;
            case Constance.RESOURCE:
                ResourceHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }

    /**
     * 方法描述:View模块的goNext
     *
     * @param type:类型
     * @param position:位置
     */
    private void viewModule(int type, int position) {
        switch (type) {
            case Constance.WIDGETS:
                ViewWidgetsHelper.goNext(context, list.get(position));
                break;
            case Constance.CONTAINER:
                ViewContainerHelper.goNext(context, list.get(position));
                break;
            case Constance.DATA_TIME:
                ViewDataTimeHelper.goNext(context, list.get(position));
                break;
            case Constance.EXPERT:
                ViewExpertHelper.goNext(context, list.get(position));
                break;
            case Constance.CUSTOM:
                ViewCustomHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }

    /**
     * 方法描述:customView
     *
     * @param type:类型
     * @param position:位置
     */
    private void customViewModule(int type, int position) {
        switch (type) {
            case Constance.EXTENDS_SYSTEM_VIEW:
                ExtendsSystemViewHelper.goNext(context, list.get(position));
                break;
            case Constance.EXTENDS_VIEW:
                ExtendsViewHelper.goNext(context, list.get(position));
                break;
            case Constance.COMBINATION_VIEW:
                CombinationViewHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }

    /**
     * 方法描述:UI/Anim模块的goNext
     *
     * @param type:类型
     * @param position:位置
     */
    private void animModule(int type, int position) {
        switch (type) {
            case Constance.VIEW_ANIMATION:
                ViewAnimationHelper.goNext(context, list.get(position));
                break;
            case Constance.PROPERTY_ANIMATOR:
                PropertyAnimatorHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }

    /**
     * ViewAnimation
     */
    private void viewAnimationModule(int type, int position) {
        switch (type) {
            case Constance.TWEEN_ANIMATION:
                TweenAnimationHelper.goNext(context, list.get(position));
                break;
            case Constance.FRAME_ANIMATION:
                FrameAnimationHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }

    /**
     * ViewAnimation
     */
    private void propertyAnimatorModule(int type, int position) {
        switch (type) {
            case Constance.VALUE_ANIMATOR:
                ValueAnimatorHelper.goNext(context, list.get(position));
                break;
            case Constance.OBJECT_ANIMATOR:
                ObjectAnimatorHelper.goNext(context, list.get(position));
                break;
            case Constance.PROPERTY_VALUES_HOLDER:
                PropertyValuesHolderHelper.goNext(context, list.get(position));
                break;
            case Constance.PROPERTY_VALUES_HOLDER_KEYFRAME:
                KeyframeHelper.goNext(context, list.get(position));
                break;
            case Constance.ANIMATOR_SET_CODE:
                AnimatorSetCodeHelper.goNext(context, list.get(position));
                break;
            case Constance.ANIMATOR_SET_XML:
                AnimatorSetXMLHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }

    /**
     * 方法描述:UI/Resource模块的goNext
     *
     * @param type:类型
     * @param position:位置
     */
    private void resourceModule(int type, int position) {
        switch (type) {
            case Constance.ASSETS:
                AssetsHelper.goNext(context, list.get(position));
                break;
            case Constance.RES:
                ResHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }
}
