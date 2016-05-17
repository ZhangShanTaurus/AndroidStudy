package com.zss.example.helper.ui_helper.view_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.common.Constance;
import com.zss.example.ui.view.container.CardViewActivity;
import com.zss.example.ui.view.container.DialerFilterActivity;
import com.zss.example.ui.view.container.ExpandableListViewActivity;
import com.zss.example.ui.view.container.GalleryActivity;
import com.zss.example.ui.view.container.GridViewActivity;
import com.zss.example.ui.view.container.ListViewActivity;
import com.zss.example.ui.view.container.recycler_view.RecyclerViewActivity;
import com.zss.example.ui.view.container.ScrollViewActivity;
import com.zss.example.ui.view.container.SlidingDrawerActivity;
import com.zss.example.ui.view.container.TabHostActivity;
import com.zss.example.ui.view.container.VideoViewActivity;
import com.zss.example.ui.view.widgets.RadioButtonActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：View模块下Container帮助类
 * Created by Administrator on 2016/1/14 0014.
 */
public class ViewContainerHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case com.zss.example.R.string.radioGroup:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.radioGroup);
                IntentUtils.intent(context, bundle, RadioButtonActivity.class, false);
                break;
            case com.zss.example.R.string.listView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.listView);
                IntentUtils.intent(context, bundle, ListViewActivity.class, false);
                break;
            case com.zss.example.R.string.gridView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.gridView);
                IntentUtils.intent(context, bundle, GridViewActivity.class, false);
                break;
            case com.zss.example.R.string.tabHost:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.tabHost);
                IntentUtils.intent(context, bundle, TabHostActivity.class, false);
                break;
            case com.zss.example.R.string.expandableListView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.expandableListView);
                IntentUtils.intent(context, bundle, ExpandableListViewActivity.class, false);
                break;
            case com.zss.example.R.string.scrollView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.scrollView);
                IntentUtils.intent(context, bundle, ScrollViewActivity.class, false);
                break;
            case com.zss.example.R.string.slidingDrawer:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.slidingDrawer);
                IntentUtils.intent(context, bundle, SlidingDrawerActivity.class, false);
                break;
            case com.zss.example.R.string.gallery:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.gallery);
                IntentUtils.intent(context, bundle, GalleryActivity.class, false);
                break;
            case com.zss.example.R.string.videoView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.videoView);
                IntentUtils.intent(context, bundle, VideoViewActivity.class, false);
                break;
            case com.zss.example.R.string.dialerFilter:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.dialerFilter);
                IntentUtils.intent(context, bundle, DialerFilterActivity.class, false);
                break;
            case com.zss.example.R.string.recyclerView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.recyclerView);
                IntentUtils.intent(context, bundle, RecyclerViewActivity.class, false);
                break;
            case com.zss.example.R.string.cardView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.cardView);
                IntentUtils.intent(context, bundle, CardViewActivity.class, false);
                break;
            default:
                break;
        }
    }
}
