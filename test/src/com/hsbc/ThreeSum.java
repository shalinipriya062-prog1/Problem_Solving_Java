package com.hsbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.HashSet;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> output = new HashSet<List<Integer>>();
            for (int i = 0; i < nums.length -2; i++) {
                int left = i+1;
                int right = nums.length - 1;
                while(left<right){
                    int sumVal =  nums[left] + nums[right] + nums[i];
                    if(sumVal==0){
                        output.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                    }
                    else if(sumVal<0){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
            return new ArrayList<>(output);
    }

    public static void main(String[] args){
        System.out.println();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> output = threeSum(nums);
        //System.out.println(" ");
        System.out.println(output);
    }
}
