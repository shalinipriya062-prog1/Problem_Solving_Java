package com.practice;
/*
* Get Score based on Letter provided
* */
public class Test1 {
    public static void main(String[] args) {
        String erica = "EHH";
        String bob = "EME";
        String[] e_arr = erica.split("");
        /*for (String i: e_arr) {
            System.out.println(i);
        }*/
        String[] b_arr = bob.split("");
        int e_score = getScore(e_arr);
        int b_score = getScore(b_arr);

        String winner = e_score>b_score?"Erica":"Bob";
        System.out.println(winner);

    }

    public static int getScore(String[] a){
        int score = 0;
        for (String i: a) {
            switch (i) {
                case "E":
                    score = score + 1;
                    break;
                case "M":
                    score = score + 2;
                    break;
                case "H":
                    score = score + 3;
                    break;
            }
        }
        return score;
    }
}
