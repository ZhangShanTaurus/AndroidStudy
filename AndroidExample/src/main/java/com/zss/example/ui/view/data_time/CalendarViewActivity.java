package com.zss.example.ui.view.data_time;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

import java.text.SimpleDateFormat;

/**
 * 描述：CalendarViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class CalendarViewActivity extends BaseActivity implements CalendarView.OnDateChangeListener {

    private ImageView iv_back;
    private TextView tv_title;
    private CalendarView calendarView;
    private SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tv_title = (TextView) findViewById(R.id.tv_title);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        long nowTime = calendarView.getDate();
        simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日hh:mm:ss");
        String time = simpleDateFormat.format(nowTime);
        Toast.makeText(CalendarViewActivity.this, time, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
        int myMonth = month + 1;
        Toast.makeText(CalendarViewActivity.this, year + "-" + myMonth + "-" + day, Toast.LENGTH_SHORT).show();
    }
}
