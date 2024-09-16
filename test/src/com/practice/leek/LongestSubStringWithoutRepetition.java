package com.practice.leek;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class LongestSubStringWithoutRepetition {
    public static void main(String[] args){
        //String s = "abcabcbb";
        String s = "au";
        int output = 0;
        if(s.equals(" ")){output = 0;}
        if(s.length()==1) {output = 1;}
        List<String> listSubStrings = new ArrayList<>();
        for (int i = s.length(); i > 1 ; i--) {
            int maxValue = i;
            //System.out.println(i);
            //List<String> listSubStrings = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                if((j+maxValue-1)<s.length()) {
                    String subStr = s.substring(j, j + maxValue - 1);
                    listSubStrings.add(subStr);

                }
            }


        }
        System.out.println(listSubStrings);
        for (String s1: listSubStrings){
            char[] c = s1.toCharArray();
            Arrays.sort(c);
            boolean isUnique = true;
            /*System.out.println("Char array element:");
            for (char c1:c) {
                System.out.println(c1);
            }*/
            for (int i = 0; i < c.length-1; i++) {
                if(c[i]==c[i+1]){
                    isUnique = false;
                    break;
                }
            }
            if(isUnique == true){
                //System.out.println("Output is true");
                output = c.length;
                break;
            }

        }

        System.out.println("Output length: " + output);
    }
}

