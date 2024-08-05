package com.practice.leek;

import java.util.*;

public class MaxAverage {
    public static String solution(String [][]input){
        LinkedHashMap<String, List<Integer>> hashAvg = new LinkedHashMap<String, List<Integer>>();
        for (String[] s: input){
            if(!hashAvg.keySet().contains(s[0])){
                List<Integer> l = new ArrayList<>();
                l.add(Integer.parseInt(s[1]));
                l.add(1);
                hashAvg.put(s[0], l);
            }
            else{
                List<Integer> l2 = new ArrayList<>();
                List<Integer> value = hashAvg.get(s[0]);
                l2.add(value.get(0) + Integer.parseInt(s[1]));
                l2.add(value.get(1) + 1);
                hashAvg.put(s[0], l2);
            }
        }
        for(String s1: hashAvg.keySet()){
            System.out.println("Key: "+ s1 + " Value: "+ hashAvg.get(s1));
        }
        LinkedHashMap<String, Double> avgMap = new LinkedHashMap<>();
        for(String s1: hashAvg.keySet()){
            double valueToAdd = (hashAvg.get(s1).get(0))/(hashAvg.get(s1).get(1));
            avgMap.put(s1, valueToAdd);
        }
        for(String s1: avgMap.keySet()){
            System.out.println("Before reverse Key: "+ s1 + " Value: "+ avgMap.get(s1));
        }
        //avgMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
        String output = "";
        Double maxValue = 0.0;
        for(String s1: avgMap.keySet()){
            Double value = avgMap.get(s1);
            if(value>maxValue){
                output = s1;
                maxValue = value;
            }
        }


        for(String s1: avgMap.keySet()){
            System.out.println("Key avgMap: "+ s1 + " Value: "+ avgMap.get(s1));
        }
        //String output = avgMap.get(avgMap.keySet().toArray()[0]);
        //String output = avgMap.keySet().stream().findFirst().get();
        return output;
    }
    public static void main(String[] args) {
        //String binaryString = "00110011";
        //System.out.println("Count of substrings: " + countBinarySubstrings(binaryString));
        //System.out.println("Count of substrings: " + countBinarySubstrings(binaryString));
        String [][]input = {{"Rachel", "100"},{"Monica", "95"},{"Phoebe", "94"}, {"Rachel", "50"}, {"Phoebe", "95"}, {"Phoebe", "100"}};
        String s = solution(input);
        System.out.println("Best Avg: " + s);
    }
}
