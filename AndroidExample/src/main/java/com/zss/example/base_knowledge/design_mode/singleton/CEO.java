package com.zss.example.base_knowledge.design_mode.singleton;

/**
 * 描述：公司总经理，只有一个
 * Created by Administrator on 2016/3/16 0016.
 */
public class CEO extends Person {
    private static final CEO ceo = new CEO();

    private CEO() {
    }

    public static CEO getCEO() {
        return ceo;
    }

    @Override
    public void talk() {

    }
}
