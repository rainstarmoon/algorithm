package com.myproject.algorithm;

import java.util.Map;

public class Son extends Father {

    private String class3;

    private String class4;

    public Son parserPbBean(Map<String,String> map) {
        Son value = this;
        value.setClass3(map.get("class3"));
        value.setClass4(map.get("class4"));
        super.parserPbBean(map);
        return value;
    }

    public String getClass3() {
        return class3;
    }

    public void setClass3(String class3) {
        this.class3 = class3;
    }

    public String getClass4() {
        return class4;
    }

    public void setClass4(String class4) {
        this.class4 = class4;
    }


}
