package com.practice.furniture.factory.main;

import java.util.HashMap;

public interface FurnitureOrderInterface {
    public void addToOrder(Furniture furniture, int count);
    public HashMap getOrderedFurniture();
    public int getTypeCount(Furniture type);
    public float getTypeCost(Furniture type);
    public float getTotalOrderCost();
    public int getTotalOrderQuantity();

}
