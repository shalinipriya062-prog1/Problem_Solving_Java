package com.practice.leek;

import java.util.*;
import java.util.stream.Collectors;

public class MergeArray {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 3, 0, 0, 0};
        int m = 4;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        //List<Integer> numsList1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        //List<Integer> numsList2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        /*List<Integer> numsList1 = new ArrayList<>();

        for (int j : nums1) {
            if (j != 0) {
                numsList1.add(j);
            }
        }*/
        List<Integer> numsList1 = new ArrayList<>();
                //Arrays.stream(nums1).boxed().collect(Collectors.toList());
        for (int i = 0; i <m ; i++) {
            numsList1.add(nums1[i]);
        }
        /*int checkNonZeroNum1 = 0;
        for (int i = nums1.length-1; i >=0 ; i--) {
            if(nums1[i] != 0){
                checkNonZeroNum1 = 1;
                numsList1.add(nums1[i]);
            }
            else{
                if(checkNonZeroNum1 == 1){
                    numsList1.add(nums1[i]);
                }
            }
        }*/
        //numsList1 = numsList1.stream().filter(l -> l.intValue()!=0).collect(Collectors.toList());

        List<Integer> numsList2 = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            numsList2.add(nums2[i]);
        }
        /*int checkNonZeroNum2 = 0;
        for (int i = nums2.length-1; i >=0 ; i--) {
            if(nums2[i] != 0){
                checkNonZeroNum2 = 1;
                numsList2.add(nums2[i]);
            }
            else{
                if(checkNonZeroNum2 == 1){
                    numsList2.add(nums2[i]);
                }
            }
        }*/
                //Arrays.stream(nums2).boxed().collect(Collectors.toList());
        //numsList2 = numsList2.stream().filter(l -> l.intValue()!=0).collect(Collectors.toList());
        numsList1.addAll(numsList2);
        Collections.sort(numsList1);

        //nums1 = new int[numsList1.size()];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = numsList1.get(i);
        }
        for(int i: nums1){
            System.out.println(i);
        }
        /*int[] output = new int[numsList1.size()];
        for (int i = 0; i < numsList1.size(); i++) {
            output[i] = numsList1.get(i);
        }
        System.out.println(numsList1);
        for(int i: output){
            System.out.println(i);
        }*/

        Map<String, String> books = new HashMap<>();
        books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");
        books.put("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
        books.put("978-0134685991", "Effective Java");

        List<String> titles = books.values().stream().filter(l -> l.equals("Effective Java")).collect(Collectors.toList());
        //System.out.println(titles);
        List<String> titles1 = books.entrySet().stream().filter(l -> l.getKey().startsWith("978-16")).map(Map.Entry::getValue).collect(Collectors.toList());
        //System.out.println(titles1);



        //System.out.println(numsList11);

    }
}
