package com.designPatternsLeetcode;

import java.util.HashMap;
import java.util.Map;

//find linges substring with unique elements
public class FindLongestSubStringSlidingWindow {
    public static int getMaxLength(String s){
        int n = s.length();
        char[] arr = s.toCharArray();
        int L = 0;
        int R = 0;
        Map<Character, Integer> hm = new HashMap<>();  //character, count
        int maxLen = 0;
        while(R<n){
            hm.put(arr[R], hm.getOrDefault(arr[R],0) +1);  //if exists in map, increment count, or add a count
            if(hm.size() != R-L+1){
                hm.put(arr[L], hm.get(arr[L]) - 1);
                if(hm.get(arr[L]) == 0){
                    hm.remove(arr[L]);
                }
                L++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
            R++;
        }
        return maxLen;

    }
    public static void main(String[] args) {
        //String s = "abcabcbb";
        String s = "abbcdef";
        int ans = getMaxLength(s);
        System.out.println(ans);
    }

}
