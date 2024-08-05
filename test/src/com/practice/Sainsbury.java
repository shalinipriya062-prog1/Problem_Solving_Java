package com.practice;

import java.util.ArrayList;
import java.util.List;

public class Sainsbury {

    public static String run(int input) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */
        String result = generateAscendingNumbers(input);
        //System.out.println(result);;
        return result;
    }

    public static String generateAscendingNumbers(int numDigits) {
        List<String> results = new ArrayList<>();
        generateAscendingNumbers("", 1, numDigits, results);
        return String.join(",", results);
    }

    public static void generateAscendingNumbers(String current, int startDigit, int numDigits, List<String> results) {

        if (current.length() == numDigits) {
            results.add(current);
            return;
        }
        for (int i = startDigit; i <= 9; i++) {
            generateAscendingNumbers(current + i, i, numDigits, results);
        }
    }
}
