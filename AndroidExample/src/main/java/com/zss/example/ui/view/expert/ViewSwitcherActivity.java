package com.zss.example.ui.view.expert;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：ViewSwitcherActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ViewSwitcherActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_screenNo;
    private ViewSwitcher viewSwitcher;
    private LayoutInflater inflater;
    //每屏幕显示程序数量
    private static final int NUMBER_PER_SCREEN = 12;
    //保存系统所有应用list集合
    private List<DataItem> list = new ArrayList<>();
    //记录当前正在显示第几屏的程序
    private int screenNo = -1;
    //程序所占的总屏数
    private int screenCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_switcher_layout);
        initData();
        initView();
    }

    @Override
    public void initView() {
        inflater = LayoutInflater.from(this);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        tv_screenNo = (TextView) findViewById(R.id.tv_screenNo);
        viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return inflater.inflate(R.layout.view_switcher_layout, null);
            }
        });
        //页面加载时先显示第一屏
        next(null);
    }

    @Override
    public void initData() {
        // 创建一个包含40个元素的List集合，用于模拟包含40个应用程序
        for (int i = 0; i < 40; i++) {
            DataItem item = new DataItem();
            item.setName("应用" + i);
            item.setDrawable(getResources().getDrawable(R.drawable.ic_launcher));
            list.add(item);
        }
        // 计算应用程序所占的总屏数
        screenCount = list.size() % NUMBER_PER_SCREEN == 0 ? list.size() / NUMBER_PER_SCREEN : list.size() / NUMBER_PER_SCREEN + 1;
    }

    public void next(View view) {
        if (screenNo < screenCount - 1) {
            screenNo++;
            //为ViewSwitch组件显示过程设置动画
            viewSwitcher.setInAnimation(this, R.anim.slide_in_left);
            //为ViewSwitch组件隐藏过程设置动画
            viewSwitcher.setInAnimation(this, R.anim.slide_out_right);
            //控制下一屏将要显示的GridView对应的adapter
            ((GridView) viewSwitcher.getNextView()).setAdapter(new ViewSwitchAdapter());
            //点击右边按钮，显示下一屏，也可以通过手势检测实现显示下一屏
            viewSwitcher.showNext();
            int index = screenNo + 1;
            tv_screenNo.setText("第" + index + "屏---" + "共" + screenCount + "屏");
        } else {
            Toast.makeText(this, "到最后一屏了", Toast.LENGTH_SHORT).show();
        }
    }

    public void prev(View view) {
        if (screenNo > 0) {
            screenNo--;
            //为ViewSwitch组件显示过程设置动画
            viewSwitcher.setInAnimation(this, R.anim.slide_in_right);
            //为ViewSwitch组件隐藏过程设置动画
            viewSwitcher.setInAnimation(this, R.anim.slide_out_left);
            //控制下一屏将要显示的GridView对应的adapter
            ((GridView) viewSwitcher.getNextView()).setAdapter(new ViewSwitchAdapter());
            //点击左边按钮，显示上一屏，也可以通过手势检测实现显示上一屏
            viewSwitcher.showPrevious();
            int index = screenNo + 1;
            tv_screenNo.setText("第" + index + "屏---" + "共" + screenCount + "屏");
        } else {
            Toast.makeText(this, "已是第一屏了", Toast.LENGTH_SHORT).show();
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


    class ViewSwitchAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            //如果已经到了最后一屏，且应用程序的数量不能整除NUMBER_PER_SCREEN
            if (screenNo == screenCount - 1 && list.size() % NUMBER_PER_SCREEN != 0) {
                // 最后一屏显示的程序数为应用程序的数量对NUMBER_PER_SCREEN求余
                return list.size() % NUMBER_PER_SCREEN;
            }
            // 否则每屏显示的程序数量为NUMBER_PER_SCREEN
            return NUMBER_PER_SCREEN;
        }

        @Override
        public ViewSwitcherActivity.DataItem getItem(int i) {
            // 根据screenNo计算第position个列表项的数据
            return list.get(screenNo * NUMBER_PER_SCREEN + i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            View myView = convertView;
            if (convertView == null) {
                myView = LayoutInflater.from(ViewSwitcherActivity.this).inflate(R.layout.adapter_view_switcher_item, null);
            }
            ImageView imageView = (ImageView) myView.findViewById(R.id.iv_icon);
            imageView.setImageDrawable(getItem(i).getDrawable());
            TextView textView = (TextView) myView.findViewById(R.id.tv_name);
            textView.setText(getItem(i).getName());
            return myView;
        }
    }

    //应用程序实体类（内部类）
    class DataItem {
        private String name;//名称
        private Drawable drawable;//图标

        public Drawable getDrawable() {
            return drawable;
        }

        public void setDrawable(Drawable drawable) {
            this.drawable = drawable;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

