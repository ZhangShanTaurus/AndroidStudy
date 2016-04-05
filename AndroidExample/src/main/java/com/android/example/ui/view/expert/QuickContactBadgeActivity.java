package com.android.example.ui.view.expert;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：QuickContactBadgeActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class QuickContactBadgeActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private QuickContactBadge quickContactBadge_phone;
    private QuickContactBadge quickContactBadge_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_contact_badge_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        quickContactBadge_phone = (QuickContactBadge) findViewById(R.id.quickContactBadge_phone);
        quickContactBadge_phone.assignContactFromPhone("1000000", false);

        quickContactBadge_email = (QuickContactBadge) findViewById(R.id.quickContactBadge_email);
        quickContactBadge_email.assignContactFromPhone("931368113@qq.com", true);
        quickContactBadge_email.setMode(ContactsContract.QuickContact.MODE_LARGE);
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
