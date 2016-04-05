package com.android.example.common;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：数据源实体类
 * Created by Administrator on 2016/1/14 0014.
 */
public class MyData implements Serializable {
    private int type;//类型
    private int title;//标题
    private List<Integer> list;//传递的数据

    /**
     * @param title:标题
     * @param list:数据
     * @param type:类型
     */
    public MyData(int title, List list, int type) {
        this.title = title;
        this.list = list;
        this.type = type;
    }

    public List<Integer> getList() {
        return list;
    }

    public int getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }
}
