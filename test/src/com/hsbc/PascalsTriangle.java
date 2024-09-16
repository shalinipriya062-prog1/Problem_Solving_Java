package com.hsbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> eachLevel = new ArrayList<>();
            eachLevel.add(1);
            for (int j = 2; j <= i; j++) {
                List<Integer> lastLevel = output.get(i - 1);
                int sumPascal = lastLevel.get(j-2) + lastLevel.get(j-1);
                eachLevel.add(sumPascal);
            }
            if (i>=1) {
                eachLevel.add(1);
            }
            output.add(eachLevel);
        }
        return output;
    }

    public static void main(String[] args){
        System.out.println();
        int numRows = 5;
        List<List<Integer>> output = generate(numRows);
        //System.out.println(" ");
        System.out.println(output);
    }

}
