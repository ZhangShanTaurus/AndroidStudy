package com.android.example.helper.performance_helper.memory;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.performance.memory.image_handle.LoadLargeImageActivity;
import com.android.example.performance.memory.image_handle.fall_wall.FallWallActivity;
import com.android.example.performance.memory.image_handle.photo_wall.PhotoWallActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：OOMHelper
 * Created by Administrator on 2016/1/15 0015.
 */
public class ImageHandleHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.load_big_img:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.load_big_img);
                IntentUtils.intent(context, bundle, LoadLargeImageActivity.class, false);
                break;
            case R.string.photo_wall:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.photo_wall);
                IntentUtils.intent(context, bundle, PhotoWallActivity.class, false);
                break;
            case R.string.fall_wall:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.fall_wall);
                IntentUtils.intent(context, bundle, FallWallActivity.class, false);
                break;
            case R.string.multipoint_touch:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.multipoint_touch);
                IntentUtils.intent(context, bundle, FallWallActivity.class, false);
                break;
            default:
                break;
        }
    }
}
