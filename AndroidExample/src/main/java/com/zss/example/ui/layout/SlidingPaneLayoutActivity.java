package com.zss.example.ui.layout;

import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;
import com.zss.example.ui.layout.fragment.SlidingPanelLeftFragment;
import com.zss.example.ui.layout.fragment.SlidingPanelRightFragment;

/**
 * 描述：SlidingPaneLayoutActivity
 * Created by Administrator on 2016/1/13 0013.
 */
public class SlidingPaneLayoutActivity extends BaseActivity implements SlidingPanelLeftFragment.LeftCheckedListener {
    private ImageView iv_back;
    private TextView tv_title;
    private SlidingPaneLayout sliding_panel_layout;
    private SlidingPanelLeftFragment leftFragment;
    private SlidingPanelRightFragment rightFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silding_panel_layout);
        leftFragment = (SlidingPanelLeftFragment) this.getFragmentManager().findFragmentById(R.id.left_fragment);
        rightFragment = (SlidingPanelRightFragment) this.getFragmentManager().findFragmentById(R.id.right_fragment);
        leftFragment.setListener(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tv_title = (TextView) findViewById(R.id.tv_title);

        sliding_panel_layout = (SlidingPaneLayout) findViewById(R.id.sliding_panel_layout);
        //添加监听器
        sliding_panel_layout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelOpened(View panel) {
                leftFragment.setHasOptionsMenu(true);
            }

            @Override
            public void onPanelClosed(View panel) {
                leftFragment.setHasOptionsMenu(false);
            }
        });
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    @Override
    public void changeItem(String item) {
        sliding_panel_layout.closePane();
        TextView textView = rightFragment.getTextView();
        textView.setText(item);
    }
}
