package com.practice.leek.graphTheory;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class RedundantConnection1 {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int d){
        adj.get(s-1).add(d);
        adj.get(d-1).add(s);

    }

    public static int[] findRedundantConnection(int[][] edges) {
        Set<Integer> setV = new HashSet<Integer>();
        int[] output = new int[2];
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                setV.add(edges[i][j]);
            }
        }
        int V = setV.size();
        //System.out.println(V);
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        //int count = 0;
        for (int[] edge: edges){
            addEdge(adj, edge[0], edge[1]);
            //count++;
        }
        System.out.println(adj);

        /*boolean ans = false;
        for (int i = 0; i < V; i++){
            if(!vis[i] && !ans){
                ans = dfs(i+1, adj, vis, output, -1);
            }
        }*/
        dfs(edges[0][0], adj, vis, output, -1);
        return output;
    }

    public static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] output, int parent){
        int v1 = v - 1;
        vis[v1] = true;
        System.out.println(" v: " + v);
        for (Integer neighbour: adj.get(v1)){
            System.out.println("Neighbour: " + neighbour);
            //System.out.println("vis[neighbour]: " + vis[neighbour]);
            if (!vis[neighbour -1]){
                if(dfs(neighbour, adj, vis, output, v)) {
                    return true;
                }
            }
            else if(neighbour != parent){
                System.out.println("Parent: " + parent + " v: " + v + " neighbour: " +neighbour);
                output[0] = neighbour;
                output[1] = v;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //int V = 5;
        int[][] edges = {{1,2},{1,3},{2,3}};
        //int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] ans = findRedundantConnection(edges);
        System.out.println("output: " + ans[0] + " " + ans[1]);
    }
}
