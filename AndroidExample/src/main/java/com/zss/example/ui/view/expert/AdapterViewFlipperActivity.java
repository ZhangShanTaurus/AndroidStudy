package com.zss.example.ui.view.expert;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：AdapterViewFlipperActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AdapterViewFlipperActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private AdapterViewFlipper flipper;
    private int images[] = {R.drawable.style_character_sketch, R.drawable.style_color_hand_painted,
            R.drawable.style_elaboration_hand_painted, R.drawable.style_full_view_hand_painted};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        flipper = (AdapterViewFlipper) findViewById(R.id.flipper);
        flipper.setAdapter(new AdapterViewFlipperAdapter(images, this));
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
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

    public void prev(View view) {
        //显示上一个组件
        flipper.showPrevious();
        //停止自动播放
        flipper.stopFlipping();
    }

    public void next(View view) {
        //显示下一个组件
        flipper.showNext();
        //停止自动播放
        flipper.stopFlipping();
    }

    public void auto(View view) {
        //开始自动播放
        flipper.startFlipping();
    }
}

class AdapterViewFlipperAdapter extends BaseAdapter {
    private int images[];
    private Context context;

    public AdapterViewFlipperAdapter(int images[], Context context) {
        this.images = images;
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return imageView;
    }
}