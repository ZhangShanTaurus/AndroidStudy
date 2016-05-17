package com.zss.example.ui.layout;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：DrawerLayoutActivity
 * Created by Administrator on 2016/1/13 0013.
 */
public class DrawerLayoutActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, DrawerLayout.DrawerListener {
    private ImageView iv_back;
    private TextView tv_title;
    private DrawerLayout drawerLayout;
    private Button btn_open;
    private ListView listView;
    private String[] str;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        btn_open = (Button) findViewById(R.id.btn_open);
        btn_open.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        str = new String[]{"item1", "item2", "item3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_open:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, str[i], Toast.LENGTH_LONG).show();
        drawerLayout.closeDrawers();
    }


    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
