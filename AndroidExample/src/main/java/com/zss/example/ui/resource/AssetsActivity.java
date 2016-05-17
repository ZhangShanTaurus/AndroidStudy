package com.zss.example.ui.resource;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 描述：AssetsActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AssetsActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assets_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        textView.setText(getFromAssets("hello_world.txt"));
    }

    /**
     * 从Assets文件夹下获取数据
     */
    public String getFromAssets(String fileName) {
        String result = "";
        try {
            InputStreamReader inputReader = new InputStreamReader(getResources().getAssets().open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line;
            while ((line = bufReader.readLine()) != null) {
                result += line;
            }
            inputReader.close();
            //注释的话会崩溃
//            getResources().getAssets().close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
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
