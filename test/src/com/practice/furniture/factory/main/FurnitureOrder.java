package com.practice.furniture.factory.main;

import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface{
    private HashMap<Furniture, Integer> order;

    public FurnitureOrder(){
        order = new HashMap<Furniture, Integer>();
    }

    public HashMap<Furniture, Integer> getOrderedFurniture(){
        //return new HashMap<Furniture,Integer>(order);
        return order;
    }
    public void addToOrder(Furniture type, int count){
        int quantity = 0;
        if(order.containsKey(type)){
            quantity = order.get(type);   //Get the quantity already present in order key: Furniture(Chair/Table/Couch , value: Integer quantity)
        }
        order.put(type, quantity + count);
    }
    public int getTypeCount(Furniture type){
        int count = 0;
        if(order.containsKey(type)){
            count = order.get(type);
        }
        return count;
    }
    public float getTypeCost(Furniture type){
        float cost = 0.0f;
        if(order.containsKey(type)) {
            cost = order.get(type)* type.cost;  // order.get(type) -> quantity, type.cost -> cost of each Furniture - Ch/T/Co
        }
        return cost;
    }
    public float getTotalOrderCost(){
        float totalCost = 0.0f;
        for (Furniture eachFurniture : order.keySet()) {
            float totalEachCost = 0.0f;
            int value = order.get(eachFurniture);
            float eachCost = eachFurniture.cost;
            totalEachCost = value * eachCost;
            totalCost = totalCost + totalEachCost;
        }
        return totalCost;
    }

    public int getTotalOrderQuantity(){
        int totalQuantity = 0;
        for (Furniture eachFurniture : order.keySet()) {
            totalQuantity = totalQuantity + order.get(eachFurniture);
        }
        return totalQuantity;
    }

}
