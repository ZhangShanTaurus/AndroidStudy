package com.zss.example.base_knowledge.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.base_knowledge.fragment.sample.FragmentContacts;
import com.zss.example.base_knowledge.fragment.sample.FragmentFriend;
import com.zss.example.base_knowledge.fragment.sample.FragmentMessage;
import com.zss.example.base_knowledge.fragment.sample.FragmentSpace;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：FragmentDynamicAddActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class FragmentDynamicAddActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_message;
    private Button btn_friend;
    private Button btn_contacts;
    private Button btn_space;

    private FragmentMessage fragmentMessage;
    private FragmentFriend fragmentFriend;
    private FragmentContacts fragmentContacts;
    private FragmentSpace fragmentSpace;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_fragment_dynamic_add_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        btn_message = (Button) findViewById(com.zss.example.R.id.btn_message);
        btn_message.setOnClickListener(this);
        btn_friend = (Button) findViewById(com.zss.example.R.id.btn_friend);
        btn_friend.setOnClickListener(this);
        btn_contacts = (Button) findViewById(com.zss.example.R.id.btn_contacts);
        btn_contacts.setOnClickListener(this);
        btn_space = (Button) findViewById(com.zss.example.R.id.btn_space);
        btn_space.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        fragmentManager = getFragmentManager();
        setFragment(0);
    }

    /**
     * 设置默认的Fragment
     */
    public void setFragment(int i) {
        //每次选中之前清除掉上次选中状态
        clearSelection();
        //开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //隐藏所有Fragment，以防多个Fragment出现在界面上
        hideFragment(transaction);
        switch (i) {
            case 0:
                //transaction.replace(R.id.frameLayout_content, fragmentMessage);
                btn_message.setTextColor(getResources().getColor(com.zss.example.R.color.Red));
                if (fragmentMessage == null) {
                    fragmentMessage = new FragmentMessage();
                    // 如果fragmentMessage为空，则创建一个并添加到界面上
                    transaction.add(com.zss.example.R.id.frameLayout_content, fragmentMessage);
                } else {
                    // 如果fragmentMessage不为空，则直接将它显示出来
                    transaction.show(fragmentMessage);
                }
                break;
            case 1:
                //transaction.replace(R.id.frameLayout_content, fragmentFriend);
                btn_friend.setTextColor(getResources().getColor(com.zss.example.R.color.Red));
                if (fragmentFriend == null) {
                    fragmentFriend = new FragmentFriend();
                    transaction.add(com.zss.example.R.id.frameLayout_content, fragmentFriend);
                } else {
                    transaction.show(fragmentFriend);
                }
                break;
            case 2:
                //transaction.replace(R.id.frameLayout_content, fragmentContacts);
                btn_contacts.setTextColor(getResources().getColor(com.zss.example.R.color.Red));
                if (fragmentContacts == null) {
                    fragmentContacts = new FragmentContacts();
                    transaction.add(com.zss.example.R.id.frameLayout_content, fragmentContacts);
                } else {
                    transaction.show(fragmentContacts);
                }
                break;
            case 3:
                //transaction.replace(R.id.frameLayout_content, fragmentSpace);
                btn_space.setTextColor(getResources().getColor(com.zss.example.R.color.Red));
                if (fragmentSpace == null) {
                    fragmentSpace = new FragmentSpace();
                    transaction.add(com.zss.example.R.id.frameLayout_content, fragmentSpace);
                } else {
                    transaction.show(fragmentSpace);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case com.zss.example.R.id.iv_back:
                onBackPressed();
                break;
            case com.zss.example.R.id.btn_message:
                setFragment(0);
                break;
            case com.zss.example.R.id.btn_friend:
                setFragment(1);
                break;
            case com.zss.example.R.id.btn_contacts:
                setFragment(2);
                break;
            case com.zss.example.R.id.btn_space:
                setFragment(3);
                break;
            default:
                break;
        }
    }

    /**
     * 清除掉所有选中状态
     */
    public void clearSelection() {
        btn_message.setTextColor(getResources().getColor(com.zss.example.R.color.Black));
        btn_friend.setTextColor(getResources().getColor(com.zss.example.R.color.Black));
        btn_contacts.setTextColor(getResources().getColor(com.zss.example.R.color.Black));
        btn_space.setTextColor(getResources().getColor(com.zss.example.R.color.Black));
    }

    /**
     * 将所有Fragment隐藏起来
     */
    public void hideFragment(FragmentTransaction fragmentTransaction) {
        if (fragmentMessage != null) {
            fragmentTransaction.hide(fragmentMessage);
        }
        if (fragmentFriend != null) {
            fragmentTransaction.hide(fragmentFriend);
        }
        if (fragmentContacts != null) {
            fragmentTransaction.hide(fragmentContacts);
        }
        if (fragmentSpace != null) {
            fragmentTransaction.hide(fragmentSpace);
        }
    }
}
