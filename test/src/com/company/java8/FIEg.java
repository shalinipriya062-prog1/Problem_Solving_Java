package com.company.java8;

public class FIEg {
    public interface FunctionalInterfaceEg1 {
        void show(int i);
    }

    //public class TestFI {
    public static void main(String[] args) {
        FunctionalInterfaceEg1 a = i -> System.out.println("Run Functional Interface: " + i);
        a.show(5);
        /*A a = new A() {
            public void show() {
                System.out.println("Run Functional Interface");
            }
        };*/
        }
    //}
}
