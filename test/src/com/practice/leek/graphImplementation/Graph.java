package com.practice.leek.graphImplementation;

import java.util.ArrayList;

public class Graph{
        ArrayList<Node> nodes;
        int[][] adj;

        Graph(int size){
            adj = new int[size][size];
            nodes = new ArrayList<>();
        }

        public void addNode(Node node){
            nodes.add(node);
        }

        public void addEdge(int src, int dst){
            adj[src][dst] = 1;
        }

        public boolean checkEdge(int src, int dst){
            return adj[src][dst] == 1? true: false;
        }

        public void printGraph(){
            System.out.print("  ");
            for(Node n: nodes){
                System.out.print(n.data + " ");
            }
            System.out.println();
            for (int i = 0; i < adj.length; i++) {
                System.out.print(nodes.get(i).data + " ");
                for (int j = 0; j < adj[i].length; j++) {
                    System.out.print(adj[i][j] + " ");
                }
                System.out.print("\n");
            }
        }

        public void depthFirstSearch(int src){
            boolean[] visited = new boolean[adj.length];
            dfsHelper(src,visited);

        }

    private void dfsHelper(int src, boolean[] visited) {
            if(visited[src]){
                return;
            }
            else{
                visited[src] = true;
                System.out.println(nodes.get(src).data + " = visited");

                for (int i = 0; i < adj[src].length; i++) {
                    if(adj[src][i]==1){
                        dfsHelper(i, visited);
                    }
                }
            }

    }
}