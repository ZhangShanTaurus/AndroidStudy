package com.android.example.ui.view.widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：ToggleButtonActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ToggleButtonActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private ImageView iv_back;
    private TextView tv_title;
    private ToggleButton toggleButton_system;
    private ToggleButton toggleButton_custom;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        imageView = (ImageView) findViewById(R.id.imageView);
        toggleButton_system = (ToggleButton) findViewById(R.id.toggleButton_system);
        toggleButton_system.setOnCheckedChangeListener(this);
        toggleButton_custom = (ToggleButton) findViewById(R.id.toggleButton_custom);
        toggleButton_custom.setOnCheckedChangeListener(this);
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
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.toggleButton_system:
                imageView.setImageResource(b ? R.drawable.icon_qq_press : R.drawable.icon_qq);
                break;
            case R.id.toggleButton_custom:
                if (b) {
                    Toast.makeText(ToggleButtonActivity.this, "打开", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ToggleButtonActivity.this, "关闭", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }
}
