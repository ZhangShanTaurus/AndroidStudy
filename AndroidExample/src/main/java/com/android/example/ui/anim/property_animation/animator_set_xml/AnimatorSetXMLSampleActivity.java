package com.android.example.ui.anim.property_animation.animator_set_xml;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：AnimatorSetXMLSampleActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class AnimatorSetXMLSampleActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_menu;
    private Button btn_menu_item1;
    private Button btn_menu_item2;
    private Button btn_menu_item3;
    private Button btn_menu_item4;
    private Button btn_menu_item5;

    private boolean isMenuOpen = false;
    private final int radius = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set_xml_sample_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_menu = (Button) findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(this);
        btn_menu_item1 = (Button) findViewById(R.id.btn_menu_item1);
        btn_menu_item1.setOnClickListener(this);
        btn_menu_item2 = (Button) findViewById(R.id.btn_menu_item2);
        btn_menu_item2.setOnClickListener(this);
        btn_menu_item3 = (Button) findViewById(R.id.btn_menu_item3);
        btn_menu_item3.setOnClickListener(this);
        btn_menu_item4 = (Button) findViewById(R.id.btn_menu_item4);
        btn_menu_item4.setOnClickListener(this);
        btn_menu_item5 = (Button) findViewById(R.id.btn_menu_item5);
        btn_menu_item5.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    /**
     * 打开动画
     */
    private void doAnimatorOpen(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.toRadians(90) / (total - 1) * index;
        float translationX = -(float) (radius * Math.sin(degree));
        float translationY = -(float) (radius * Math.cos(degree));
        Log.e("", translationX + "---" + translationY);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", 0f, translationX),
                ObjectAnimator.ofFloat(view, "translationY", 0f, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        );
        animatorSet.setDuration(2 * 500).start();
    }

    /**
     * 关闭动画
     */
    private void doAnimatorClose(final View view, int index, int total,
                                 int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 1) * 2);
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0f));

        set.setDuration(2 * 500).start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_menu:
                if (!isMenuOpen) {
                    isMenuOpen = true;
                    doAnimatorOpen(btn_menu_item1, 0, 5, radius);
                    doAnimatorOpen(btn_menu_item2, 1, 5, radius);
                    doAnimatorOpen(btn_menu_item3, 2, 5, radius);
                    doAnimatorOpen(btn_menu_item4, 3, 5, radius);
                    doAnimatorOpen(btn_menu_item5, 4, 5, radius);
                } else {
                    isMenuOpen = false;
                    doAnimatorClose(btn_menu_item1, 0, 5, radius);
                    doAnimatorClose(btn_menu_item2, 1, 5, radius);
                    doAnimatorClose(btn_menu_item3, 2, 5, radius);
                    doAnimatorClose(btn_menu_item4, 3, 5, radius);
                    doAnimatorClose(btn_menu_item5, 4, 5, radius);
                }
                break;
            default:
                Toast.makeText(AnimatorSetXMLSampleActivity.this, "点击了" + view.getId(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
