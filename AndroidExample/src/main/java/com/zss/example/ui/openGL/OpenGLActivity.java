package com.zss.example.ui.openGL;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：OpenGLActivity
 * Created by Administrator on 2016/1/14 0014.
 */
public class OpenGLActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_info;
    private Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_gl_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_info = (TextView) findViewById(R.id.tv_info);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);
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
            case R.id.btn_submit:
                int gifts[] = {2, 2, 5, 5, 5, 7, 6};
                getValue(gifts, gifts.length);
                break;
            default:
                break;
        }
    }

    /**
     * 获取数组中出现次数最多的那个数据
     *
     * @param array:数组，如:[2,5,3,5,5,7,5];
     * @param n:数组长度，如:7;
     */
    public void getValue(int array[], int n) {
        Log.e("", "数组中数据是:");
        for (int i = 0; i < n; i++) {
            Log.e("", array[i] + ",");
        }

        //map中key是次数，value是值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(array[i])) {
                int times = map.get(array[i]);
                map.put(array[i], times + 1);
            } else {
                map.put(array[i], 1);
            }
        }

        Collection<Integer> collection = map.values();
        //找出map的value中最大的数字，也就是数组中数字出现最多的次数
        int maxCount = Collections.max(collection);
        int maxNum = 0;
        //得到value为maxCount的key，也就是数组中出现次数最多的数字
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxCount == entry.getValue()) {
                maxNum = entry.getKey();
            }
        }
        Log.e("", "出现次数最多的数字为:" + maxNum);
        Log.e("", "出现次数为:" + maxCount);
    }
}
