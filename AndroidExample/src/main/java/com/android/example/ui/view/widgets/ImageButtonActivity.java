package com.android.example.ui.view.widgets;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：ImageButtonActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ImageButtonActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private ImageView imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    //设置按下的图片
                    ((ImageButton) view).setImageDrawable(getResources().getDrawable(R.drawable.icon_qqzone_press));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    //设置抬起时图片
                    ((ImageButton) view).setImageDrawable(getResources().getDrawable(R.drawable.icon_qqzone));
                }
                return false;
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
}
