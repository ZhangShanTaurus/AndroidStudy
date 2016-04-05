package com.android.example.base_knowledge.content_provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.common.model.Teacher;
import com.android.example.main.BaseActivity;
import com.android.example.main.MyBaseAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述：CustomConProActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class CustomConProActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Uri uri = Uri.parse("content://hb.android.contentProvider/teacher");

    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_insert;
    private Button btn_query;
    private Button btn_querys;
    private Button btn_update;
    private Button btn_delete;
    private EditText et_name;
    private EditText et_sex;
    private EditText et_id;
    private ListView listView;
    private List<Teacher> list = new ArrayList<>();
    private ConProAdapter adapter;
    private String checkedId = "";//选中条目的的用户id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_conpro_layout);
        initView();
        initData();
        querys();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        et_name = (EditText) findViewById(R.id.et_name);
        et_sex = (EditText) findViewById(R.id.et_sex);
        et_id = (EditText) findViewById(R.id.et_id);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);

        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_insert.setOnClickListener(this);

        btn_query = (Button) findViewById(R.id.btn_query);
        btn_query.setOnClickListener(this);

        btn_querys = (Button) findViewById(R.id.btn_querys);
        btn_querys.setOnClickListener(this);

        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(this);

        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(this);
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
            case R.id.btn_insert:
                insert();
                break;
            case R.id.btn_query:
                query();
                break;
            case R.id.btn_querys:
                querys();
                break;
            case R.id.btn_update:
                update();
                break;
            case R.id.btn_delete:
                delete();
                break;
            default:
                break;
        }
    }


    public void insert() {
        if (TextUtils.isEmpty(et_name.getText().toString())) {
            Toast.makeText(this, "姓名不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        ContentResolver cr = getContentResolver();
        ContentValues cv = new ContentValues();
        cv.put("name", et_name.getText().toString());
        cv.put("sex", et_sex.getText().toString());
        cv.put("date_added", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        cr.insert(uri, cv);
        querys();
    }

    public void query() {
        if (!TextUtils.isEmpty(et_id.getText().toString())) {
            ContentResolver cr = getContentResolver();
            // 查找id为1的数据
            Cursor c = cr.query(uri, null, "_ID=?", new String[]{et_id.getText().toString()}, null);
            //这里必须要调用 c.moveToFirst将游标移动到第一条数据,不然会出现index -1 requested , with a size of 1错误；cr.query返回的是一个结果集。
            if (c.moveToFirst() == false) {
                // 为空的Cursor
                return;
            }
            if (c != null) {
                String name = c.getString(c.getColumnIndex("name"));
                String sex = c.getString(c.getColumnIndex("sex"));
                Toast.makeText(this, "结果:" + name + "--" + sex, Toast.LENGTH_SHORT).show();
                c.close();
            } else {
                Toast.makeText(this, "未查到该条信息", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "查询id不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    public void querys() {
        //每次重新刷新数据
        list.clear();
        checkedId = "";

        ContentResolver cr = getContentResolver();
        // 查找id为1的数据
        Cursor c = cr.query(uri, null, null, null, null);
        while (c.moveToNext()) {
            Teacher teacher = new Teacher();
            teacher.setId(c.getString(c.getColumnIndex("_id")));
            teacher.setName(c.getString(c.getColumnIndex("name")));
            teacher.setSex(c.getString(c.getColumnIndex("sex")));
            teacher.setDate_added(c.getString(c.getColumnIndex("date_added")));
            list.add(teacher);
        }
        c.close();
        if (list != null && list.size() > 0) {
            adapter = new ConProAdapter(this, list);
            listView.setAdapter(adapter);
        }
    }

    public void update() {
        if (!TextUtils.isEmpty(checkedId)) {
            if (!TextUtils.isEmpty(et_name.getText().toString())) {
                ContentResolver cr = getContentResolver();
                ContentValues cv = new ContentValues();
                cv.put("name", et_name.getText().toString());
                cv.put("sex", et_sex.getText().toString());
                cv.put("date_added", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                cr.update(uri, cv, "_ID=?", new String[]{checkedId});
                querys();
            } else {
                Toast.makeText(this, "姓名不能为空", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "请选择要更新的一项", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete() {
        if (!TextUtils.isEmpty(checkedId)) {
            ContentResolver cr = getContentResolver();
            cr.delete(uri, "_ID=?", new String[]{checkedId});
            querys();
        } else {
            Toast.makeText(this, "请选择要删除的一项", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (list.get(i).isSelected()) {
            list.get(i).setIsSelected(false);
            checkedId = "";
        } else {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).isSelected()) {
                    list.get(j).setIsSelected(false);
                }
            }
            list.get(i).setIsSelected(true);
            checkedId = list.get(i).getId();
        }
        adapter.notifyDataSetChanged();
    }
}

class ConProAdapter extends MyBaseAdapter {
    private List<Teacher> list;
    private Context context;

    public ConProAdapter(Context context, List<Teacher> list) {
        super(list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.adapter_conpro_item, null);
            holder.tv_name = (TextView) view.findViewById(R.id.tv_name);
            holder.tv_sex = (TextView) view.findViewById(R.id.tv_sex);
            holder.tv_date_added = (TextView) view.findViewById(R.id.tv_date_added);
            holder.rl_parent = (RelativeLayout) view.findViewById(R.id.rl_parent);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_name.setText(list.get(i).getName() + "-" + list.get(i).getId());
        holder.tv_date_added.setText(list.get(i).getDate_added());
        holder.tv_sex.setText(list.get(i).getSex());
        if (list.get(i).isSelected()) {
            holder.rl_parent.setBackgroundColor(context.getResources().getColor(R.color.Gray));
        } else {
            holder.rl_parent.setBackgroundColor(context.getResources().getColor(R.color.White));
        }
        return view;
    }

    static class ViewHolder {
        TextView tv_name;
        TextView tv_sex;
        TextView tv_date_added;
        RelativeLayout rl_parent;
    }
}