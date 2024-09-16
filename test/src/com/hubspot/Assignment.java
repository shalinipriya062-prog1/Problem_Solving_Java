package com.hubspot;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Assignment {

    public static String mostFrequentlyOccurringSubstring(String input, int maxValue){
        if(input.equals("") || input == null){return "";}
        if(maxValue>input.length()){return "";}
        if(maxValue< input.length() && maxValue>0) {
            HashMap<String, Integer> frequency = new HashMap<>();

            Integer maxFreq = 0;
            String maxFreqToken = "";
            for (int i = 0; i < input.length() - maxValue + 1; i++) {
                String tokentoCheck = input.substring(i, i + maxValue);
                if (frequency.containsKey(tokentoCheck)) {
                    frequency.put(tokentoCheck, frequency.get(tokentoCheck) + 1);
                    if (maxFreq < frequency.get(tokentoCheck)) {
                        maxFreq = frequency.get(tokentoCheck);
                        maxFreqToken = tokentoCheck;
                    }
                } else {
                    frequency.put(tokentoCheck, 1);
                    if (maxFreq == 0) {
                        maxFreqToken = tokentoCheck;
                    }
                }

            }
            List<String> sameFreqToken =  new ArrayList<>();
            for (String key: frequency.keySet()){
                if(frequency.get(key) == maxFreq){
                    sameFreqToken.add(key);
                }
            }
            Collections.sort(sameFreqToken);
            for (String str: sameFreqToken) {
                System.out.println(str);
            }
            maxFreqToken = sameFreqToken.get(sameFreqToken.size()-1);

        /*for (String token: tokens){
            if(frequency.containsKey(token)){
                frequency.put(token, frequency.get(token) +1);
                if(maxFreq < frequency.get(token)){
                    maxFreq = frequency.get(token);
                    maxFreqToken = token;
                }
            }
            else{
                frequency.put(token, 1);
                if(maxFreq == 0){
                    maxFreqToken = token;
                }
            }
        }*/

            return maxFreqToken;
        }
        return "";
    }

    public static void main(String[] args){
        //String output = mostFrequentlyOccurringSubstring("inengineering", 2);
        //String output = mostFrequentlyOccurringSubstring("abcd", 2);
        String output = mostFrequentlyOccurringSubstring("engineering", 2);
        System.out.println("Max Frequency token: " + output);
    }
}
