package com.android.example.ui.view.data_time;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：
 * Created by Administrator on 2016/1/21 0021.
 */
public class ChronometerActivity extends BaseActivity implements View.OnClickListener, Chronometer.OnChronometerTickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private Chronometer chronometer;
    private Button btn_start;
    private Button btn_stop;
    private Button btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(this);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_reset.setOnClickListener(this);

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setOnChronometerTickListener(this);
        chronometer.setFormat("计时:%s");
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_start:
                chronometer.start();
                break;
            case R.id.btn_stop:
                chronometer.stop();
                break;
            case R.id.btn_reset:
                //复位计时器，停止计时
                chronometer.setBase(SystemClock.elapsedRealtime());
                break;
            default:
                break;
        }
    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {
        String time = chronometer.getText().toString();
        if ("计时:00:05".equals(time)) {
            Toast.makeText(ChronometerActivity.this, "五秒", Toast.LENGTH_SHORT).show();
        }
    }
}
