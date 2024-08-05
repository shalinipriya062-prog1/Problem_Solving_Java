package com.practice.leek;

public class SumOfTwo {
    public static void main(String[] args) {
        //int[] nums = {2,7,11,15};
        int[] nums = {3,3};
        //int target = 9;
        int target = 6;
        int[] output = new int[2];
        for(int i=0; i<=nums.length; i++){
            for(int j=i+1; j<=nums.length-1; j++){
                if((nums[i] + nums[j])==target){
                    output[0] = i;
                    output[1] = j;
                }
            }
        }
        for(int a: output){
            System.out.println(a);
        }

    }
}
