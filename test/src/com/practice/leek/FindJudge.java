package com.practice.leek;
import java.util.ArrayList;
import java.util.List;

public class FindJudge {

    public static int findJudge(int n, int[][] trust){

        int[] count = new int[n+1];
        for(int[] t: trust){
            count[t[0]] --;
            count[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if(count[i]== n-1){
                return i;
            }
        }
        return -1;
        /*int judge = -1;
        boolean isNoDependent = false;
        List<Integer> from = new ArrayList<>();
        List<Integer> to = new ArrayList<>();
        for(int[] i: trust){
            from.add(i[0]);
            to.add(i[1]);
        }
        for(int j : to){
            if(!from.contains(j)){
                isNoDependent = true;
                //judge = j;
            }
        }
        for (int fromI = 0; fromI<=from.size(); fromI++) {
            for( int toI: to){
                if(from.get(fromI))
            }
        }

        if(Integer.valueOf(judge)== -1){
            return -1;
        }
        else{
            return judge;
        }*/
    }

    public static void main(String[] args) {
        //int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int[][] trust = {{1,2},{2,3}};
        int op = findJudge(3, trust);
        System.out.println(op);

    }
}
