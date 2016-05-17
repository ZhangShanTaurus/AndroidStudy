package com.zss.example.base_knowledge.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.R;
import com.zss.example.base_knowledge.fragment.sample.FragmentOne1;
import com.zss.example.base_knowledge.fragment.sample.FragmentThree1;
import com.zss.example.base_knowledge.fragment.sample.FragmentTwo1;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：FragmentCommunicationToActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class FragmentCommunicationToActivity extends BaseActivity implements View.OnClickListener,
        FragmentOne1.FOneBtnClickListener, FragmentTwo1.FTwoBtnClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private FragmentOne1 fragmentOne1;
    private FragmentTwo1 fragmentTwo1;
    private FragmentThree1 fragmentThree1;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_fragment_stack_layout);
        initView();
        initData();
        fm = getFragmentManager();
        if (savedInstanceState == null) {
            fragmentOne1 = new FragmentOne1();
            FragmentTransaction tx = fm.beginTransaction();
            tx.add(R.id.frameLayout_content, fragmentOne1, "ONE");
            tx.commit();
        }
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

    /**
     * FragmentOne1按钮点击的回调
     */
    @Override
    public void onFOneClick() {
        Toast.makeText(FragmentCommunicationToActivity.this, "Activity---onFOneClick()", Toast.LENGTH_SHORT).show();
        if (fragmentTwo1 == null) {
            fragmentTwo1 = new FragmentTwo1();
            fragmentTwo1.setListener(this);
        }
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(R.id.frameLayout_content, fragmentTwo1, "TWO");
        tx.addToBackStack(null);
        tx.commit();
    }

    @Override
    public void onFTwoClick() {
        Toast.makeText(FragmentCommunicationToActivity.this, "Activity---onFTwoClick()", Toast.LENGTH_SHORT).show();
        if (fragmentThree1 == null) {
            fragmentThree1 = new FragmentThree1();

        }
        FragmentTransaction tx = fm.beginTransaction();
        tx.hide(fragmentTwo1);
        tx.add(R.id.frameLayout_content, fragmentThree1, "THREE");
        // tx.replace(R.id.id_content, fThree, "THREE");
        tx.addToBackStack(null);
        tx.commit();
    }
}
