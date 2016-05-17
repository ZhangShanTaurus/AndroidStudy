package com.zss.example.ui.view.container;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.common.model.Student;
import com.zss.example.main.BaseActivity;
import com.zss.example.main.MyBaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：GridViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class GridViewActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private GridView gridView;
    private ImageView iv_back;
    private TextView tv_title;
    private MyGridAdapter adapter;
    private List<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tv_title = (TextView) findViewById(R.id.tv_title);
        gridView = (GridView) findViewById(R.id.gridView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        list = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            Student student = new Student(i);
            list.add(student);
        }
        adapter = new MyGridAdapter(this, list);
        gridView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}

class MyGridAdapter extends MyBaseAdapter {
    Context context;
    List<Student> list;

    public MyGridAdapter(Context context, List<Student> list) {
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
            view = LayoutInflater.from(context).inflate(R.layout.adapter_gridview_item, null);
            holder.tv_state = (TextView) view.findViewById(R.id.tv_state);
            holder.iv_animal = (ImageView) view.findViewById(R.id.iv_animal);
            view.setTag(holder);
            view.setTag(R.id.iv_animal, onClick);
        } else {
            holder = (ViewHolder) view.getTag();
            onClick = (OnClick) view.getTag(R.id.iv_animal);
        }

        if (list.get(i).getState() == 1) {
            holder.tv_state.setText(list.get(i).getState() + "-亮");
            holder.iv_animal.setImageResource(R.drawable.icon_bright);
        } else {
            holder.tv_state.setText(list.get(i).getState() + "-暗");
            holder.iv_animal.setImageResource(R.drawable.icon_dark);
        }

        holder.iv_animal.setOnClickListener(onClick);
        onClick.setPosition(i);
        return view;
    }


    static class ViewHolder {
        TextView tv_state;//状态
        ImageView iv_animal;//选中
    }

    class OnClick implements View.OnClickListener {
        private int position;

        public void setPosition(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.iv_animal:
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