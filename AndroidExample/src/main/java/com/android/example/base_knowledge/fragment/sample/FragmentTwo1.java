package com.android.example.base_knowledge.fragment.sample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.example.R;

/**
 * 描述：FragmentTwo
 * Created by Administrator on 2016/3/1 0001.
 */
public class FragmentTwo1 extends Fragment {
    private Button button;
    private FTwoBtnClickListener listener;

    /**
     * 设置回调接口
     */
    public void setListener(FTwoBtnClickListener listener) {
        this.listener = listener;
    }

    public interface FTwoBtnClickListener {
        void onFTwoClick();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_layout, container, false);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onFTwoClick();
                }
            }
        });
        return view;
    }
}
