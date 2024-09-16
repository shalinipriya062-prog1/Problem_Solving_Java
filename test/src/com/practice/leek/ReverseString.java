package com.practice.leek;

public class ReverseString {
    public static void main(String[] args) {
        String[] s = {"A", "B", "C"};
        String[] r = new String[s.length];
        for (int i = 0; i < s.length; i++) {
                r[i] = s[s.length-i-1];
        }
        for(String j: r)
        System.out.println(j);

    }
}
