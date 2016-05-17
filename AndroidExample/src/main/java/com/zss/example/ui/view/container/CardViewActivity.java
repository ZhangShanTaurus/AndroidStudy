package com.zss.example.ui.view.container;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：CardViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class CardViewActivity extends BaseActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private ImageView iv_back;
    private TextView tv_title;
    private CardView cardView;
    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private SeekBar seekBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        cardView = (CardView) findViewById(R.id.cardView);
        seekBar1 = (SeekBar) findViewById(R.id.sb_1);
        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2 = (SeekBar) findViewById(R.id.sb_2);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar3 = (SeekBar) findViewById(R.id.sb_3);
        seekBar3.setOnSeekBarChangeListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()) {
            case R.id.sb_1:
                cardView.setRadius(i);//设置圆角大小
                break;
            case R.id.sb_2:
                cardView.setCardElevation(i);//设置阴影大小
                break;
            case R.id.sb_3:
                cardView.setContentPadding(i, i, i, i);//设置间距
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}
