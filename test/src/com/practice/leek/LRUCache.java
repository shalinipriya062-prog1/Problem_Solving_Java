package com.practice.leek;


import java.io.*;
import java.util.*;


public class LRUCache {
    /*
     * Click `Run` to execute the snippet below!
     */

/*
 * Design a data structure that implements a Least Recently Used (LRU) cache. Implement the LRUCache class:

- LRUCache(capacity)    //Initialize the LRU cache with positive size capacity.
- value get(key)        //Return the value of the key if the key exists, otherwise return null
- void put(key, value)  //Update the value of the key if the key exists.
                        //Otherwise, add the key-value pair to the cache, taking into account the LRU principle.
 */

        static class Solution {
            LinkedHashMap<Integer, String> cache = new LinkedHashMap<Integer, String>();
            int capacity;
            List<Integer> keyStack = new ArrayList<>();

            Solution(int capacity) {
                this.capacity = capacity;
            }

            public String get(Integer key) {
                if (cache.containsKey(key)) {
                    keyStack.remove(key);
                    keyStack.add(key);
                    return cache.get(key);
                } else {
                    return null;
                }
            }

            public void put(Integer key, String value) {
                if (cache.size() < capacity) {
                    cache.put(key, value);
                    keyStack.add(key);
                } else {
                    Integer toRemove = keyStack.get(0);
                    keyStack.remove(toRemove);
                    cache.remove(toRemove);
                    cache.put(key, value);

                    keyStack.add(key);
                }
            }
        }

        public static void main(String[] args) {
            Solution lRUCache = new Solution(2);
            lRUCache.put(1, "A");                // cache is {1="A"}
            System.out.println(lRUCache.get(1)); // return "A"
            lRUCache.put(2,"B");                 // cache is {1="A", 2="B"}
            lRUCache.put(3,"D");                 // LRU key was 1, cache is {2="B", 3="D"}
            System.out.println(lRUCache.get(2)); // returns "B"
            lRUCache.put(10,"SOMETHING");        // LRU key was 3, cache is {2="B", 10="SOMETHING"}
            System.out.println(lRUCache.get(3)); // returns null
            System.out.println(lRUCache.get(2)); // returns "B"
            System.out.println(lRUCache.get(10));// returns "SOMETHING"
            lRUCache.put(2, "P");                // Replacing key, cache is {2="P", 10="SOMETHING"}
            lRUCache.put(3,"G");                 // LRU key was 10, cache is {2="P", 3="G"}
            System.out.println(lRUCache.get(10));// returns null
            System.out.println(lRUCache.get(2)); // returns "P"
            System.out.println(lRUCache.get(3)); // returns "G"

    /*ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }*/
        }
    }
