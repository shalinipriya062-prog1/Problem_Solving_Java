package com.practice.leek;

public class Stack {

    int[] stack = new int[5];
    int top = 0;
    //int size = 0;

    public void push(int data){
        stack[top] = data;
        top = top + 1;
        //size = size + 1;
    }

    public int pop(){
        int data = stack[top];
        top--;
        stack[top] = 0;
        return data;
    }

    public int peek(){
        int data = stack[top - 1];
        //top--;
        //stack[top] = 0;
        return data;
    }

    public void show(){
        for (int i : stack) {
            System.out.println(i + " ");
        }
        //for(int i : queue){
        //}
    }
    public static void main(String[] args) {
        Stack stack1 = new Stack();
        stack1.push(2);
        stack1.push(5);
        stack1.push(9);
        stack1.push(3);
        stack1.show();
        System.out.println("After deletion: ");
        stack1.pop();
        stack1.pop();
        stack1.show();
        System.out.println("After peek: ");
        System.out.println(stack1.peek());
    }
}
