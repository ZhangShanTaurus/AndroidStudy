package com.zss.example.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.zss.example.R;

/**
 * 描述：Intent工具类,跳转处理
 * Created by Administrator on 2016/1/12 0012.
 */
public class IntentUtils {

    /**
     * 跳转到指定页面，不finish当前页面
     */
    public static void intent(Context context, Class class1) {
        intent(context, class1, false);
    }

    /**
     * 不携带数据跳转到指定页面
     */
    public static void intent(Context context, Class class1, boolean isFinish) {
        intent(context, null, class1, isFinish);
    }

    /***
     * 携带数据跳转到指定页面
     */
    public static void intent(Context context, Bundle bundle, Class class1, boolean isFinish) {
        Intent intent = new Intent(context, class1);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
        if (isFinish) {
            //从栈中移除该activity
        }
        pushFromRight((Activity) context);
    }

    /**
     * 界面前进动画：从右进入
     */
    public static void pushFromRight(Activity activity) {
        activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    /**
     * 界面返回动画效果
     */
    public static void popFromLeft(Activity activity) {
        activity.overridePendingTransition(R.anim.pop_right_out, R.anim.pop_right_in);
    }
}
