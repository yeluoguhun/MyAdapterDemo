package com.hanshaoda.mydemo;

/**
 * author: hanshaoda
 * created on: 2017/9/21 下午3:01
 * description:
 */

public class Person {
    private String name;
    private String trans;

    public Person(String name, String trans) {
        this.name = name;
        this.trans = trans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }
}
