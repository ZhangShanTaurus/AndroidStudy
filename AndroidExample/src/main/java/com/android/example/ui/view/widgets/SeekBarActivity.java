package com.android.example.ui.view.widgets;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：SeekBarActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class SeekBarActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private SeekBar seekBar;
    private TextView tv_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_info.setMovementMethod(ScrollingMovementMethod.getInstance());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //触发操作，拖动
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_info.append("正在拖动:" + seekBar.getProgress() + "\n");
            }

            //进度条埃刚开始拖动
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tv_info.append("开始拖动:" + seekBar.getProgress() + "\n");
            }

            //停止拖动
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv_info.append("停止拖动:" + seekBar.getProgress() + "\n");
            }
        });
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    Message msg = Message.obtain();
                    msg.arg1 = i;
                    try {
                        Thread.sleep(1000);//休息一秒
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    handler.sendMessage(msg);
                }
            }
        }).start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            seekBar.setProgress(msg.arg1);
        }
    };
}
