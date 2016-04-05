package com.android.example.base_knowledge.design_mode.builder;

/**
 * 描述：组装类
 * Created by Administrator on 2016/3/16 0016.
 */
public class Director {
    private Builder builder = null;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(int cpuCore, int ramSize, String os) {
        builder.buildCpu(cpuCore);
        builder.buildOS(os);
        builder.buildRam(ramSize);
    }
}
