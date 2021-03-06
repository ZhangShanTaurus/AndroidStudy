package com.zss.example.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.CommonActivity;
import com.zss.example.common.Constance;
import com.zss.example.common.DataResource;
import com.zss.example.common.MyData;
import com.zss.example.utils.IntentUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 启动activity
 */
public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private MyAdapter adapter;
    private List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        initData();
        initView();
        maoPaoSort();
        diGui(5);
    }

    @Override
    public void initView() {
        listView = (ListView) findViewById(R.id.listView);
        adapter = new MyAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void initData() {
        list = new ArrayList<>();
        list.add(R.string.base_knowledge);
        list.add(R.string.ui);
        list.add(R.string.java_thread);
        list.add(R.string.communication);
        list.add(R.string.data_parser);
        list.add(R.string.data_persistence);
        list.add(R.string.performance);
        list.add(R.string.debug);
        list.add(R.string.adaptive);
        list.add(R.string.test);
        list.add(R.string.safe);
        list.add(R.string.ndk);
        list.add(R.string.phone_function);
        list.add(R.string.extend);
        list.add(R.string.other);
    }


    /**
     * 冒泡排序
     */
    public void maoPaoSort() {
        int arrays[] = {100, 88, 95, 76, 40, 67};
        int length = arrays.length;
        Log.e("", length + "");
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arrays[j] < arrays[j + 1]) {
                    //把小的值放到后面
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }

        Log.e("", "结果为:");
        for (int a = 0; a < length; a++) {
            Log.e("", arrays[a] + "");
        }
    }


    /**
     * 递归算法
     */
    private int diGui(int index) {
        int sum = 0;
        if (index == 0) {
            return 1;
        } else {
            sum = index * diGui(index - 1);
            Log.e("", "sum--" + sum);
            return sum;
        }
    }

    private MyData myData;

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (list.get(i)) {
            case R.string.base_knowledge:
                myData = new MyData(list.get(i), new DataResource(Constance.BASE_KNOWLEDGE).getList(), Constance.BASE_KNOWLEDGE);
                break;
            case R.string.ui:
                myData = new MyData(list.get(i), new DataResource(Constance.UI).getList(), Constance.UI);
                break;
            case R.string.java_thread:
                myData = new MyData(R.string.java_thread, new DataResource(Constance.MULTI_THREAD).getList(), Constance.MULTI_THREAD);
                break;
            case R.string.communication:
                myData = new MyData(list.get(i), new DataResource(Constance.COMMUNICATION).getList(), Constance.COMMUNICATION);
                break;
            case R.string.data_parser:
                myData = new MyData(list.get(i), new DataResource(Constance.DATA_PARSER).getList(), Constance.DATA_PARSER);
                break;
            case R.string.data_persistence:
                myData = new MyData(list.get(i), new DataResource(Constance.PERSISTENCE).getList(), Constance.PERSISTENCE);
                break;
            case R.string.performance:
                myData = new MyData(list.get(i), new DataResource(Constance.PERFORMANCE).getList(), Constance.PERFORMANCE);
                break;
            case R.string.debug:
                myData = new MyData(list.get(i), new DataResource(Constance.DEBUG).getList(), Constance.DEBUG);
                break;
            case R.string.adaptive:
                myData = new MyData(list.get(i), new DataResource(Constance.ADAPTIVE).getList(), Constance.ADAPTIVE);
                break;
            case R.string.test:
                myData = new MyData(list.get(i), new DataResource(Constance.TEST).getList(), Constance.TEST);
                break;
            case R.string.safe:
                myData = new MyData(list.get(i), new DataResource(Constance.SAFE).getList(), Constance.SAFE);
                break;
            case R.string.ndk:
                myData = new MyData(list.get(i), new DataResource(Constance.NDK).getList(), Constance.NDK);
                break;
            case R.string.phone_function:
                myData = new MyData(list.get(i), new DataResource(Constance.PHONE_FUNCTION).getList(), Constance.PHONE_FUNCTION);
                break;
            case R.string.extend:
                myData = new MyData(list.get(i), new DataResource(Constance.EXTEND).getList(), Constance.EXTEND);
                break;
            case R.string.other:
                myData = new MyData(list.get(i), new DataResource(Constance.OTHER).getList(), Constance.OTHER);
                break;
            default:
                myData = new MyData(list.get(i), new DataResource(Constance.OTHER).getList(), Constance.OTHER);
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constance.MYDATA, myData);
        IntentUtils.intent(this, bundle, CommonActivity.class, false);
    }
}

/**
 * 自定义适配器
 */
class MyAdapter extends MyBaseAdapter {
    private Context context;
    private List<Integer> list;

    public MyAdapter(Context context, List<Integer> list) {
        super(list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.adapter_main_item_layout, null);
            holder.textView = (TextView) view.findViewById(R.id.texeView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.textView.setText(list.get(i));
        return view;
    }

    static class ViewHolder {
        private TextView textView;
    }
}