package com.SpringBoot;//package uk.co.sainsburys.interview.client.model;

//import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPrice {

    //@JsonProperty("product_uid")
    private int productUid;
    //@JsonProperty("unit_price")
    private double unitPrice;
    //@JsonProperty("unit_price_measure")
    private String unitPriceMeasure;
    //@JsonProperty("unit_price_measure_amount")
    private int unitPriceMeasureAmount;

    public ProductPrice(int productUid, double unitPrice, String unitPriceMeasure, int unitPriceMeasureAmount) {
        this.productUid = productUid;
        this.unitPrice = unitPrice;
        this.unitPriceMeasure = unitPriceMeasure;
        this.unitPriceMeasureAmount = unitPriceMeasureAmount;
    }

    public int getProductUid() {
        return productUid;
    }

    public void setProductUid(int productUid) {
        this.productUid = productUid;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnitPriceMeasure() {
        return unitPriceMeasure;
    }

    public void setUnitPriceMeasure(String unitPriceMeasure) {
        this.unitPriceMeasure = unitPriceMeasure;
    }

    public int getUnitPriceMeasureAmount() {
        return unitPriceMeasureAmount;
    }

    public void setUnitPriceMeasureAmount(int unitPriceMeasureAmount) {
        this.unitPriceMeasureAmount = unitPriceMeasureAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProductPrice productPrice = (ProductPrice) obj;
        return productUid == productPrice.productUid;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(productUid);
    }
}