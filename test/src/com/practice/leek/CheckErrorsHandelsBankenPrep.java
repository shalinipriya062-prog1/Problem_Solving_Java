package com.practice.leek;

public class CheckErrorsHandelsBankenPrep {
    public static int find_max(int[] arr) {
        int max_val = arr[0];
        for (int i = 0; i <arr.length-1; i++) {
            if(arr[i] > max_val)
                max_val = arr[i];
        }
        return max_val;
    }
    public static boolean isEven(int num){
        return num % 2 == 0 ? true : false;
    }

    public static void swapNumbers(int a, int b){
        b = a + b;
        a = Math.abs(a - b);
        b = Math.abs(b - a);
        System.out.println("a: "+ a);
        System.out.println("b: "+ b);
    }
    public static void main(String[] args) {
        int[] arr = {1,3,8,2,7,4};
        int ans = find_max(arr);
        //System.out.println(ans);
        //System.out.println(isEven(0));
        swapNumbers(4,5);
        swapNumbers(4,2);
    }
}
