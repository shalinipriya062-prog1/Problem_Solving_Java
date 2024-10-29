package com.designPatternsLeetcode;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowLongestSubstringWithAtleastKRepeatingCharacters {

    public static int getMaxLength(String s){
        int n = s.length();
        char[] arr = s.toCharArray();
        int L = 0;
        int R = 0;
        Map<Character, Integer> hm = new HashMap<>();
        int maxLen = 0;
        while(R<n){
            hm.put(arr[L], hm.getOrDefault(arr[L], 0) +1);
            //if()
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        int ans = getMaxLength(s);
        System.out.println(ans);
    }
}
