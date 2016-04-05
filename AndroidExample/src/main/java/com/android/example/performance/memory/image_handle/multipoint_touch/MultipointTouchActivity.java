package com.android.example.performance.memory.image_handle.multipoint_touch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：MultipointTouchActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class MultipointTouchActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private String imageUrl;
    private ZoomImageView zoomImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipoint_touch_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        zoomImageView = (ZoomImageView) findViewById(R.id.zoomImageView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
            imageUrl = getIntent().getExtras().getString("imageUrl");
            Bitmap bitmap = BitmapFactory.decodeFile(imageUrl);
            zoomImageView.setImageBitmap(bitmap);
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
