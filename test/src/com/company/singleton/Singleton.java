package com.company.singleton;

public class Singleton {
    private static Singleton singleton;    //private static Singleton attribute

    private Singleton(){  //private default constructor

    }

    public static Singleton getInstance(){  //method to create single instance
        if(singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
