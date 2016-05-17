package com.zss.example.ui.view.container;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：TabHostActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class TabHostActivity extends BaseActivity implements View.OnClickListener, TabHost.OnTabChangeListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TabHost tabHost;
    private Button btn_tab1, btn_tab2;
    private final String TAG1 = "tag1";
    private final String TAG2 = "tag2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_tabhost_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        tabHost = (TabHost) findViewById(com.zss.example.R.id.tabHost);
        //初始化TabHost容器
        tabHost.setup();
        //动态加载xml
        LayoutInflater inflater = LayoutInflater.from(this);
        View view1 = inflater.inflate(com.zss.example.R.layout.tabhost_tab1_layout, tabHost.getTabContentView());
        View view2 = inflater.inflate(com.zss.example.R.layout.tabhost_tab2_layout, tabHost.getTabContentView());
        btn_tab1 = (Button) view1.findViewById(com.zss.example.R.id.btn_tab1);
        btn_tab1.setOnClickListener(this);
        btn_tab2 = (Button) view2.findViewById(com.zss.example.R.id.btn_tab2);
        btn_tab2.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        tabHost.setOnTabChangedListener(this);
        tabHost.addTab(tabHost.newTabSpec("标签一").setIndicator(TAG1).setContent(com.zss.example.R.id.tabHost_tab1));
        tabHost.addTab(tabHost.newTabSpec("标签二").setIndicator(TAG2).setContent(com.zss.example.R.id.tabHost_tab2));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case com.zss.example.R.id.iv_back:
                onBackPressed();
                break;
            case com.zss.example.R.id.btn_tab1:
                Toast.makeText(this, "Tab1", Toast.LENGTH_SHORT).show();
                break;
            case com.zss.example.R.id.btn_tab2:
                Toast.makeText(this, "Tab2", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabChanged(String s) {
        Toast.makeText(this, "切换到" + s, Toast.LENGTH_SHORT).show();
    }
}
