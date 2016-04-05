package com.android.example.ui.view.container;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：SlidingDrawerActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class SlidingDrawerActivity extends BaseActivity implements SlidingDrawer.OnDrawerOpenListener, SlidingDrawer.OnDrawerCloseListener, SlidingDrawer.OnDrawerScrollListener {
    private ImageView iv_back;
    private TextView tv_title;
    private SlidingDrawer slidingDrawer_vertical;
    private SlidingDrawer slidingDrawer_horizontal;
    private Button open_vertical;
    private Button open_horizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_drawer_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tv_title = (TextView) findViewById(R.id.tv_title);
        open_vertical = (Button) findViewById(R.id.open_vertical);
        open_horizontal = (Button) findViewById(R.id.open_horizontal);

        slidingDrawer_vertical = (SlidingDrawer) findViewById(R.id.slidingDrawer_vertical);
        slidingDrawer_vertical.setOnDrawerOpenListener(this);
        slidingDrawer_vertical.setOnDrawerCloseListener(this);
        slidingDrawer_vertical.setOnDrawerScrollListener(this);
        slidingDrawer_horizontal = (SlidingDrawer) findViewById(R.id.slidingDrawer_horizontal);
        slidingDrawer_horizontal.setOnDrawerOpenListener(this);
        slidingDrawer_horizontal.setOnDrawerCloseListener(this);
        slidingDrawer_horizontal.setOnDrawerScrollListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    @Override
    public void onDrawerClosed() {
        //关闭
        open_vertical.setText("打开");
    }

    @Override
    public void onDrawerOpened() {
        //打开
        open_vertical.setText("关闭");
    }

    @Override
    public void onScrollEnded() {
        //开始拖动
        open_vertical.setText("开始拖动");
    }

    @Override
    public void onScrollStarted() {
        //结束拖动
        open_vertical.setText("结束拖动");
    }
}
