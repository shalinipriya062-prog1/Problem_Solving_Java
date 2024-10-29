package com.practice.leek.graphTheory;

import java.util.ArrayList;

public class DirectedCycle {

    public static void addEdges(ArrayList<ArrayList<Integer>> adj, int s, int d){
        adj.get(s).add(d);
    }

    public static boolean topoSort(int[][] edges, int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        boolean output = false;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            System.out.println("edge[0]: " + edges[i][0] + " edge[1]: " + edges[i][1]);
            addEdges(adj, edges[i][0], edges[i][1]);
        }
        System.out.println(adj);
        boolean[] vis = new boolean[V];
        boolean[] recS = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                if(dfs(i, adj, vis, recS)) output = true;
            }
        }
        return output;
    }

    public static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] recS){
        vis[v] = true;
        recS[v] = true;
        for (Integer neighbour: adj.get(v)){
            if(!vis[neighbour]){
                if(dfs(neighbour, adj, vis, recS))
                    return true;
            }
            else if(recS[neighbour]){
                return true;
            }
        }
        recS[v] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {{0,3},{0,2},{2,3},{3,1},{2,1},{1,4},{5,1},{5,4}};
        boolean ans = topoSort(edges, V);
        System.out.println(ans);
        //System.out.println("output: " + ans[0] + " " + ans[1]);
    }
}
