package com.zss.example.multi_thread;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：ThreadCommonInfoActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ThreadCommonInfoActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_common_info_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            int title = getIntent().getExtras().getInt(Constance.TITLE);
            tv_title.setText(title);
            switch (title) {
                case R.string.thread_process:
                    textView.setText(getResources().getString(R.string.thread_process_info));
                    break;
                case R.string.thread_in_java:
                    textView.setText(getResources().getString(R.string.thread_in_java_info));
                    break;
                case R.string.thread_define:
                    textView.setText(getResources().getString(R.string.thread_define_info));
                    break;
                case R.string.thread_instantiation:
                    textView.setText(getResources().getString(R.string.thread_instantiation_info));
                    break;
                case R.string.thread_start:
                    textView.setText(getResources().getString(R.string.thread_start_info));
                    break;
                case R.string.thread_problem:
                    textView.setText(getResources().getString(R.string.thread_problem_info));
                    break;
                case R.string.thread_state:
                    textView.setText(getResources().getString(R.string.thread_state_info));
                    break;
                case R.string.thread_priority:
                    textView.setText(getResources().getString(R.string.thread_priority_info));
                    break;
                case R.string.thread_sleep1:
                    textView.setText(getResources().getString(R.string.thread_sleep1_info));
                    break;
                case R.string.thread_yield:
                    textView.setText(getResources().getString(R.string.thread_yield_info));
                    break;
                case R.string.thread_join:
                    textView.setText(getResources().getString(R.string.thread_join_info));
                    break;
                case R.string.thread_state_convert_summary:
                    textView.setText(getResources().getString(R.string.thread_state_convert_summary_info));
                    break;
                case R.string.thread_sync_lock1:
                    textView.setText(getResources().getString(R.string.thread_sync_lock1_info));
                    break;
                case R.string.thread_static_method_sync:
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(R.drawable.thread_static_method_sync_info);
                    textView.setText(getResources().getString(R.string.thread_static_method_sync_info));
                    break;
                case R.string.thread_not_get_lock:
                    textView.setText(getResources().getString(R.string.thread_not_get_lock_info));
                    break;
                case R.string.thread_when_sync:
                    textView.setText(getResources().getString(R.string.thread_when_sync_info));
                    break;
                case R.string.thread_safe_class:
                    textView.setText(getResources().getString(R.string.thread_safe_class_info));
                    break;
                case R.string.thread_dead_lock:
                    textView.setText(getResources().getString(R.string.thread_dead_lock_info));
                    break;
                case R.string.thread_sync_lock_summary:
                    textView.setText(getResources().getString(R.string.thread_sync_lock_summary_info));
                    break;
                default:
                    textView.setText(getResources().getString(R.string.test_character));
                    break;
            }
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
