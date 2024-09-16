package com.company.deutsche;

import java.util.List;

public class MinOperation1827 {
    public static int minOperations(int[] nums) {
        int output = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                while (nums[i] <= nums[i - 1]) {
                    nums[i]++;
                    output++;
                }
            }
        }
        return output;
    }
    public static void main(String[] args){
        System.out.println();
        int[] nums = {1,5,2,4,1};
        int output = minOperations(nums);
        //System.out.println(" ");
        System.out.println(output);
    }

}
