package com.practice.leek;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class TestCloneNode {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneUtil(Node node, HashMap<Node, Node> mp){
        Node newNode = new Node(node.val);
        mp.put(node, newNode);
        //add newghbours
        for (Node neigh: node.neighbors){
            if(!mp.containsKey(neigh)){
                newNode.neighbors.add(cloneUtil(neigh, mp));
            }
            else{
                newNode.neighbors.add(mp.get(neigh));
            }
        }
        return newNode;
    }

    public static void main(String[] args) {
        HashMap<Node, Node> mp = new HashMap<>();
       // Node node1 = new Node();
       // Node node = new Node(1,[new Node()])

    }


}
