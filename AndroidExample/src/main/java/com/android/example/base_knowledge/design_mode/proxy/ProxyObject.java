package com.android.example.base_knowledge.design_mode.proxy;

/**
 * 描述：目标对象角色
 * Created by Administrator on 2016/3/16 0016.
 */
public class ProxyObject extends AbstractObject {
    private RealObject realObject;

    @Override
    public String operation() {
        StringBuilder sb = new StringBuilder();
        sb.append("我是代理对象\n");
        if (realObject == null) {
            realObject = new RealObject();
            sb.append(realObject.operation());
        }
        sb.append("我是代理对象");
        return sb.toString();
    }
}
