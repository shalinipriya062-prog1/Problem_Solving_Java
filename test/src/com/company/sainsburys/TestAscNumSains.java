package com.company.sainsburys;

import java.util.ArrayList;
import java.util.List;

public class TestAscNumSains {

    public static void main(String[] args) {
        int numDigits = 2; // Change this value to generate numbers with a different number of digits
        //String output = "";
        String output = run(numDigits);
        System.out.println(output);
    }

    public static String run(int numDigits) {
        List<String> digitList = new ArrayList<>();
        getAllAscNum("", 0, numDigits, digitList);
        System.out.println(digitList);
        String output = String.join(",",digitList);
        return output;
    }

    private static void getAllAscNum(String current, int startDigit, int numDigits, List<String> digitList) {
        if (current.length() == numDigits) {
            if(!current.startsWith("0"))
                //System.out.println(current);
                digitList.add(current);
                return;
        }

        for (int i = startDigit; i <= 9; i++) {
            getAllAscNum(current + i, i, numDigits, digitList);
        }
    }
}
