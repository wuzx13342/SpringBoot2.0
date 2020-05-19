package com.wuzx.boot.crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {

    private static Map<String, List<String>> addHashMap(){

        Map<String, List<String>> hashMap =new HashMap<>();

        List<String> a1 =new ArrayList<String>();
        a1.add("a1");
        a1.add("a2");
        List<String> b1 =new ArrayList<String>();
        b1.add("b1");
        b1.add("b2");
        b1.add("b3");
        hashMap.put("a1",a1);
        hashMap.put("b1",b1);

        return hashMap;
    }

    public static void main(String[] args) {

        Map<String, List<String>> hashMap = addHashMap();
        int num = 0;
        int vSize = 0;
        a:for (Map.Entry<String, List<String>> entry : hashMap.entrySet()){
            List<String> strs = entry.getValue();
            for(String str:strs){
                vSize =vSize+1;
                System.out.println(str);
                if(str.equals("a1")||str.equals("b1")||str.equals("a2")){
                    num =num+1;
                }else{
                    break a;
                }
            }
        }

        System.out.println("总次数"+num);
        System.out.println("总大小"+vSize);

    }

}
