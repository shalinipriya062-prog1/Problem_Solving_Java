package com.hsbc;

import java.util.Arrays;

public class MostWaterContainer {
    public static int maxArea(int[] height){

        int indexLeft = 0;
        int indexRight = height.length - 1;
        int maxValue = 0;

        while(indexLeft!=indexRight){
            int areaVal = Math.min(height[indexLeft], height[indexRight]) * Math.abs(indexLeft - indexRight);
            if(areaVal > maxValue){
                maxValue = areaVal;
            }
            if(height[indexLeft] <= height[indexRight]){
                indexLeft++;
            }
            else{
                indexRight--;
            }
        }
        return maxValue;
    }

    public static void main(String[] args){
        System.out.println();
        int[] height = {1,8,6,2,5,4,8,3,7};
        //int[] height = {4,2,0,3,2,5};
        int output = maxArea(height);
        //System.out.println(" ");
        System.out.println(output);
    }
}
