package com.android.example.ui.view.widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：SpinnerActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class SpinnerActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private ImageView iv_back;
    private TextView tv_title;
    private Spinner spinner_data_xml;
    private Spinner spinner_data_java;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        spinner_data_xml = (Spinner) findViewById(R.id.spinner_data_xml);
        spinner_data_xml.setOnItemSelectedListener(this);
        spinner_data_java = (Spinner) findViewById(R.id.spinner_data_java);
        spinner_data_java.setOnItemSelectedListener(this);
    }

    String items[];

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        items = getResources().getStringArray(R.array.items);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        //设置下拉样式:注意设置和不设置的区别
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_data_java.setAdapter(adapter);
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String str[] = getResources().getStringArray(R.array.languages);
        Toast.makeText(this, i + "", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
