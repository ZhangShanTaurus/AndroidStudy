package com.zss.example.ui.view.expert;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：GestureOverlayViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class GestureOverlayViewActivity extends BaseActivity implements View.OnClickListener,
        GestureOverlayView.OnGesturePerformedListener, GestureOverlayView.OnGesturingListener {
    private ImageView iv_back;
    private TextView tv_title;
    private GestureOverlayView gestureOverlayView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_gesture_overlay_view_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        imageView = (ImageView) findViewById(com.zss.example.R.id.imageView);
        gestureOverlayView = (GestureOverlayView) findViewById(com.zss.example.R.id.gestureOverlayView);
        //设置手势可多笔画绘制，默认情况为单笔画绘制
        gestureOverlayView.setGestureStrokeType(GestureOverlayView.GESTURE_STROKE_TYPE_MULTIPLE);
        //设置手势的颜色
        gestureOverlayView.setGestureColor(getResources().getColor(com.zss.example.R.color.Blue));
        //设置还没能形成手势绘制时的颜色（红色）
        gestureOverlayView.setUncertainGestureColor(getResources().getColor(com.zss.example.R.color.Red));
        //设置手势的粗细
        gestureOverlayView.setGestureStrokeWidth(4);
        /*手势绘制完成后淡出屏幕的时间间隔，即绘制完手指离开屏幕后相隔多长时间手势从屏幕上消失；
         * 可以理解为手势绘制完成手指离开屏幕后到调用onGesturePerformed的时间间隔
         * 默认值为420毫秒，这里设置为2秒
         */
        gestureOverlayView.setFadeOffset(2000);
        //绑定监听
        gestureOverlayView.addOnGesturePerformedListener(this);
        gestureOverlayView.addOnGesturingListener(this);
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

    //手势绘制完成时调用
    @Override
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        Bitmap bitmap = gesture.toBitmap(128, 128, 10, 0xffff0000);
        imageView.setImageBitmap(bitmap);
        // 获取手势库
        GestureLibrary gestureLib = GestureLibraries.fromFile("/storage/sdcard0/myGestures");
        //添加手势
        gestureLib.addGesture("手势名称", gesture);
        //保存手势
        gestureLib.save();
        Toast.makeText(GestureOverlayViewActivity.this, "手势文件保存成功", Toast.LENGTH_SHORT).show();
    }

    //结束正在绘制手势时调用（手势绘制完成时一般先调用它再调用onGesturePerformed（））
    @Override
    public void onGesturingEnded(GestureOverlayView gestureOverlayView) {
        Toast.makeText(GestureOverlayViewActivity.this, "结束正在绘制手势", Toast.LENGTH_SHORT).show();
    }

    //正在绘制手势时调用
    @Override
    public void onGesturingStarted(GestureOverlayView gestureOverlayView) {
        Toast.makeText(GestureOverlayViewActivity.this, "正在绘制手势", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //移除绑定的监听器
        gestureOverlayView.removeOnGesturePerformedListener(this);
        gestureOverlayView.removeOnGesturingListener(this);
    }
}
