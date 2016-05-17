package com.zss.example.ui.view.expert;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.common.model.Student;
import com.zss.example.main.BaseActivity;
import com.zss.example.main.MyBaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：CheckedTextViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class CheckedTextViewActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private ListView listView;
    private CheckedTextView checkedTextView;
    private CheckedTextViewAdapter adapter;
    private List<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checked_textview_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        checkedTextView = (CheckedTextView) findViewById(R.id.checkedTextView);
        checkedTextView.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student(i);
            student.setName("item" + i);
            student.setState(2);
            list.add(student);
        }
        adapter = new CheckedTextViewAdapter(CheckedTextViewActivity.this, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.checkedTextView:
                if (checkedTextView.isChecked()) {
                    checkedTextView.setChecked(false);
                    Toast.makeText(CheckedTextViewActivity.this, "取消", Toast.LENGTH_SHORT).show();
                } else {
                    checkedTextView.setChecked(true);
                    Toast.makeText(CheckedTextViewActivity.this, "选中", Toast.LENGTH_SHORT).show();
                    //设置图标
//                    checkedTextView.setCheckMarkDrawable(android.R.drawable.arrow_down_float);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (list.get(i).getState() == 1) {
            list.get(i).setState(2);
        } else {
            list.get(i).setState(1);
        }
        adapter.notifyDataSetChanged();
    }
}

class CheckedTextViewAdapter extends MyBaseAdapter {
    private List<Student> list;
    private Context context;

    public CheckedTextViewAdapter(Context context, List<Student> list) {
        super(list);
        this.list = list;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_checked_textview_item_layout, null);
            holder.checkedTextView = (CheckedTextView) convertView.findViewById(R.id.checkedTextView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.checkedTextView.setText(list.get(position).getName());
        if (list.get(position).getState() == 1) {
            holder.checkedTextView.setChecked(true);
        } else {
            holder.checkedTextView.setChecked(false);
        }
        return convertView;
    }

    static class ViewHolder {
        CheckedTextView checkedTextView;
    }
}