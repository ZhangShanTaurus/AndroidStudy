package com.android.example.base_knowledge.fragment.sample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.example.R;

/**
 * 描述：ContentFragment
 * Created by Administrator on 2016/3/1 0001.
 */
public class ContentFragment extends Fragment {
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_layout, container, false);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "ContentFragment---onClick()", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
