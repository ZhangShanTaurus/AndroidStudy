package com.android.example.base_knowledge.activity.lunch_mode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：LunchModeTransferActivity:过渡使用
 * Created by Administrator on 2016/1/21 0021.
 */
public class LunchModeTransferActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_to_task;
    private Button btn_to_instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_mode_transfer_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_to_task = (Button) findViewById(R.id.btn_to_task);
        btn_to_task.setOnClickListener(this);
        btn_to_instance = (Button) findViewById(R.id.btn_to_instance);
        btn_to_instance.setOnClickListener(this);
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
            case R.id.btn_to_task:
                Bundle bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.activity_lunchMode_singleTask);
                bundle.putString("info", "从Transfer传递过来的信息");
                IntentUtils.intent(LunchModeTransferActivity.this, bundle, LunchModeSingleTaskActivity.class, false);
                break;
            case R.id.btn_to_instance:
                Bundle bundle2 = new Bundle();
                bundle2.putInt(Constance.TITLE, R.string.activity_lunchMode_singleInstance);
                bundle2.putString("info", "从Transfer传递过来的信息");
                IntentUtils.intent(LunchModeTransferActivity.this, bundle2, LunchModeSingleInstanceActivity.class, false);
                break;
            default:
                break;
        }
    }
}
