package com.zss.example.ui.anim.view_animation;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 描述：AnimationLayoutControllerActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimationLayoutControllerActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_layout_controller_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        listView = (ListView) findViewById(R.id.listView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        listView.setAdapter(createListAdapter());
    }

    public ListAdapter createListAdapter() {
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("name", "张山");
        map1.put("sex", "男");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("name", "李四");
        map2.put("sex", "男");
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("name", "边丹");
        map3.put("sex", "女");
        HashMap<String, String> map4 = new HashMap<>();
        map4.put("name", "王武");
        map4.put("sex", "男");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list,
                R.layout.activity_animation_controller_item_layout,
                new String[]{"name", "sex"},
                new int[]{R.id.tv_name, R.id.tv_sex});
        return simpleAdapter;
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
