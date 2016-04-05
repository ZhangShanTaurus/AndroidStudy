package com.android.example.base_knowledge.activity.lunch_mode;

import android.content.Intent;
import android.os.Bundle;
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
 * 描述：LunchModeStandardActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class LunchModeStandardActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_mode_standard_layout);
        Toast.makeText(this, "StandardActivity---onCreate()", Toast.LENGTH_SHORT).show();
        initView();
        initData();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this, "StandardActivity---onNewIntent()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE)+"");
        }
    }

    private static int count = 0;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_start:
                Bundle bundle = new Bundle();
                bundle.putInt(Constance.TITLE, count);
                IntentUtils.intent(LunchModeStandardActivity.this, bundle, LunchModeStandardActivity.class, false);
                count++;
                break;
            default:
                break;
        }
    }
}
