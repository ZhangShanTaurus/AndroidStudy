package com.android.example.base_knowledge.design_mode.builder;

/**
 * 描述：Apple电脑
 * Created by Administrator on 2016/3/16 0016.
 */
public class AppleComputer extends Computer {
    protected AppleComputer() {
    }

    @Override
    public void setCpuCore(int cpuCore) {
        super.cpuCore = cpuCore;
    }

    @Override
    public void setOs(String os) {
        super.os = os;
    }

    @Override
    public void setRamSize(int ramSize) {
        super.ramSize = ramSize;
    }
}
