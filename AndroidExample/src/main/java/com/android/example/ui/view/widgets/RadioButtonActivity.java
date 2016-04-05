package com.android.example.ui.view.widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：RadioButtonActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class RadioButtonActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private ImageView iv_back;
    private TextView tv_title;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
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
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radioButton_beijing:
                Toast.makeText(this, i + "-北京", Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButton_tianjin:
                Toast.makeText(this, i + "-天津", Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButton_shanghaig:
                Toast.makeText(this, i + "-上海", Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButton_chongqing:
                Toast.makeText(this, i + "-重庆", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }

    }
}
