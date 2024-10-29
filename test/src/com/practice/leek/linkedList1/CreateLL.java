package com.practice.leek.linkedList1;

public class CreateLL {

    static class Node{
        int data;
        Node next;
        Node(int date){
            this.data = data;
        }
    }

    public static void traverse(Node head){
        Node cur = head;
        while(cur!=null){
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        CreateLL linkedList = new CreateLL();
        Node n1  = new Node(10);
        Node n2  = new Node(20);
        Node n3  = new Node(30);
        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        traverse(head);

    }
}
