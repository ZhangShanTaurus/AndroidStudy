package com.android.example.base_knowledge.fragment.sample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.example.R;

/**
 * 描述：FragmentOne
 * Created by Administrator on 2016/3/1 0001.
 */
public class FragmentOne1 extends Fragment {
    private Button button;

    /**
     * 设置按钮点击的回调
     */
    public interface FOneBtnClickListener {
        void onFOneClick();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_layout, container, false);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 交给宿主Activity处理，如果它希望处理
                 * */
                if (getActivity() instanceof FOneBtnClickListener) {
                    ((FOneBtnClickListener) getActivity()).onFOneClick();
                }
            }
        });
        return view;
    }
}
