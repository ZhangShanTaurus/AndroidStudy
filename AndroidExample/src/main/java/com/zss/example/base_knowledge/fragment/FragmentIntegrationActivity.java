package com.zss.example.base_knowledge.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.base_knowledge.fragment.sample.FragmentIntegration;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：FragmentIntegrationActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class FragmentIntegrationActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_fragment_integration_layout);
        initView();
        initData();
        //防止多次创建Fragment实例
        if (savedInstanceState == null) {
            FragmentIntegration fragmentIntegration = new FragmentIntegration();
            fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(com.zss.example.R.id.frameLayout_content, fragmentIntegration, "fragmentIntegration");
            fragmentTransaction.commit();
        }
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
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
            case com.zss.example.R.id.iv_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.fragment_menu_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case com.zss.example.R.id.menu_about:
                Toast.makeText(FragmentIntegrationActivity.this, "Activity中处理事件---关于", Toast.LENGTH_SHORT).show();
                return true;
            case com.zss.example.R.id.menu_quit:
                Toast.makeText(FragmentIntegrationActivity.this, "Activity中处理事件---退出", Toast.LENGTH_SHORT).show();
                return true;
            default:
                //如果希望Fragment自己处理MenuItem点击事件,一定不要忘了:super.onOptionsItemSelected();
                return super.onOptionsItemSelected(item);
        }
    }
}
