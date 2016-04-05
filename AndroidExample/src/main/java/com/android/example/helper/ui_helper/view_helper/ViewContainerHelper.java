package com.android.example.helper.ui_helper.view_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.ui.view.container.CardViewActivity;
import com.android.example.ui.view.container.DialerFilterActivity;
import com.android.example.ui.view.container.ExpandableListViewActivity;
import com.android.example.ui.view.container.GalleryActivity;
import com.android.example.ui.view.container.GridViewActivity;
import com.android.example.ui.view.container.ListViewActivity;
import com.android.example.ui.view.container.recycler_view.RecyclerViewActivity;
import com.android.example.ui.view.container.ScrollViewActivity;
import com.android.example.ui.view.container.SlidingDrawerActivity;
import com.android.example.ui.view.container.TabHostActivity;
import com.android.example.ui.view.container.VideoViewActivity;
import com.android.example.ui.view.widgets.RadioButtonActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：View模块下Container帮助类
 * Created by Administrator on 2016/1/14 0014.
 */
public class ViewContainerHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.radioGroup:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.radioGroup);
                IntentUtils.intent(context, bundle, RadioButtonActivity.class, false);
                break;
            case R.string.listView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.listView);
                IntentUtils.intent(context, bundle, ListViewActivity.class, false);
                break;
            case R.string.gridView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.gridView);
                IntentUtils.intent(context, bundle, GridViewActivity.class, false);
                break;
            case R.string.tabHost:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.tabHost);
                IntentUtils.intent(context, bundle, TabHostActivity.class, false);
                break;
            case R.string.expandableListView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.expandableListView);
                IntentUtils.intent(context, bundle, ExpandableListViewActivity.class, false);
                break;
            case R.string.scrollView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.scrollView);
                IntentUtils.intent(context, bundle, ScrollViewActivity.class, false);
                break;
            case R.string.slidingDrawer:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.slidingDrawer);
                IntentUtils.intent(context, bundle, SlidingDrawerActivity.class, false);
                break;
            case R.string.gallery:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.gallery);
                IntentUtils.intent(context, bundle, GalleryActivity.class, false);
                break;
            case R.string.videoView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.videoView);
                IntentUtils.intent(context, bundle, VideoViewActivity.class, false);
                break;
            case R.string.dialerFilter:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.dialerFilter);
                IntentUtils.intent(context, bundle, DialerFilterActivity.class, false);
                break;
            case R.string.recyclerView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.recyclerView);
                IntentUtils.intent(context, bundle, RecyclerViewActivity.class, false);
                break;
            case R.string.cardView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.cardView);
                IntentUtils.intent(context, bundle, CardViewActivity.class, false);
                break;
            default:
                break;
        }
    }
}
