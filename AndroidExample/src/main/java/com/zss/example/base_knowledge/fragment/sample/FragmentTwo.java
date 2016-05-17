package com.zss.example.base_knowledge.fragment.sample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.zss.example.R;

/**
 * 描述：FragmentTwo
 * Created by Administrator on 2016/3/1 0001.
 */
public class FragmentTwo extends Fragment {
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_layout, container, false);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentThree three = new FragmentThree();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.hide(FragmentTwo.this);
                fragmentTransaction.add(R.id.frameLayout_content, three, "three");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                Toast.makeText(getActivity(), "FragmentTwo---onClick()", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}
