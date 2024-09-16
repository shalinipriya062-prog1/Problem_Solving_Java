package com.practice.leek.linkedList;

public class AddNode {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    public void printLL(){
        Node current  =  head;
        while (current!=null){
            System.out.print(current.data + "--->");
            current = current.next;
        }
        System.out.print("null");
    }

    Node head = null;
    Node tail = null;
    public void addNode(int newData){
        Node newNode = new Node(newData);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public static void main(String[] args) {
        AddNode linkedList1 = new AddNode();
        /*linkedList1.head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        linkedList1.head.next = two;
        two.next = three;
        linkedList1.printLL();*/

        linkedList1.addNode(5);
        linkedList1.addNode(6);
        linkedList1.addNode(7);
        linkedList1.printLL();

    }
}
