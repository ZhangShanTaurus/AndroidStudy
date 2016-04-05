package com.android.example.base_knowledge.design_mode.builder;

/**
 * 描述：
 * Created by Administrator on 2016/3/16 0016.
 */
public class ApplePCBuilder extends Builder {
    private Computer appleComputer = new AppleComputer();

    @Override
    public void buildCpu(int cpuCore) {
        appleComputer.setCpuCore(cpuCore);
    }

    @Override
    public void buildOS(String os) {
        appleComputer.setOs(os);
    }

    @Override
    public void buildRam(int ramSize) {
        appleComputer.setRamSize(ramSize);
    }

    @Override
    public Computer createComputer() {
        return appleComputer;
    }
}
