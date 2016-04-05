package com.android.example.common.model;

/**
 * 描述：Student实体类
 * Created by Administrator on 2016/1/22 0022.
 */
public class Student {
    private int id;
    private String name;//名称
    private int state;//状态,1:选中，2未选中

    public Student(int id) {
        this(id, "张山");
    }

    public Student(int id, String name) {
        this(id, name, 2);
    }

    public Student(int id, String name, int state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
