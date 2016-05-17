package com.zss.example.base_knowledge.design_mode.builder;

/**
 * 描述：产品抽象类
 * Created by Administrator on 2016/3/16 0016.
 */
public abstract class Computer {
    protected int cpuCore = 1;
    protected int ramSize = 0;
    protected String os = "Dos";

    protected Computer() {
    }

    //设置CPU核心数
    public abstract void setCpuCore(int cpuCore);

    //设置操作系统
    public abstract void setOs(String os);

    //设置内存
    public abstract void setRamSize(int ramSize);

    @Override
    public String toString() {
        return "Computer Info--[mCpuCore=" + cpuCore + ", mRamSize=" + ramSize
                + ", mOs=" + os + "]";
    }
}
