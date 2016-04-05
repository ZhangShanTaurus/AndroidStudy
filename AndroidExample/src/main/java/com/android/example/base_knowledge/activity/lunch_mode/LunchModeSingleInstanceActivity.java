package com.android.example.base_knowledge.activity.lunch_mode;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：LunchModeSingleInstanceActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class LunchModeSingleInstanceActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_start;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_mode_single_instance_layout);
        Toast.makeText(this, "SingleInstanceActivity--onCreate()", Toast.LENGTH_SHORT).show();
        initView();
        initData();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this, "SingleInstanceActivity--onNewIntent()", Toast.LENGTH_SHORT).show();
        setIntent(intent);
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
            if (!TextUtils.isEmpty(getIntent().getExtras().getString("info"))) {
                textView.setVisibility(View.VISIBLE);
                textView.setText(getIntent().getExtras().getString("info"));
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_start:
                Bundle bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.activity_lunchMode_transfer);
                IntentUtils.intent(LunchModeSingleInstanceActivity.this, bundle, LunchModeTransferActivity.class, false);
                break;
            default:
                break;
        }
    }
}
