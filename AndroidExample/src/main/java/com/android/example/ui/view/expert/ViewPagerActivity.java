package com.android.example.ui.view.expert;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：ViewPagerActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ViewPagerActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ImageView iv_back;
    private TextView tv_title;
    private ViewPager viewPager;
    private PagerTabStrip tabStrip;
    private List<View> viewList;
    private List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setOnPageChangeListener(this);
        tabStrip = (PagerTabStrip) findViewById(R.id.tabStrip);
        //取消tab下面的长横线
        tabStrip.setDrawFullUnderline(false);
        //设置tab的背景色
        tabStrip.setBackgroundColor(getResources().getColor(R.color.CadetBlue));
        //设置当前tab页签的下划线颜色
        tabStrip.setTabIndicatorColor(getResources().getColor(R.color.Crimson));
        tabStrip.setTextSpacing(200);

    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        //显示的View
        View view1 = LayoutInflater.from(this).inflate(R.layout.viewpager_tab1, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.viewpager_tab2, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.viewpager_tab3, null);
        View view4 = LayoutInflater.from(this).inflate(R.layout.viewpager_tab4, null);
        //ViewPager开始添加View
        viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        //页签项
        titleList = new ArrayList<>();
        titleList.add("Tab1");
        titleList.add("Tab2");
        titleList.add("Tab3");
        titleList.add("Tab4");

        viewPager.setAdapter(new MyViewPagerAdapter(viewList, titleList));
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

    //当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    // 当当前页面被滑动时调用
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    // 当新的页面被选中时调用
    @Override
    public void onPageSelected(int position) {
        Toast.makeText(ViewPagerActivity.this, "selected:" + position, Toast.LENGTH_SHORT).show();
    }


}

class MyViewPagerAdapter extends PagerAdapter {
    private List<View> viewList;
    private List<String> tabList;

    public MyViewPagerAdapter(List<View> viewList, List<String> tabList) {
        this.viewList = viewList;
        this.tabList = tabList;
    }

    //viewPager中组件数量
    @Override
    public int getCount() {
        return viewList.size();
    }

    //滑动切换时销毁当前组件
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(viewList.get(position));
    }

    //每次滑动生成的组件
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position);
    }
}
