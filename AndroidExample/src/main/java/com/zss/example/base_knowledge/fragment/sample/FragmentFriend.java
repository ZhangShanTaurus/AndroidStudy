package com.zss.example.base_knowledge.fragment.sample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zss.example.R;

/**
 * 描述：ContentFragment
 * Created by Administrator on 2016/3/1 0001.
 */
public class FragmentFriend extends Fragment {
    private Button button;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_layout, container, false);
        textView = (TextView) view.findViewById(R.id.textView);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView viewById = (TextView) getActivity().findViewById(R.id.tv_message);
                textView.setText(viewById.getText().toString());
            }
        });
        return view;
    }
}
