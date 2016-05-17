package com.zss.example.ui.view.expert;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：NumberPickerActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class NumberPickerActivity extends BaseActivity implements View.OnClickListener,
        NumberPicker.OnValueChangeListener, NumberPicker.OnScrollListener, NumberPicker.Formatter {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_info;
    private Button btn_theme1;
    private Button btn_theme2;
    private NumberPicker hourPicker;
    private NumberPicker minutePicker;

    private int hour = 9;
    private int minute = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置显示的主题
        setTheme(com.zss.example.R.style.Theme_NumberPicker);
        setContentView(com.zss.example.R.layout.activity_number_picker_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        tv_info = (TextView) findViewById(com.zss.example.R.id.tv_info);
        hourPicker = (NumberPicker) findViewById(com.zss.example.R.id.hourPicker);
        minutePicker = (NumberPicker) findViewById(com.zss.example.R.id.minutePicker);
        tv_info.setText(hour + "时" + minute + "分");
        btn_theme1 = (Button) findViewById(com.zss.example.R.id.btn_theme1);
        btn_theme1.setOnClickListener(this);
        btn_theme2 = (Button) findViewById(com.zss.example.R.id.btn_theme2);
        btn_theme2.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        hourPicker.setFormatter(this);
        hourPicker.setOnScrollListener(this);
        hourPicker.setOnValueChangedListener(this);
        hourPicker.setMaxValue(24);
        hourPicker.setMinValue(1);
        hourPicker.setValue(hour);

        minutePicker.setFormatter(this);
        minutePicker.setOnScrollListener(this);
        minutePicker.setOnValueChangedListener(this);
        minutePicker.setMaxValue(60);
        minutePicker.setMinValue(1);
        minutePicker.setValue(minute);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case com.zss.example.R.id.iv_back:
                onBackPressed();
                break;
            case com.zss.example.R.id.btn_theme1:
                setTheme(0);
                break;
            case com.zss.example.R.id.btn_theme2:
                setTheme(com.zss.example.R.style.Theme_NumberPicker);
                break;
            default:
                break;
        }
    }

    @Override
    public String format(int value) {
        String tmpStr = String.valueOf(value);
        if (value < 10) {
            tmpStr = "0" + tmpStr;
        }
        return tmpStr;
    }

    @Override
    public void onScrollStateChange(NumberPicker numberPicker, int scrollState) {
        switch (scrollState) {
            //手离开之后还在滑动
            case NumberPicker.OnScrollListener.SCROLL_STATE_FLING:
                tv_info.setText("持续滑动");
                break;
            //不滑动
            case NumberPicker.OnScrollListener.SCROLL_STATE_IDLE:
                tv_info.setText("停止滑动");
                break;
            //滑动中
            case NumberPicker.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                tv_info.setText("滑动中");
                break;
            default:
                break;
        }

    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
        switch (numberPicker.getId()) {
            case com.zss.example.R.id.hourPicker:
                hour = newValue;
                tv_info.setText(hour + "时" + minute + "分");
                break;
            case com.zss.example.R.id.minutePicker:
                minute = newValue;
                tv_info.setText(hour + "时" + minute + "分");
                break;
            default:
                break;
        }
    }
}
