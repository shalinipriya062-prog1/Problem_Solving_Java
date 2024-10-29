package com.practice.leek.graphTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSorting {
    public static void addEdges(ArrayList<ArrayList<Integer>> adj, int s, int d){
        adj.get(s).add(d);
    }

    public static int[] topoSort(int[][] edges, int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        //boolean output = false;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            System.out.println("edge[0]: " + edges[i][0] + " edge[1]: " + edges[i][1]);
            addEdges(adj, edges[i][0], edges[i][1]);
        }
        System.out.println(adj);
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                dfs(i, adj, vis, stack);
            }
        }
        //System.out.println(stack);
        int[] output = new int[V];
        for (int i = 0; i < V; i++) {
            output[i] = stack.pop();
        }
        return output;
    }

    public static void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack){
        vis[v] = true;
        for (Integer neighbour: adj.get(v)){
            if(!vis[neighbour]){
                dfs(neighbour, adj, vis, stack);
            }
        }
        stack.push(v);
    }

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {{0,3},{0,2},{2,3},{3,1},{2,1},{1,4},{5,1},{5,4}};
        int[] ans = topoSort(edges, V);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
