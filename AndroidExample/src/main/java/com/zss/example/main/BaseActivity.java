package com.zss.example.main;

import android.app.Activity;

import com.zss.example.utils.IntentUtils;

/**
 * 描述：父类Activity
 * Created by Administrator on 2016/1/12 0012.
 */
public abstract class BaseActivity extends Activity {
    /**
     * 抽象方法：初始化View
     */
    public abstract void initView();

    /**
     * 抽象方法:初始化数据
     */
    public abstract void initData();

    /**
     * 点击返回图标finish当前页面
     */
    public void goBack() {
        this.finish();
        IntentUtils.popFromLeft(this);
    }

    /**
     * 点击手机返回键，finish当前页面
     */
    @Override
    public void onBackPressed() {
        this.finish();
        IntentUtils.popFromLeft(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //结束activity，从堆栈中移除
    }

    /**
     * 父类方法，子类去重写
     * */
    public void fatherMethod() {

    }
}
