package com.hanshaoda.mydemo;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * author: hanshaoda
 * created on: 2017/9/21 下午6:21
 * description:
 */
public class DataBean{

    public static final int FIRST_TYPE = 1;
    public static final int SECOND_TYPE = 2;
    //添加类型变量 设置数据类型
    public int type;
    private String name;
    private int image;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
