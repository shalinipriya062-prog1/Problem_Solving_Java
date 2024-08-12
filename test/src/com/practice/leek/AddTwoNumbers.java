package com.practice.leek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static List<Integer> addTwoNumbers(List<Integer> arrl1, List<Integer> arrl2) {
    //public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //List<Integer> arrl1 = new ArrayList<>();
        //List<Integer> arrl2 = new ArrayList<>();
        /*while(l1.next != null){
            arrl1.add(l1.val );
        }
        while(l2.next != null){
            arrl2.add(l1.val);
        }*/
        int size = arrl1.size() > arrl2.size() ? arrl1.size():arrl2.size();
        List<Integer> output = new ArrayList<>();
        int carryOver = 0;
        for (int i = 0; i <size+1 ; i++) {
            int value1;
            int value2;
            try{
                value1 = arrl1.get(i);
            }
            catch (IndexOutOfBoundsException e){
                value1 = 0;
            }
            try{
                value2 = arrl2.get(i);
            }
            catch (IndexOutOfBoundsException e){
                value2 = 0;
            }
            System.out.println("Value 1: "+ value1 + " Value 2: " + value2 + " Carry over: " + carryOver);
            Integer sumArr = value1 + value2 + carryOver;
            System.out.println("Sum Arr: "+ sumArr);
            if(sumArr.toString().length() >1){
                output.add(Math.abs(sumArr) % 10);
                carryOver = Math.abs(sumArr) / 10;
            }
            else{
                output.add(sumArr);
                carryOver = 0;
            }
        }

        //System.out.println("Output");
        for(int j: output){
            System.out.println(j);
        }
        return output;
    }

        public static void main(String[] args) {
            List<Integer> arrl1 = new ArrayList<>();
            List<Integer> arrl2 = new ArrayList<>();
            arrl1.add(2);
            arrl1.add(4);
            arrl1.add(3);
            arrl2.add(5);
            arrl2.add(6);
            arrl2.add(4);
        //addTwoNumbers(arrl1, arrl2);

            List<Integer> arrl3 = new ArrayList<>(Arrays.asList(9,9,9,9,9,9,9));
            List<Integer> arrl4 = new ArrayList<>(Arrays.asList(9,9,9,9));
            addTwoNumbers(arrl3, arrl4);

    }
}
