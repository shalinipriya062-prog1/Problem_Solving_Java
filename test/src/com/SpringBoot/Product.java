package com.SpringBoot;//package uk.co.sainsburys.interview.client.model;

//import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    //@JsonProperty("product_uid")
    private int productUid;
    //@JsonProperty("product_type")
    private String productType;
    private String name;
    //@JsonProperty("full_url")
    private String fullUrl;

    public Product(int productUid, String productType, String name, String fullUrl) {
        this.productUid = productUid;
        this.productType = productType;
        this.name = name;
        this.fullUrl = fullUrl;
    }

    public int getProductUid() {
        return productUid;
    }

    public void setProductUid(int productUid) {
        this.productUid = productUid;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return productUid == product.productUid;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(productUid);
    }
}
