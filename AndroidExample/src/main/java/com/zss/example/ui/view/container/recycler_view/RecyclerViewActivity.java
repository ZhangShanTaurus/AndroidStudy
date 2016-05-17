package com.zss.example.ui.view.container.recycler_view;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：RecyclerViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class RecyclerViewActivity extends BaseActivity implements View.OnClickListener, RecyclerViewAdapter.OnItemClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<String> list;
    private Button btn_linear;
    private Button btn_grid;
    private Button btn_falls;
    private Button btn_add;
    private Button btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_linear = (Button) findViewById(R.id.btn_linear);
        btn_linear.setOnClickListener(this);
        btn_grid = (Button) findViewById(R.id.btn_grid);
        btn_grid.setOnClickListener(this);
        btn_falls = (Button) findViewById(R.id.btn_falls);
        btn_falls.setOnClickListener(this);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        list = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            list.add("" + (char) i);
        }
        linearLayout();
    }

    /**
     * 线性布局
     */
    public void linearLayout() {
        adapter = new RecyclerViewAdapter(this, list, RecyclerViewAdapter.LINEAR);
        adapter.setOnItemClickListener(this);
        //设置线性
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //添加分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        //设置动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    /**
     * 网格布局
     */
    public void gridLayout() {
        adapter = new RecyclerViewAdapter(this, list, RecyclerViewAdapter.GRID);
        adapter.setOnItemClickListener(this);
        //4列
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        //添加分割线
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    /**
     * 瀑布布局
     */
    public void fallsLayout() {
        adapter = new RecyclerViewAdapter(this, list, RecyclerViewAdapter.FALLS);
        adapter.setOnItemClickListener(this);
        //第二个参数为VERTICAL，第一个参数代表列;第二个参数为HORIZONTAL，第一个参数代表行
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //添加分割线
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_linear:
                linearLayout();
                break;
            case R.id.btn_grid:
                gridLayout();
                break;
            case R.id.btn_falls:
                fallsLayout();
                break;
            case R.id.btn_add:
                adapter.addData(1);
                break;
            case R.id.btn_delete:
                adapter.removeData(1);
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(RecyclerViewActivity.this, "position-" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(RecyclerViewActivity.this, "position-" + position, Toast.LENGTH_SHORT).show();
    }
}
