package com.practice.leek;

public class Chalker {

    public static int getChalker(int[] c, int k){
        int currentSize = k;
        int indexReturn = 0;
        while (currentSize>0) {
            for (int i = 0; i < c.length; i++) {
                System.out.println("----------Index: " + i);
                System.out.println("----------Current Size Input  - c[i]: " + currentSize + "-" + c[i]);
                currentSize = currentSize - c[i];
                System.out.println("----------Current Size Input " + currentSize);

                if(currentSize==0){
                    if(i == c.length-1){
                        indexReturn = 0;
                        break;
                    }
                    else {
                        indexReturn = i+1;
                        break;
                    }

                } else if (currentSize<0) {
                    System.out.println("in else if");
                    indexReturn = i;
                    break;
                }
            }
        }
        return indexReturn;
    }

    public static void main(String[] args){
        int[] c = {3,4,1,2};
                //{5,1,5};
        int k = 25;
                //22;
        int result = getChalker(c, k);
        System.out.println(result);

    }
}
