package com.practice1;

import java.util.Locale;

public class PalindromeCheck {
    public static void main(String[] args) {
        String s = "madam";
        String s1 = s.trim().toLowerCase();
        StringBuilder sb = new StringBuilder(s1);
        StringBuilder sb_reverse = sb.reverse();
        if (sb_reverse.toString().equals(sb.toString())) {
            System.out.println("Palindrome!");
        }
        else
            System.out.println("Not a Palindrome!");
    }
}
