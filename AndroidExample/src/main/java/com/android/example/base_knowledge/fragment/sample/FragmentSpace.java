package com.android.example.base_knowledge.fragment.sample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.example.R;

/**
 * 描述：FragmentSpace
 * Created by Administrator on 2016/3/1 0001.
 */
public class FragmentSpace extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_space_layout, container, false);

        return view;
    }
}