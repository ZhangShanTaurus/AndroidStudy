package com.android.example.helper.ui_helper.view_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.ui.view.data_time.ChronometerActivity;
import com.android.example.ui.view.expert.AdapterViewFlipperActivity;
import com.android.example.ui.view.expert.AutoCompleteTextViewActivity;
import com.android.example.ui.view.expert.CheckedTextViewActivity;
import com.android.example.ui.view.expert.ExtractEditTextActivity;
import com.android.example.ui.view.expert.GestureOverlayViewActivity;
import com.android.example.ui.view.expert.ImageSwitcherActivity;
import com.android.example.ui.view.expert.MultiAutoCompleteTextViewActivity;
import com.android.example.ui.view.expert.NumberPickerActivity;
import com.android.example.ui.view.expert.QuickContactBadgeActivity;
import com.android.example.ui.view.expert.SpaceActivity;
import com.android.example.ui.view.expert.StackViewActivity;
import com.android.example.ui.view.expert.SurfaceViewActivity;
import com.android.example.ui.view.expert.TextSwitcherActivity;
import com.android.example.ui.view.expert.TextureViewActivity;
import com.android.example.ui.view.expert.ViewAnimatorActivity;
import com.android.example.ui.view.expert.ViewFlipperActivity;
import com.android.example.ui.view.expert.ViewPagerActivity;
import com.android.example.ui.view.expert.ViewStubActivity;
import com.android.example.ui.view.expert.ViewSwitcherActivity;
import com.android.example.ui.view.expert.ZoomButtonActivity;
import com.android.example.ui.view.expert.ZoomControlsActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：View模块下Expert帮助类
 * Created by Administrator on 2016/1/14 0014.
 */
public class ViewExpertHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle = null;
        switch (index) {
            case R.string.space:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.space);
                IntentUtils.intent(context, bundle, SpaceActivity.class, false);
                break;
            case R.string.checkedTextView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.checkedTextView);
                IntentUtils.intent(context, bundle, CheckedTextViewActivity.class, false);
                break;
            case R.string.quickContactBadge:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.quickContactBadge);
                IntentUtils.intent(context, bundle, QuickContactBadgeActivity.class, false);
                break;
            case R.string.extractEditText:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.extractEditText);
                IntentUtils.intent(context, bundle, ExtractEditTextActivity.class, false);
                break;
            case R.string.autoCompleteTextView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.autoCompleteTextView);
                IntentUtils.intent(context, bundle, AutoCompleteTextViewActivity.class, false);
                break;
            case R.string.multiAutoCompleteTextView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.multiAutoCompleteTextView);
                IntentUtils.intent(context, bundle, MultiAutoCompleteTextViewActivity.class, false);
                break;
            case R.string.numberPicker:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.numberPicker);
                IntentUtils.intent(context, bundle, NumberPickerActivity.class, false);
                break;
            case R.string.zoomButton:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.zoomButton);
                IntentUtils.intent(context, bundle, ZoomButtonActivity.class, false);
                break;
            case R.string.chronometer1:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.chronometer1);
                IntentUtils.intent(context, bundle, ChronometerActivity.class, false);
                break;
            case R.string.zoomController:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.zoomController);
                IntentUtils.intent(context, bundle, ZoomControlsActivity.class, false);
                break;
            case R.string.gestureOverlayView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.gestureOverlayView);
                IntentUtils.intent(context, bundle, GestureOverlayViewActivity.class, false);
                break;
            case R.string.surfaceView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.surfaceView);
                IntentUtils.intent(context, bundle, SurfaceViewActivity.class, false);
                break;
            case R.string.textureView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.textureView);
                IntentUtils.intent(context, bundle, TextureViewActivity.class, false);
                break;
            case R.string.stackView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.stackView);
                IntentUtils.intent(context, bundle, StackViewActivity.class, false);
                break;
            case R.string.viewStub:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.viewStub);
                IntentUtils.intent(context, bundle, ViewStubActivity.class, false);
                break;
            case R.string.viewAnimator:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.viewAnimator);
                IntentUtils.intent(context, bundle, ViewAnimatorActivity.class, false);
                break;
            case R.string.viewFlipper:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.viewFlipper);
                IntentUtils.intent(context, bundle, ViewFlipperActivity.class, false);
                break;
            case R.string.viewSwitcher:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.viewSwitcher);
                IntentUtils.intent(context, bundle, ViewSwitcherActivity.class, false);
                break;
            case R.string.adapterViewFlipper:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.adapterViewFlipper);
                IntentUtils.intent(context, bundle, AdapterViewFlipperActivity.class, false);
                break;
            case R.string.imageViewSwitcher:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.imageViewSwitcher);
                IntentUtils.intent(context, bundle, ImageSwitcherActivity.class, false);
                break;
            case R.string.textSwitcher:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.textSwitcher);
                IntentUtils.intent(context, bundle, TextSwitcherActivity.class, false);
                break;
            case R.string.viewPager:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.viewPager);
                IntentUtils.intent(context, bundle, ViewPagerActivity.class, false);
                break;
            default:
                break;
        }
    }
}
