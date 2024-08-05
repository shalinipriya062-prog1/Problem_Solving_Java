package com.practice.leek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomInterval {
    public static List<List<Integer>> arrangeInterval(Integer [][]l ){
        List<List<Integer>> output = new ArrayList<>();

        List<Integer> first = new ArrayList<>();
        for(Integer []each: l){
            first.add(each[0]);
        }
        Collections.sort(first);

        for(Integer eachFirst: first){
            for(Integer []each: l) {
                Integer start = each[0];
                Integer end = each[1];
                if (eachFirst == each[0]) {
                    output.add(new ArrayList<>(Arrays.asList(each)));
                }
            }
        }

        /*Collections.sort(first);
        for(Integer i: first){
            System.out.println(i);
        }



        for(Integer j: first){
            for(Integer []each: l){
                if(j==each[0]){
                    List<Integer> listToAdd = new ArrayList<>();
                    listToAdd.add(j);
                    listToAdd.add(each[1]);
                    output.add(listToAdd);
                }
            }

        }*/
        return output;

    }

    public static void main(String[] args) {
        Integer [][]l = {{5,7},{15,29},{7,9},{1,5},{12,15},{29,34},{9,12}};
        List<List<Integer>> l1 = arrangeInterval(l);
        for (List<Integer> x: l1){
            System.out.println(x);
        }
    }
}
