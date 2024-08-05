package com.practice.furniture.factory.main;

public enum Furniture {
    CHAIR("Chair", 100.0f),
    TABLE("Table", 250.0f),
    COUCH("Couch", 500.0f);

    public final String label;
    public final float cost;

    Furniture(String label, float cost){
        this.label = label;
        this.cost = cost;
    }
}
