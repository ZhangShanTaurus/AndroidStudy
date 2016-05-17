package com.zss.example.ui.layout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：
 * Created by Administrator on 2016/1/13 0013.
 */
public class TableLayoutActivity extends BaseActivity {
    private ImageView iv_back;
    private TextView tv_title;
    private TableLayout table_layout_java;
    private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
    private final int MP = ViewGroup.LayoutParams.MATCH_PARENT;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tv_title = (TextView) findViewById(R.id.tv_title);
        table_layout_java = (TableLayout) findViewById(R.id.table_layout_java);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        //全部列自动填充空白处
        table_layout_java.setStretchAllColumns(true);
        //生成10行，8列的表格
        for (int row = 0; row < 5; row++) {
            TableRow tableRow = new TableRow(this);
            for (int col = 0; col < 8; col++) {
                TextView tv = new TextView(this);
                tv.setText("(" + row + "," + col + ")");
                tableRow.addView(tv);
            }
            //把新建的TabRow添加到TableLayout中
            table_layout_java.addView(tableRow);
        }
    }
}
