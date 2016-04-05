package com.android.example.ui.view.expert;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：ViewFlipperActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ViewFlipperActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener {
    private ImageView iv_back;
    private TextView tv_title;
    private ViewFlipper viewFlipper;
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_auto;
    private GestureDetector gestureDetector;//手势检测

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        gestureDetector = new GestureDetector(new simpleGestureListener());
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_auto = (Button) findViewById(R.id.btn_auto);
        btn_auto.setOnClickListener(this);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        viewFlipper.setOnTouchListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        //循环显示ViewFlipper中所有View
//        viewFlipper.startFlipping();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_auto:
                viewFlipper.startFlipping();
                break;
            case R.id.btn_one:
                viewFlipper.showNext();
                viewFlipper.stopFlipping();
                break;
            case R.id.btn_two:
                viewFlipper.showNext();
                viewFlipper.stopFlipping();
                break;
            case R.id.btn_three:
                viewFlipper.showNext();
                viewFlipper.stopFlipping();
                break;
            default:
                break;
        }
    }

    //拦截
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    //手势监听
    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        final int FLING_MIN_DISTANCE = 100;
        final int FLING_MIN_VELOCITY = 200;

        @Override
        public boolean onDown(MotionEvent e) {
            Log.e("", "onDown()");
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                viewFlipper.showNext();
                Log.e("", "onFling()  向左滑动");
            } else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                viewFlipper.setInAnimation(ViewFlipperActivity.this, R.anim.view_flipper_push_right_in);
                viewFlipper.setOutAnimation(ViewFlipperActivity.this, R.anim.view_flipper_push_right_out);
                viewFlipper.showPrevious();
                viewFlipper.setInAnimation(ViewFlipperActivity.this, R.anim.view_flipper_push_left_in);
                viewFlipper.setOutAnimation(ViewFlipperActivity.this, R.anim.view_flipper_push_left_out);
                Log.e("", "onFling()  向右滑动");
            }
            return true;
        }
    }
}
