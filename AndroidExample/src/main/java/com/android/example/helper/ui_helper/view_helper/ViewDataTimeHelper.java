package com.android.example.helper.ui_helper.view_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.ui.view.data_time.AnalogClockActivity;
import com.android.example.ui.view.data_time.CalendarViewActivity;
import com.android.example.ui.view.data_time.ChronometerActivity;
import com.android.example.ui.view.data_time.DatePickerActivity;
import com.android.example.ui.view.data_time.TextClockActivity;
import com.android.example.ui.view.data_time.TimePickerActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：View模块下DataTime帮助类
 * Created by Administrator on 2016/1/14 0014.
 */
public class ViewDataTimeHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle;
        switch (index) {
            case R.string.textClock:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.textClock);
                IntentUtils.intent(context, bundle, TextClockActivity.class, false);
                break;
            case R.string.analogClock:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.analogClock);
                IntentUtils.intent(context, bundle, AnalogClockActivity.class, false);
                break;
            case R.string.chronometer:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.chronometer);
                IntentUtils.intent(context, bundle, ChronometerActivity.class, false);
                break;
            case R.string.datePicker:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.datePicker);
                IntentUtils.intent(context, bundle, DatePickerActivity.class, false);
                break;
            case R.string.timePicker:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.timePicker);
                IntentUtils.intent(context, bundle, TimePickerActivity.class, false);
                break;
            case R.string.calendarView:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.calendarView);
                IntentUtils.intent(context, bundle, CalendarViewActivity.class, false);
                break;
            default:
                break;
        }
    }
}
