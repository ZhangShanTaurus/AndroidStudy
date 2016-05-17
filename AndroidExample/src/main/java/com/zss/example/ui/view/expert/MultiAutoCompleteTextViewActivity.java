package com.zss.example.ui.view.expert;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：MultiAutoCompleteTextViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class MultiAutoCompleteTextViewActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private MultiAutoCompleteTextView multiAutoCompleteTextView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_multi_auto_complete_textview_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(com.zss.example.R.id.multiAutoCompleteTextView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        //输入第几个数开始提示
        multiAutoCompleteTextView.setThreshold(1);
        String items[] = {"abc", "abb", "aaa", "acb", "acc"};
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);
        multiAutoCompleteTextView.setAdapter(adapter);
        //设置分隔符类CommaTokenizer
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
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
