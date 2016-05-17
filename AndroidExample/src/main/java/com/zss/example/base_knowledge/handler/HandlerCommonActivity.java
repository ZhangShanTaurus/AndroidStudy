package com.zss.example.base_knowledge.handler;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：HandlerCommonActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class HandlerCommonActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_info;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_handler_common_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        tv_info = (TextView) findViewById(com.zss.example.R.id.tv_info);
        imageView = (ImageView) findViewById(com.zss.example.R.id.imageView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            int title = getIntent().getExtras().getInt(Constance.TITLE);
            tv_title.setText(title);
            switch (title) {
                case com.zss.example.R.string.handler_base_info:
                    tv_info.setText(com.zss.example.R.string.handler_info);
                    break;
                case com.zss.example.R.string.looper_base_info:
                    tv_info.setText(com.zss.example.R.string.looper_info);
                    break;
                case com.zss.example.R.string.message_base_info:
                    tv_info.setText(com.zss.example.R.string.message_info);
                    break;
                case com.zss.example.R.string.message_queue_info:
                    tv_info.setText(com.zss.example.R.string.message_queue_info_info);
                    break;
                case com.zss.example.R.string.handler_summary:
                    imageView.setVisibility(View.VISIBLE);
                    tv_info.setText(com.zss.example.R.string.handler_summary_info);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case com.zss.example.R.id.iv_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}
