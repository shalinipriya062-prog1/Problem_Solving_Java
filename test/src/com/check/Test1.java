package com.check;

import java.awt.*;

public class Test1 {
    private static Test1 test1;


    private Test1(){

    }

    public synchronized static Test1 getInstance(){
        //synchronized (Test1.class) {
            if (test1 == null) {
                test1 = new Test1();
            }
            return test1;
        //}
    }

    private static void main(String[] args){
        Test1 test1 = getInstance();
        //System.out.println(te);
        Test1 test2 = getInstance();
        if(test1==test2){
            System.out.println("Equal");
        }
    }
}

