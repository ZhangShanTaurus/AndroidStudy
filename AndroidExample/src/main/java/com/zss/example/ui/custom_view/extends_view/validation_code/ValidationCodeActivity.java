package com.zss.example.ui.custom_view.extends_view.validation_code;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：ValidationCodeActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ValidationCodeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private ValidationCodeView codeView;
    private Button btn_getCode;
    private Button btn_refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_code_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        codeView = (ValidationCodeView) findViewById(R.id.codeView);
        btn_getCode = (Button) findViewById(R.id.btn_getCode);
        btn_getCode.setOnClickListener(this);
        btn_refresh = (Button) findViewById(R.id.btn_refresh);
        btn_refresh.setOnClickListener(this);
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
            case R.id.btn_getCode:
                Toast.makeText(ValidationCodeActivity.this, codeView.getCodeString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_refresh:
                codeView.refresh();
                break;
            default:
                break;
        }
    }
}
