package com.zss.example.ui.view.expert;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：ImageSwitcherActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ImageSwitcherActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private ImageSwitcher imageSwitcher;
    private Button btn_back;
    private Button btn_forward;
    private int index = 0;
    private int[] images = {R.drawable.style_character_sketch, R.drawable.style_color_hand_painted,
            R.drawable.style_elaboration_hand_painted, R.drawable.style_full_view_hand_painted};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        btn_forward = (Button) findViewById(R.id.btn_forward);
        btn_forward.setOnClickListener(this);

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return new ImageView(ImageSwitcherActivity.this);
            }
        });

        if (images.length > 0) {
            imageSwitcher.setImageResource(0);
        }
        imageSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
        imageSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);
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
            case R.id.btn_back:
                index--;
                if (index < 0) {
                    index = images.length - 1;
                }
                imageSwitcher.setImageResource(images[index]);
                break;
            case R.id.btn_forward:
                index++;
                if (index > images.length - 1) {
                    index = 0;
                }
                imageSwitcher.setImageResource(images[index]);
                break;
            default:
                break;
        }
    }
}
