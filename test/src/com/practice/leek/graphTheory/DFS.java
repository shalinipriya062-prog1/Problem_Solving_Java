package com.practice.leek.graphTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {

     static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int d){
         adj.get(s).add(d);
         adj.get(d).add(s);

    }
    public static int countComponents(int V, int[][] edges) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges){
            addEdge(adj, edge[0], edge[1]);
        }
        System.out.println(adj);
        int components = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs12(i, adj, ans, vis);
                components++;
            }
        }
        System.out.println(ans);
        return components;
    }

    public static void dfs12(int x, ArrayList<ArrayList<Integer>> adj, List<Integer> ans, boolean[] vis){
        vis[x] = true;
        ans.add(x);
        //System.out.println(ans);
        for(Integer neighbour: adj.get(x)){
            if(!vis[neighbour]){
                dfs12(neighbour, adj, ans, vis);
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0,1},{1,2},{3,4}};
        int comp = countComponents(V,edges);
        System.out.println("Components: " + comp);
    }
}
