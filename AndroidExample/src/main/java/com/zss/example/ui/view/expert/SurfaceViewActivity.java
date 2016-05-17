package com.zss.example.ui.view.expert;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：SurfaceViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class SurfaceViewActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private MySurfaceView mySurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_surface_view_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        mySurfaceView = (MySurfaceView) findViewById(com.zss.example.R.id.mySurfaceView);
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
            default:
                break;
        }
    }
}

/**
 * 自定义SurfaceView
 */
class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private SurfaceHolder holder;
    private Canvas canvas;
    private Thread thread;
    private boolean isRunning;

    public MySurfaceView(Context context) {
        this(context, null);

    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        holder = getHolder();
        holder.addCallback(this);
        //设置画布，背景透明
        setZOrderOnTop(true);
        holder.setFormat(PixelFormat.TRANSLUCENT);
        //设置可获得焦点
        setFocusable(true);
        setFocusableInTouchMode(true);
        //设置常亮
        this.setKeepScreenOn(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        //开启线程
        isRunning = true;
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        ;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        //通知关闭线程
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            long start = System.currentTimeMillis();
            draw();
            long end = System.currentTimeMillis();
            try {
//                if (end - start < 50) {
//                    Thread.sleep(50 - (end - start));
//                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static int count = 0;
    static float h = 300f;

    public void draw() {
        try {
            canvas = holder.lockCanvas();
            if (canvas != null) {
                Rect rect = new Rect(100, 50, 300, 150);
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                paint.setTextSize(31);
                canvas.drawRect(rect, paint);
//                h += 20;
                canvas.drawText("Time:" + count++, 100.0f, h, paint);
                Log.e("", "h=" + h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (canvas != null) {
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
