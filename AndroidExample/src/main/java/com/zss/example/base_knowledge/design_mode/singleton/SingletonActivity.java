package com.zss.example.base_knowledge.design_mode.singleton;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：SingletonActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class SingletonActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_mode_singleton_layout);
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
        //获取公司
        Company company = initCompany();
        textView.setText(company.showAllStaff());
    }

    /**
     * 初始化公司人员
     */
    public Company initCompany() {
        Company company = new Company();
        CEO ceo1 = CEO.getCEO();
        CEO ceo2 = CEO.getCEO();

        VP vp1 = new VP();
        VP vp2 = new VP();

        Staff staff1 = new Staff();
        Staff staff2 = new Staff();
        Staff staff3 = new Staff();

        company.addStaff(ceo1);
        company.addStaff(ceo2);
        company.addStaff(vp1);
        company.addStaff(vp2);
        company.addStaff(staff1);
        company.addStaff(staff2);
        company.addStaff(staff3);
        return company;
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
