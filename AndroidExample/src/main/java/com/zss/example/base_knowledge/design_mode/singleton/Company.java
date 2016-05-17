package com.zss.example.base_knowledge.design_mode.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：公司类
 * Created by Administrator on 2016/3/16 0016.
 */
public class Company {
    private List<Person> list = new ArrayList<>();

    //添加员工
    public void addStaff(Person person) {
        list.add(person);
    }

    //显示所有员工
    public String showAllStaff() {
        StringBuilder sb = new StringBuilder();
        for (Person p : list) {
            String str[] = p.toString().split("\\.");
            for (int i = 0; i < str.length; i++) {
                if (i == 0 || i == 1 || i == 2 || i == 6)
                    sb.append(str[i] + ".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
