package com.android.example.base_knowledge.design_mode.proxy;

/**
 * 描述：目标对象角色
 * Created by Administrator on 2016/3/16 0016.
 */
public class RealObject extends AbstractObject {
    @Override
    public String operation() {
        return "我是目标对象\n";
    }
}
