package com.practice1;

import java.util.*;

public class DuplicateStrings {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a");
        list.add("a");

        LinkedHashMap<String, Integer> countMap = new LinkedHashMap<String, Integer>();
        for (String s: list) {
            if(countMap.keySet().contains(s)){
                countMap.replace(s, countMap.get(s)+1);
            }
            else{
                countMap.put(s,1);
            }
        }
        for(String s: countMap.keySet()){
            if(countMap.get(s) >1) {
                System.out.println("Duplicate String : " + s );
            }
        }


    }
}
