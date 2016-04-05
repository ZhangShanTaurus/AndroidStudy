package com.android.example.performance.memory.image_handle;

import android.content.res.Resources;
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
 * 描述：LoadLargeImageActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class LoadLargeImageActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private ImageView imageView_compress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_large_image_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        imageView_compress = (ImageView) findViewById(R.id.imageView_compress);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        imageView_compress.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.activity_lunch_mode_single_instance, 100, 100));
    }

    /**
     * 从资源文件中加载图片，经过压缩的
     */
    public Bitmap decodeSampledBitmapFromResource(Resources resource, int resId, int reqWidth, int reqHeight) {
        //第一次解析将inJustDecodeBounds设置为true，来获取图片大小
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resource, resId, options);
        //计算inSampleSize的值
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        //使用inSampleSize的值在次解析图片
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resource, resId, options);
    }

    /**
     * 计算inSampleSize的值
     */
    public int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        //源图片的宽度和高度
        final int width = options.outWidth;
        final int height = options.outHeight;
        int inSampleSize = 1;
        if (width > reqHeight || height > reqHeight) {
            //计算实际宽高与目标宽高的比例
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            //选择宽和高中最小的比率为inSampleSize的值，这样可以保证最终图片的宽和高一定大于或等于目标的宽和高
            inSampleSize = heightRatio > widthRatio ? widthRatio : heightRatio;
        }
        return inSampleSize;
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
