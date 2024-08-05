package com.practice.leek;

public class CountBinarySubstrings {
    public static int countBinarySubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '0' && c != '1') {
                return 0;
            }
        }

        int count = 0;
        int prev = 0;
        int current = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                current++;
            } else {
                count += Math.min(prev, current);
                prev = current;
                current = 1;
            }
        }

        // Add the last group comparison
        count += Math.min(prev, current);

        return count;
    }
    public static void main(String[] args) {
        String binaryString = "00110011";
        System.out.println("Count of substrings: " + countBinarySubstrings(binaryString));
    }
}
