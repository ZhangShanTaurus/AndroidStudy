package com.zss.example.ui.view.container;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.common.Constance;
import com.zss.example.common.model.Student;
import com.zss.example.main.BaseActivity;
import com.zss.example.main.MyBaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：ListViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ListViewActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ListView listView;
    private ImageView iv_back;
    private TextView tv_title;
    private List<Student> list;
    private MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_listview_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        listView = (ListView) findViewById(com.zss.example.R.id.listView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        //初始化数据源
        list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Student student = new Student(i);
            list.add(student);
        }

        adapter = new MyListAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, i + "--" + list.get(i).getName(), Toast.LENGTH_LONG).show();
    }
}

class MyListAdapter extends MyBaseAdapter {
    Context context;
    List<Student> list;

    public MyListAdapter(Context context, List<Student> list) {
        super(list);
        this.list = list;
        this.context = context;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        OnClick onClick = null;
        if (view == null) {
            holder = new ViewHolder();
            onClick = new OnClick();
            view = LayoutInflater.from(context).inflate(com.zss.example.R.layout.adapter_listview_item, null);
            holder.tv_name = (TextView) view.findViewById(com.zss.example.R.id.tv_name);
            holder.tv_state = (TextView) view.findViewById(com.zss.example.R.id.tv_state);
            holder.iv_check = (ImageView) view.findViewById(com.zss.example.R.id.iv_check);
            view.setTag(holder);
            view.setTag(com.zss.example.R.id.iv_check, onClick);
        } else {
            holder = (ViewHolder) view.getTag();
            onClick = (OnClick) view.getTag(com.zss.example.R.id.iv_check);
        }

        holder.tv_name.setText(list.get(i).getName());
        if (list.get(i).getState() == 1) {
            holder.tv_state.setText(list.get(i).getState() + "-选中");
            holder.iv_check.setImageResource(com.zss.example.R.drawable.icon_checked);
        } else {
            holder.tv_state.setText(list.get(i).getState() + "-未选中");
            holder.iv_check.setImageResource(com.zss.example.R.drawable.icon_unchecked);
        }

        holder.iv_check.setOnClickListener(onClick);
        onClick.setPosition(i);
        return view;
    }


    static class ViewHolder {
        TextView tv_name;//名字
        TextView tv_state;//状态
        ImageView iv_check;//选中
    }

    class OnClick implements View.OnClickListener {
        private int position;

        public void setPosition(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case com.zss.example.R.id.iv_check:
                    if (list.get(position).getState() == 1) {
                        list.get(position).setState(2);
                        notifyDataSetChanged();
                    } else {
                        list.get(position).setState(1);
                        notifyDataSetChanged();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
