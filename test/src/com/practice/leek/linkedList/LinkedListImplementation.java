package com.practice.leek.linkedList;

public class LinkedListImplementation {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    public void printLL(){
        Node current  =  head;
        while (current!=null){
            System.out.print(current.data + "--->");
            current = current.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        LinkedListImplementation linkedList = new LinkedListImplementation();
        linkedList.head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        linkedList.head.next = two;
        two.next = three;
        linkedList.printLL();
    }

}
