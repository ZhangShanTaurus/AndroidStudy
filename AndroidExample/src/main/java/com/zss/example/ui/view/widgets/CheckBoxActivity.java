package com.zss.example.ui.view.widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：CheckBoxActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class CheckBoxActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_ok;
    private CheckBox checkbox_isMarry;
    private CheckBox checkbox_isBaby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_checkbox_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        btn_ok = (Button) findViewById(com.zss.example.R.id.btn_ok);
        btn_ok.setOnClickListener(this);
        checkbox_isMarry = (CheckBox) findViewById(com.zss.example.R.id.checkbox_isMarry);
        checkbox_isMarry.setOnCheckedChangeListener(this);
        checkbox_isBaby = (CheckBox) findViewById(com.zss.example.R.id.checkbox_isBaby);
        checkbox_isBaby.setOnCheckedChangeListener(this);
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
            case com.zss.example.R.id.iv_back:
                onBackPressed();
                break;
            case com.zss.example.R.id.btn_ok:
                submit();
                break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case com.zss.example.R.id.checkbox_isMarry:
                Toast.makeText(this, b ? "选中已婚" : "取消已婚", Toast.LENGTH_LONG).show();
                break;
            case com.zss.example.R.id.checkbox_isBaby:
                Toast.makeText(this, b ? "选中已育" : "取消已育", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }

    public void submit() {
        StringBuffer stringBuffer = new StringBuffer("你选择了:");
        if (checkbox_isMarry.isChecked()) {
            stringBuffer.append("已婚");
        }
        if (checkbox_isBaby.isChecked()) {
            stringBuffer.append("、已育");
        }
        Toast.makeText(this, stringBuffer, Toast.LENGTH_LONG).show();
    }
}
