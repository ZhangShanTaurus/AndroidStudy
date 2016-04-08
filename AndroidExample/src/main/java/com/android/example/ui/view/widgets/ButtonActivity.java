package com.android.example.ui.view.widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

import java.util.Calendar;

/**
 * 描述：ButtonActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ButtonActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void noDoubleClick(View view) {
                Toast.makeText(ButtonActivity.this, "点击啦", Toast.LENGTH_SHORT).show();
            }
        });
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

    public int add(int a) {
        return a + 5;
    }

    public int add(int a, int b) {
        return a + b;
    }

    /**
     * 重写父类方法
     */
    @Override
    public void fatherMethod() {
        super.fatherMethod();
    }

    /**
     * 防止多次点击监听器
     */
    private abstract class NoDoubleClickListener implements View.OnClickListener {
        private final int MIN_CLICK_DELAY_TIME = 4000;
        private long lastClickTime = 0;

        public abstract void noDoubleClick(View view);

        @Override
        public void onClick(View view) {
            long currentClickTime = Calendar.getInstance().getTimeInMillis();
            if ((currentClickTime - lastClickTime) > MIN_CLICK_DELAY_TIME) {
                lastClickTime = currentClickTime;
                noDoubleClick(view);
            }
        }
    }
}
