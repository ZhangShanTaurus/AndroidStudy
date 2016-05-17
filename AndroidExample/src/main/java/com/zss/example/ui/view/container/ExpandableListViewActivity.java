package com.zss.example.ui.view.container;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：ExpandableListViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ExpandableListViewActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private ExpandableListView listView;
    private MyExpandableListAdapter adapter;
    private List<String> group;
    private Map<String, List<String>> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_expandable_listview_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        listView = (ExpandableListView) findViewById(android.R.id.list);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        group = new ArrayList<>();
        group.add("group1");
        group.add("group2");
        group.add("group3");

        map = new HashMap<String, List<String>>();

        List<String> group1 = new ArrayList<>();
        group1.add("item1_1");
        group1.add("item1_2");
        group1.add("item1_3");
        map.put("group1", group1);

        List<String> group2 = new ArrayList<>();
        group2.add("item2_1");
        group2.add("item2_2");
        group2.add("item2_3");
        group2.add("item2_4");
        map.put("group2", group2);

        List<String> group3 = new ArrayList<>();
        group3.add("item3_1");
        group3.add("item3_2");
        group3.add("item3_3");
        group3.add("item3_4");
        group3.add("item3_5");
        group3.add("item3_6");
        map.put("group3", group3);

        adapter = new MyExpandableListAdapter(this, group, map);
        listView.setAdapter(adapter);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long id) {
                String itemInfo = map.get(group.get(groupPosition)).get(childPosition);
                String groupInfo = group.get(groupPosition);
                Toast.makeText(ExpandableListViewActivity.this, groupInfo + "--" + itemInfo, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case com.zss.example.R.id.iv_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}

class MyExpandableListAdapter extends BaseExpandableListAdapter {
    private List<String> group;
    private Map<String, List<String>> map;
    LayoutInflater inflater;

    public MyExpandableListAdapter(Context context, List<String> group, Map<String, List<String>> map) {
        this.group = group;
        this.map = map;
        inflater = LayoutInflater.from(context);
    }

    //child
    //得到子item需要关联的数据
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        String key = group.get(groupPosition);
        return (map.get(key).get(childPosition));
    }


    //得到子item的ID
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //获取当前父item下的子item的个数
    @Override
    public int getChildrenCount(int groupPosition) {
        String key = group.get(groupPosition);
        return map.get(key).size();
    }

    //设置子item的组件
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
        String key = group.get(groupPosition);
        String info = map.get(key).get(childPosition);
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(com.zss.example.R.layout.expandable_children_layout, null);
            holder.textView = (TextView) view.findViewById(com.zss.example.R.id.tv_info);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText(info);
        return view;
    }


    //group
    //获取当前父item的数据
    @Override
    public Object getGroup(int groupPosition) {
        return group.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return group.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(com.zss.example.R.layout.expandable_group_layout, null);
            holder.textView = (TextView) view.findViewById(com.zss.example.R.id.tv_info);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText(group.get(groupPosition));
        return view;
    }


    @Override
    public boolean hasStableIds() {
        return true;
    }


    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    static class ViewHolder {
        TextView textView;
    }
}
