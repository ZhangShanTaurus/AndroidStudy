package com.zss.example.ui.view.expert;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ZoomControls;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：ZoomControlsActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ZoomControlsActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private ImageView imageView;
    private TextView tv_title;
    private ZoomControls zoomControls;
    private LinearLayout linearLayout;
    private int id = 0;
    private int displayWidth;//屏幕宽
    private int displayHeight;//屏幕高
    private int imageWidth;//图片宽
    private int imageHeight;//图片高
    private float scaleWidth = 1;
    private float scaleHeight = 1;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_controls_layout);
        initView();
        initData();
        inOrOut();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        imageView = (ImageView) findViewById(R.id.imageView);
        zoomControls = (ZoomControls) findViewById(R.id.zoomControls);
        zoomControls.setIsZoomInEnabled(true);
        zoomControls.setIsZoomOutEnabled(true);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        //获取屏幕分变率
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        displayWidth = dm.widthPixels;
        displayHeight = dm.heightPixels;
        //获取图片宽高
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.default_head);
        imageWidth = bitmap.getWidth();
        imageHeight = bitmap.getHeight();
    }

    public void inOrOut() {
        //图片放大
        zoomControls.setOnZoomInClickListener(new ZoomControls.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomControls.setIsZoomOutEnabled(true);
                int bmpWidth = bitmap.getWidth();
                int bmpHeight = bitmap.getHeight();
                //设置图片的放大比例
                double scale = 1.25;
                //计算这次要放大的比例
                scaleWidth = (float) (scaleWidth * scale);
                scaleHeight = (float) (scaleHeight * scale);
                Matrix matrix = new Matrix();
                matrix.postScale(scaleWidth, scaleHeight);
                Bitmap bmp1 = Bitmap.createBitmap(bitmap, 0, 0, bmpWidth, bmpHeight, matrix, false);
                if (bmp1.getHeight() >= displayHeight) {
                    zoomControls.setIsZoomInEnabled(false);
                }
                imageView.setImageBitmap(bmp1);
            }
        });

        //图片缩小
        zoomControls.setOnZoomOutClickListener(new ZoomControls.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomControls.setIsZoomInEnabled(true);
                int bmpWidth = bitmap.getWidth();
                int bmpHeight = bitmap.getHeight();
                double scale = 0.8;
                scaleWidth = (float) (scaleWidth * scale);
                scaleHeight = (float) (scaleHeight * scale);
                Matrix matrix = new Matrix();
                matrix.postScale(scaleWidth, scaleHeight);
                Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bmpWidth, bmpHeight, matrix, true);
                if (resizeBmp.getHeight() <= imageHeight) {
                    zoomControls.setIsZoomOutEnabled(false);
                }
                imageView.setImageBitmap(resizeBmp);
            }
        });
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
