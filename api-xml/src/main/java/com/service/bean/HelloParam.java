package com.service.bean;

import java.io.Serializable;

/**
 * Created by Star on 2018/2/28.
 */
public class HelloParam implements Serializable{
    private String name;
    private int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
