package com.practice.leek;

import java.util.*;

public class RandomisedSetImplemetation {
    List<Integer> arr = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    public RandomisedSetImplemetation() {
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            arr.add(val);
            map.put(val, arr.size() -1);
            return true;
        }
        else{
            return false;
        }
        /*if(arr.contains(val)){
            return false;
        }
        else{
            arr.add(val);
            return true;
        }*/

    }

    public boolean remove(int val) {
        if(map.containsKey(val)){  // Arra : [1,2] , remove 2
            int indexValuefromMap = map.get(val);  //2
            map.remove(val); //2,2
            if(indexValuefromMap != (arr.size()-1)){
                //System.out.println("Array: " + arr);
                //System.out.println("indexValuefromMap: "+ indexValuefromMap + " arr.size()-1: " + (arr.size()-1));
                Collections.swap(arr, indexValuefromMap, (arr.size()-1)); //arr, 1, 2
                arr.remove(arr.size()-1);  //remove 2 -- >  [1]
                map.put(arr.get(indexValuefromMap), indexValuefromMap);
            }
            else{
                arr.remove(arr.size()-1);
            }
            return true;
        }
        else{
            return false;
        }
        /*if(arr.contains(val)){
            arr.remove(Integer.valueOf(val));
            return true;
        }
        else{
            return false;
        }*/
    }

    public int getRandom() {
        Random r = new Random();
        int randomIndex = r.nextInt(arr.size());
        int value = arr.get(randomIndex);
        return value;
    }

    public void viewSet(){
       //System.out.println("------Set------");
        //for(int i: arr){
        System.out.println(arr);
        //}
        //System.out.println("------Set------");
    }
    public static void main(String[] args) {
        RandomisedSetImplemetation randomised = new RandomisedSetImplemetation();
        System.out.println(randomised.insert(1));
        System.out.println(randomised.insert(2));
        System.out.println(randomised.insert(1));
        System.out.println(randomised.insert(5));
        randomised.viewSet();
        System.out.println(randomised.remove(2));
        System.out.println(randomised.remove(1));
        System.out.println(randomised.insert(4));
        System.out.println("Random Element: "+ randomised.getRandom());
        randomised.viewSet();

    }

}
