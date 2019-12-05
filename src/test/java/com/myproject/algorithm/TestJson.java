package com.myproject.algorithm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;

public class TestJson {
    public static void main(String[] args) {
        User aaa=new User("aaa");
        User bbb=new User("bbb");
        User ccc=new User("ccc");
        User ddd=new User("ddd");

        Map<String,User> mapA = new HashMap<>();
        mapA.put("aaa",aaa);
        mapA.put("bbb",bbb);
        mapA.put("ccc",ccc);
        mapA.put("ddd",ddd);

        Map<String,User> mapB = new HashMap<>();
        mapB.put("aaa",aaa);
        mapB.put("bbb",bbb);
        mapB.put("ccc",ccc);
        mapB.put("ddd",ddd);

        Map<String,Map<String,User>> map = new HashMap<>();
        map.put("a",mapA);
        map.put("b",mapB);

        String s = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(s);

        //String str = "{\"a\":{\"aaa\":{\"name\":\"aaa\"},\"ccc\":{\"name\":\"ccc\"},\"bbb\":{\"name\":\"bbb\"},\"ddd\":{\"name\":\"ddd\"}},\"b\":{\"aaa\":{\"$ref\":\"$.a.aaa\"},\"ccc\":{\"$ref\":\"$.a.ccc\"},\"bbb\":{\"$ref\":\"$.a.bbb\"},\"ddd\":{\"$ref\":\"$.a.ddd\"}}}";
//        String str = "{\"b\":{\"aaa\":{\"$ref\":\"$.a.aaa\"},\"ccc\":{\"$ref\":\"$.a.ccc\"},\"bbb\":{\"$ref\":\"$.a.bbb\"},\"ddd\":{\"$ref\":\"$.a.ddd\"}},\"a\":{\"aaa\":{\"name\":\"aaa\"},\"ccc\":{\"name\":\"ccc\"},\"bbb\":{\"name\":\"bbb\"},\"ddd\":{\"name\":\"ddd\"}}}";
//
//        Map temp = JSON.parseObject(str, Map.class);
//
//        System.out.println(temp);
    }
}
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}