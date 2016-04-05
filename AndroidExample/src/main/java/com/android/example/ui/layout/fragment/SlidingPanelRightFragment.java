package com.android.example.ui.layout.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.example.R;

/**
 * 描述：SlidingPanelRightFragment
 * Created by Administrator on 2016/1/21 0021.
 */
public class SlidingPanelRightFragment extends Fragment {
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sliding_panel_right_layout, container, false);
        textView = (TextView) view.findViewById(R.id.tv_content);
        return view;
    }

    public TextView getTextView() {
        return textView;
    }
}
