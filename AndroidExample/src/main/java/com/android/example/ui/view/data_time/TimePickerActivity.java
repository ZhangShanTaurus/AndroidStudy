package com.android.example.ui.view.data_time;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

import java.util.Calendar;

/**
 * 描述：TimePickerActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class TimePickerActivity extends BaseActivity implements View.OnClickListener, TimePicker.OnTimeChangedListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TimePicker timePicker;
    private Button btn_show_dialog;
    private TextView tv_showTime;
    private TextView tv_showTime2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_show_dialog = (Button) findViewById(R.id.btn_show_dialog);
        btn_show_dialog.setOnClickListener(this);
        tv_showTime = (TextView) findViewById(R.id.tv_showTime);
        tv_showTime2 = (TextView) findViewById(R.id.tv_showTime2);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(this);
        timePicker.setIs24HourView(false);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();
        tv_showTime.setText("Time:" + hour + ":" + minute);
        tv_showTime2.setText("Time:");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_show_dialog:
                showDialog();
                break;
            default:
                break;
        }
    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
        tv_showTime.setText("Time:" + hour + ":" + minute);
    }

    public void showDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        final TimePickerDialog dialog = new TimePickerDialog(this, AlertDialog.THEME_HOLO_LIGHT, listener, hour, minute, true);
        dialog.show();
    }

    private TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            tv_showTime2.setText("Time:" + hour + ":" + minute);
        }
    };
}
