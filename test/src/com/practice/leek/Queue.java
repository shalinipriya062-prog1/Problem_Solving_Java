package com.practice.leek;

import java.util.Arrays;
import java.util.function.DoubleToIntFunction;
import java.util.stream.IntStream;


public class Queue {
    int[] queue = new int[5];
    int front = 0;
    int rear = 0;
    int size = 0;

    public void enqueue(int data){
        queue[rear] = data;
        rear = rear + 1;
        size = size + 1;
    }

    public int deQueue(){
        int data = queue[front];
        //int[] temp = IntStream.range(front +1, queue.length -1).map(i -> queue[i]).toArray();
        //queue = temp;
        front++;
        size = size - 1;
        //rear = rear - 1;
        return data;
    }
    public void show(){
        for (int i = 0; i < size; i++) {
            System.out.println(queue[i] + " ");
        }
        //for(int i : queue){
        //}
    }
    public static void main(String[] args) {
        Queue queue1 = new Queue();
        queue1.enqueue(2);
        queue1.enqueue(5);
        queue1.enqueue(9);
        queue1.enqueue(3);
        queue1.show();
        System.out.println("After deletion: ");
        queue1.deQueue();
        queue1.deQueue();
        queue1.show();
    }
}
