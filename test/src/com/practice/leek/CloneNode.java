package com.practice.leek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CloneNode {
    // Definition for a Node.
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

    class Solution {
        private Node cloneUtil(Node node, HashMap<Node, Node> mp) {
            Node newNode =new Node(node.val);
            mp.put(node, newNode);
            for(Node neighbour: node.neighbors) {
                if (!mp.containsKey(neighbour)){
                    newNode.neighbors.add(cloneUtil(neighbour, mp));
                }
                else{
                    newNode.neighbors.add(mp.get(neighbour));
                }
            }
            return newNode;

        }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> mp = new HashMap<>();
        return cloneUtil(node, mp);
        }
    }
    public static void main(String[] args) {

        //Node n = cloneGraph(new Node(1, ArrayList[2,3]));
    }
}
