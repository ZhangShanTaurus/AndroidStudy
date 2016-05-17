package com.zss.example.base_knowledge.fragment.sample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zss.example.R;

/**
 * 描述：ContentFragment
 * Created by Administrator on 2016/3/1 0001.
 */
public class FragmentContacts extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts_layout, container, false);
        return view;
    }
}
