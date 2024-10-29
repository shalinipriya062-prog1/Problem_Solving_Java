package com.practice.leek.graphTheory;

import java.util.ArrayList;
import java.util.List;

public class RedundantConnection {
    public static int[] findRedundantConnection(int[][] edges) {
        List<Integer> uniSet = new ArrayList<>();
        int[] ans = new int[2];
        for (int[] edge: edges){
            if(uniSet.contains(edge[0]) && !uniSet.contains(edge[1])){
                uniSet.add(edge[1]);
            }
            else if(!uniSet.contains(edge[0]) && uniSet.contains(edge[1])){
                uniSet.add(edge[0]);
            }
            else if(!uniSet.contains(edge[0]) && !uniSet.contains(edge[1])){
                uniSet.add(edge[0]);
                uniSet.add(edge[1]);
            }
            else if(uniSet.contains(edge[0]) && uniSet.contains(edge[1])){
                ans[0] = edge[0];
                ans[1] = edge[1];
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int V = 5;
        //int[][] edges = {{1,2},{1,3},{2,3}};
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        //[[1,2],[2,3],[3,4],[1,4],[1,5]]
        int[] ans = findRedundantConnection(edges);
        System.out.println("Components: " + ans[0] + " " + ans[1]);
    }
}
