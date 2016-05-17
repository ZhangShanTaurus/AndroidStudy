package com.zss.example.base_knowledge.fragment.sample;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * 描述：DialogFragmentEditName
 * Created by Administrator on 2016/3/2 0002.
 */
public class DialogFragmentEditName extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //设置没有标题
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(com.zss.example.R.layout.dialog_fragment_edit_name_layout, container);
        return view;
    }
}
