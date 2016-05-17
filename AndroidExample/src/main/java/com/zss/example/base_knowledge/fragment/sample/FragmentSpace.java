package com.zss.example.base_knowledge.fragment.sample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 描述：FragmentSpace
 * Created by Administrator on 2016/3/1 0001.
 */
public class FragmentSpace extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(com.zss.example.R.layout.fragment_space_layout, container, false);

        return view;
    }
}
