package com.zss.example.ui.view.expert;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：ViewStubActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ViewStubActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private ViewStub viewStub;
    private TextView tv_view_stub;
    private Button btn_load;
    private Button btn_unload;
    private boolean isLoad = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stub_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_load = (Button) findViewById(R.id.btn_load);
        btn_load.setOnClickListener(this);
        btn_unload = (Button) findViewById(R.id.btn_unload);
        btn_unload.setOnClickListener(this);
        viewStub = (ViewStub) findViewById(R.id.viewStub);
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
            case R.id.btn_load:
                if (!isLoad) {
                    isLoad = true;
                    View view1 = viewStub.inflate();
                    tv_view_stub = (TextView) view1.findViewById(R.id.tv_view_stub);
                    tv_view_stub.setText("time" + System.currentTimeMillis());
                    //加载完成之后，ViewStub的id不可用，要用inflatedId
                    View view2 = findViewById(R.id.viewStub);

                    View view3 = findViewById(R.id.viewStub_after_load);
                }
                break;
            case R.id.btn_unload:
                if (isLoad) {
                    viewStub.setVisibility(View.GONE);
                }
                break;
            default:
                break;
        }
    }
}
