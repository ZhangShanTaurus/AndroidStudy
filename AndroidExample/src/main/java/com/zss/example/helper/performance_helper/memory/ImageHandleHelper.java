package com.zss.example.helper.performance_helper.memory;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.common.Constance;
import com.zss.example.performance.memory.image_handle.LoadLargeImageActivity;
import com.zss.example.performance.memory.image_handle.fall_wall.FallWallActivity;
import com.zss.example.performance.memory.image_handle.load_large_img.LoadLargeImage2Activity;
import com.zss.example.performance.memory.image_handle.photo_wall.PhotoWallActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：OOMHelper
 * Created by Administrator on 2016/1/15 0015.
 */
public class ImageHandleHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case com.zss.example.R.string.load_big_img:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.load_big_img);
                IntentUtils.intent(context, bundle, LoadLargeImageActivity.class, false);
                break;
            case com.zss.example.R.string.load_big_img2:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.load_big_img2);
                IntentUtils.intent(context, bundle, LoadLargeImage2Activity.class, false);
                break;
            case com.zss.example.R.string.photo_wall:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.photo_wall);
                IntentUtils.intent(context, bundle, PhotoWallActivity.class, false);
                break;
            case com.zss.example.R.string.fall_wall:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.fall_wall);
                IntentUtils.intent(context, bundle, FallWallActivity.class, false);
                break;
            case com.zss.example.R.string.multipoint_touch:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.multipoint_touch);
                IntentUtils.intent(context, bundle, FallWallActivity.class, false);
                break;
            default:
                break;
        }
    }
}
