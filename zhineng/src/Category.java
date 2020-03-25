package com.zhineng.bean;

import java.io.Serializable;

public class Category implements Serializable {
    private int cid;
    private String cname;

    public Category(){

    }

    public Category(int cid,String cname){
        this.cid = cid;
        this.cname = cname;
    }

    @Override
    public String toString(){
        return  "Category{" +
                "cid=" + cid +
                ",cname'" + cname + '\'' +
                '}';
    }
}
