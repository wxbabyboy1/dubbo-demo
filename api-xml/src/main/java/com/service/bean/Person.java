package com.service.bean;

import java.io.Serializable;

/**
 * Created by ZhaGuolong on 2018/2/27.
 */
public class Person implements Serializable{
    private int id;
    private String name;
    private int num;

    public Person(int id, String name, int num){
        this.id = id;
        this.name = name;
        this.num = num;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
