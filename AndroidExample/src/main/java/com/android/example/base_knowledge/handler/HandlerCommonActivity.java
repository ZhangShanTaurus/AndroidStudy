package com.android.example.base_knowledge.handler;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

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
        setContentView(R.layout.activity_handler_common_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_info = (TextView) findViewById(R.id.tv_info);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            int title = getIntent().getExtras().getInt(Constance.TITLE);
            tv_title.setText(title);
            switch (title) {
                case R.string.handler_base_info:
                    tv_info.setText(R.string.handler_info);
                    break;
                case R.string.looper_base_info:
                    tv_info.setText(R.string.looper_info);
                    break;
                case R.string.message_base_info:
                    tv_info.setText(R.string.message_info);
                    break;
                case R.string.message_queue_info:
                    tv_info.setText(R.string.message_queue_info_info);
                    break;
                case R.string.handler_summary:
                    imageView.setVisibility(View.VISIBLE);
                    tv_info.setText(R.string.handler_summary_info);
                    break;
                default:
                    break;
            }
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
}
