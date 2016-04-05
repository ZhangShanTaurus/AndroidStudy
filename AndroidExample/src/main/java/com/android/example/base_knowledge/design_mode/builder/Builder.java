package com.android.example.base_knowledge.design_mode.builder;

/**
 * 描述：Builder抽象类
 * Created by Administrator on 2016/3/16 0016.
 */
public abstract class Builder {

    //设置Cpu核心数
    public abstract void buildCpu(int cpuCore);

    //设置内存大小
    public abstract void buildRam(int ramSize);

    //设置操作系统
    public abstract void buildOS(String os);

    //创建Computer
    public abstract Computer createComputer();
}
