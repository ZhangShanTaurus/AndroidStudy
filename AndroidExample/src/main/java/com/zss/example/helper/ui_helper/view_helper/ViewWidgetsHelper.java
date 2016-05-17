package com.zss.example.helper.ui_helper.view_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.ui.view.widgets.ButtonActivity;
import com.zss.example.ui.view.widgets.CheckBoxActivity;
import com.zss.example.ui.view.widgets.ImageButtonActivity;
import com.zss.example.ui.view.widgets.ImageViewActivity;
import com.zss.example.ui.view.widgets.ProgressBarActivity;
import com.zss.example.ui.view.widgets.RadioButtonActivity;
import com.zss.example.ui.view.widgets.RatingBarActivity;
import com.zss.example.ui.view.widgets.SeekBarActivity;
import com.zss.example.ui.view.widgets.SpinnerActivity;
import com.zss.example.ui.view.widgets.SwitchActivity;
import com.zss.example.ui.view.widgets.TabLayoutActivity;
import com.zss.example.ui.view.widgets.TextViewActivity;
import com.zss.example.ui.view.widgets.ToggleButtonActivity;
import com.zss.example.ui.view.widgets.WebViewActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：View模块下Widgets帮助类
 * Created by Administrator on 2016/1/14 0014.
 */
public class ViewWidgetsHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.textView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.textView);
                IntentUtils.intent(context, bundle, TextViewActivity.class, false);
                break;
            case R.string.button:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.button);
                IntentUtils.intent(context, bundle, ButtonActivity.class, false);
                break;
            case R.string.radio_button:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.radio_button);
                IntentUtils.intent(context, bundle, RadioButtonActivity.class, false);
                break;
            case R.string.check_box:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.check_box);
                IntentUtils.intent(context, bundle, CheckBoxActivity.class, false);
                break;
            case R.string.switch1:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.switch1);
                IntentUtils.intent(context, bundle, SwitchActivity.class, false);
                break;
            case R.string.toggle_button:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.toggle_button);
                IntentUtils.intent(context, bundle, ToggleButtonActivity.class, false);
                break;
            case R.string.image_button:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.image_button);
                IntentUtils.intent(context, bundle, ImageButtonActivity.class, false);
                break;
            case R.string.image_view:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.image_view);
                IntentUtils.intent(context, bundle, ImageViewActivity.class, false);
                break;
            case R.string.progress_bar:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.progress_bar);
                IntentUtils.intent(context, bundle, ProgressBarActivity.class, false);
                break;
            case R.string.seek_bar:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.seek_bar);
                IntentUtils.intent(context, bundle, SeekBarActivity.class, false);
                break;
            case R.string.rating_bar:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.rating_bar);
                IntentUtils.intent(context, bundle, RatingBarActivity.class, false);
                break;
            case R.string.spinner:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.spinner);
                IntentUtils.intent(context, bundle, SpinnerActivity.class, false);
                break;
            case R.string.webView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.webView);
                IntentUtils.intent(context, bundle, WebViewActivity.class, false);
                break;
            case R.string.tabLayout:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.tabLayout);
                IntentUtils.intent(context, bundle, TabLayoutActivity.class, false);
                break;
            default:
                break;
        }
    }
}
