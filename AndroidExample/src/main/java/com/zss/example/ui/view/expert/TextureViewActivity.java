package com.zss.example.ui.view.expert;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

import java.util.Random;

/**
 * 描述：TextureViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class TextureViewActivity extends BaseActivity implements View.OnClickListener, TextureView.SurfaceTextureListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextureView textureView;
    private Camera camera;
    private Button btn_rotation;
    private Button btn_alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_textture_view_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        btn_rotation = (Button) findViewById(com.zss.example.R.id.btn_rotation);
        btn_rotation.setOnClickListener(this);
        btn_alpha = (Button) findViewById(com.zss.example.R.id.btn_alpha);
        btn_alpha.setOnClickListener(this);

        textureView = (TextureView) findViewById(com.zss.example.R.id.textureView);
        textureView.setSurfaceTextureListener(this);
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
            case com.zss.example.R.id.iv_back:
                onBackPressed();
                break;
            case com.zss.example.R.id.btn_alpha:
                textureView.setAlpha(new Random().nextFloat());
                break;
            case com.zss.example.R.id.btn_rotation:
                textureView.setRotation(new Random().nextFloat() * 100);
                break;
            default:
                break;
        }
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        camera = Camera.open();
        Camera.Size size = camera.getParameters().getPreviewSize();
        try {
            camera.setPreviewTexture(surfaceTexture);
        } catch (Exception e) {
            e.printStackTrace();
        }
        camera.startPreview();
        textureView.setAlpha(1.0f);
        textureView.setRotation(0.0f);
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        camera.stopPreview();
        camera.release();
        return true;
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

    }
}
