package com.zss.example.base_knowledge.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.R;
import com.zss.example.base_knowledge.fragment.sample.DialogFragmentEditName;
import com.zss.example.base_knowledge.fragment.sample.DialogFragmentLogin;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：FragmentDialogActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class FragmentDialogActivity extends BaseActivity implements View.OnClickListener, DialogFragmentLogin.LoginInputListener {

    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_edit_name_dialog;
    private Button btn_login_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dialog_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_edit_name_dialog = (Button) findViewById(R.id.btn_edit_name_dialog);
        btn_edit_name_dialog.setOnClickListener(this);
        btn_login_dialog = (Button) findViewById(R.id.btn_login_dialog);
        btn_login_dialog.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 弹出修改姓名dialog
     */
    public void showEditNameDialog(View view) {
        DialogFragmentEditName dialogFragmentEditName = new DialogFragmentEditName();
        dialogFragmentEditName.show(getFragmentManager(), "DialogFragmentEditName");
    }

    /**
     * 弹出登录dialog
     */
    public void showLoginDialog(View view) {
        DialogFragmentLogin dialogFragmentLogin = new DialogFragmentLogin();
        dialogFragmentLogin.show(getFragmentManager(), "DialogFragmentLogin");
    }

    @Override
    public void onLoginInputComplete(String username, String password) {
        Toast.makeText(FragmentDialogActivity.this, "Activity----姓名:" + username + "--密码:" + password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_edit_name_dialog:
                showEditNameDialog(null);
                break;
            case R.id.btn_login_dialog:
                showLoginDialog(null);
                break;
            default:
                break;
        }
    }
}
