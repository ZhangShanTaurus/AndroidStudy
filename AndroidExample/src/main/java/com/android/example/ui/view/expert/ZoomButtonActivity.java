package com.android.example.ui.view.expert;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ZoomButton;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：ZoomButtonActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ZoomButtonActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private ZoomButton zoomButton_large;
    private ZoomButton zoomButton_small;
    private TextView tv_info;
    private static int fontSize = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_button_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_info.setTextSize(fontSize);
        zoomButton_large = (ZoomButton) findViewById(R.id.zoomButton_large);
        zoomButton_large.setOnClickListener(this);
        zoomButton_small = (ZoomButton) findViewById(R.id.zoomButton_small);
        zoomButton_small.setOnClickListener(this);
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
            case R.id.zoomButton_large:
                fontSize += 2;
                tv_info.setTextSize(fontSize);
                break;
            case R.id.zoomButton_small:
                fontSize -= 2;
                tv_info.setTextSize(fontSize);
                break;
            default:
                break;
        }
    }
}
