package com.practice.leek;

import java.util.LinkedList;

public class ImplementNodeLinkedList {
    static LinkedList<Integer>[] adj;
     static int V;
     static int E;

    public ImplementNodeLinkedList(int numNodes){
        this.adj = new LinkedList[numNodes];
        this.V = numNodes;
        this.E = 0;

        for (int i=0; i<numNodes; i++){
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        this.adj[u].add(v);
        this.adj[v].add(u);
        E++;
    }

    public static void main(String[] args) {
        ImplementNodeLinkedList g = new ImplementNodeLinkedList(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);

        System.out.println("Vertices: "+ V + " Edges: "+ E);

        for (int j = 0; j<4; j++){
            System.out.println("Node: "+ j + " Neighbours: "+ adj[j]);
        }
    }
}
