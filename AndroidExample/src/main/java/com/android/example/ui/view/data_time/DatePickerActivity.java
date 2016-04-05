package com.android.example.ui.view.data_time;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 描述：DatePickerActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class DatePickerActivity extends BaseActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, DatePicker.OnDateChangedListener {

    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_datePicker;
    private TextView tv_datePickerDialog;
    private Button btn_show_dialog;
    private DatePicker datePicker;

    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_picker_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_datePicker = (TextView) findViewById(R.id.tv_datePicker);
        tv_datePickerDialog = (TextView) findViewById(R.id.tv_datePickerDialog);
        btn_show_dialog = (Button) findViewById(R.id.btn_show_dialog);
        btn_show_dialog.setOnClickListener(this);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        //初始化Calendar日历对象
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        Date date = new Date();//获取当前日期Date对象
        calendar.setTime(date);//为Calendar设置时间为当前日期

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        int trueMonth = month + 1;
        datePicker.init(year, trueMonth, day, this);
        tv_datePicker.setText("Time:" + year + "-" + trueMonth + "-" + day);
        tv_datePickerDialog.setText("Time:" + year + "-" + trueMonth + "-" + day);
    }

    public void showDialog() {
        //创建DatePickerDialog对象,第二个参数为Theme，可以不指定，使用默认的
        DatePickerDialog dialog = new DatePickerDialog(this, AlertDialog.THEME_HOLO_LIGHT, this, year, month, day);
        //显示DatePickerDialog组件
        dialog.show();
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
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        int trueMonth = month + 1;
        tv_datePickerDialog.setText("Time:" + year + "-" + trueMonth + "-" + day);
    }

    @Override
    public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
        int trueMonth = month + 1;
        tv_datePicker.setText("Time:" + year + "-" + trueMonth + "-" + day);
    }
}
