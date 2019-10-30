package com.myproject.algorithm;

import java.util.Map;

public class Father {

    private String class1;

    private String class2;

    public Father parserPbBean(Map<String,String> map) {
        Father value = this;
        value.setClass1(map.get("class1"));
        value.setClass2(map.get("class2"));
        return value;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getClass2() {
        return class2;
    }

    public void setClass2(String class2) {
        this.class2 = class2;
    }
}
