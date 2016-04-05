package com.android.example.ui.layout.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.example.R;

/**
 * 描述：SlidingPanelLeftFragment
 * Created by Administrator on 2016/1/21 0021.
 */
public class SlidingPanelLeftFragment extends Fragment implements AdapterView.OnItemClickListener {

    public interface LeftCheckedListener {
        void changeItem(String item);
    }

    public void setListener(LeftCheckedListener listener) {
        this.listener = listener;
    }

    public LeftCheckedListener listener = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sliding_panel_left_layout, container, false);
        initListView(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        if (context instanceof LeftCheckedListener) {
            listener = (LeftCheckedListener) context;
        } else {
            throw new ClassCastException();
        }

        super.onAttach(context);
    }

    String items[];

    /**
     * 初始化ListView
     */
    public void initListView(View view) {
        ListView listView = (ListView) view.findViewById(R.id.listView);
        items = new String[]{"网易", "腾讯", "新浪", "搜狐"};
        ArrayAdapter adapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (listener == null) {
            return;
        }
        switch (i) {
            case 0:
                listener.changeItem(items[i]);
                break;
            case 1:
                listener.changeItem(items[i]);
                break;
            case 2:
                listener.changeItem(items[i]);
                break;
            case 3:
                listener.changeItem(items[i]);
                break;
            default:
                break;
        }
    }
}
