package com.practice.leek;

public class RainWaterTrapping {

    public static int maxArea(int[] height){
        int[] left = new int[height.length];
        int[] right = new int[height.length];


        int maxHeightLeft = height[0];
        int maxHeightRight = height[height.length - 1];

        for (int i = 0; i < height.length; i++) {
            left[i] = Math.max(maxHeightLeft, height[i]);
            if(left[i] > maxHeightLeft){
                maxHeightLeft = left[i];
            }
        }

        for (int i = height.length-1; i >= 0; i--) {
            right[i] = Math.max(maxHeightRight, height[i]);
            if(right[i] > maxHeightRight){
                maxHeightRight = right[i];
            }
        }
       /* for (int i = 0; i < height.length; i++) {
            System.out.print(left[i] + " ");

        }
        System.out.println("");
        for (int i = 0; i < height.length; i++) {

            System.out.print(right[i] + " ");
        }*/


        int output = 0;
        for (int i = 0; i < height.length; i++) {
            int savedLevel = Math.min(left[i], right[i]) ;  // - height[i]
            output = output + savedLevel;
        }
        return output;
    }

    public static void main(String[] args){
        System.out.println();
        int[] height = {1,8,6,2,4,8,3,7};
        //int[] height = {4,2,0,3,2,5};
        int output = maxArea(height);
        //System.out.println(" ");
        System.out.println(output);
    }
}

