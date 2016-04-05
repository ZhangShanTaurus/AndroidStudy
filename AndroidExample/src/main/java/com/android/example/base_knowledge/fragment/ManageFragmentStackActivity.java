package com.android.example.base_knowledge.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.base_knowledge.fragment.sample.FragmentOne;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：ManageFragmentStackActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ManageFragmentStackActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_fragment_stack_layout);
        initView();
        initData();
        setFragment();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 设置显示的Fragment
     */
    public void setFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout_content, new FragmentOne(), "one");
        fragmentTransaction.commit();
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
