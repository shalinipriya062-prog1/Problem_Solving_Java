package com.designPatternsLeetcode;

public class TwoPointerPalindrome {

    public static boolean checkPalindrome(String s){
        int i = 0, j = s.length()-1;
        boolean isPal = true;
        while (i<j){
            System.out.println("----------------");
            System.out.println("i: " + i);
            System.out.println("j: " + j);
            System.out.println(s.substring(i,i+1));
            System.out.println(s.substring(j,j+1));
            //System.out.println(s.substring(i,i+1) != s.substring(j,j+1));
            if(!s.substring(i,i+1).equals(s.substring(j,j+1))){
                isPal = false;
                break;
            }
            i++;
            j--;
        }
        return isPal;
    }
    public static void main(String[] args) {
        String s = "abcbad";
        boolean isPal = checkPalindrome(s);
        System.out.println(isPal);
    }
}
