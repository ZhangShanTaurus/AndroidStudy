package com.zss.example.ui.view.widgets;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：TabLayoutActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class TabLayoutActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    /**
     * 数据源
     */
    private static final String DATA[] = {"Item1", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8", "Item9",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        //设置TabLayout模式，MODE_SCROLLABLE:可滚动,MODE_FIXED:不可滚动
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //设置TabLayout布局方式,GRAVITY_FILL:填满，GRAVITY_CENTER:居中,该设置只有在TabMode为MODE_FIXED才可用
//        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        //设置选中与未选中颜色
//        tabLayout.setTabTextColors(Color.RED, Color.GREEN);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        //添加数据
//        TabLayout.Tab tab1 = tabLayout.newTab().setText("Tab1");
//        tabLayout.addTab(tab1);
        //构造adapter对象
        TabPagerAdapter adapter = new TabPagerAdapter();
        //设置从PagerAdapter中获取Tab
        tabLayout.setTabsFromPagerAdapter(adapter);
        //设置Tab的选择监听
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //当我们选择了一个Tab就把ViewPager滚动至响应的Page
                viewPager.setCurrentItem(tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //构造一个TabLayout的onPageChangeListener
        TabLayout.TabLayoutOnPageChangeListener listener = new TabLayout.TabLayoutOnPageChangeListener(tabLayout);
        //设置ViewPager页面改变后的监听
        viewPager.addOnPageChangeListener(listener);
        //设置ViewPager的适配器
        viewPager.setAdapter(adapter);
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


    private class TabPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return DATA.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView textView = new TextView(TabLayoutActivity.this);
            textView.setText(DATA[position]);
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.CENTER);
            container.addView(textView, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);
            return textView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        /**
         * 获取Tab名称
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return DATA[position];
        }
    }
}
