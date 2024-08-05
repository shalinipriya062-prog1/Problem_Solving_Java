package com.SpringBoot;

//package uk.co.sainsburys.interview.controller;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Service
public class ProductService{

    //private List<Product> productList= new ArrayList<Product>();
    //private List<ProductPrice> productPriceList= new ArrayList<ProductPrice>();

    //ObjectMapper objectMapper1 = new ObjectMapper();
    //ProductsClient productsClient = new ProductsClient(objectMapper1);
    //private Set<Product> productSet = productsClient.getProducts();
    //private List<Product> productList= new ArrayList<>(productSet);





   // private Set<ProductPrice> productPriceSet = productsClient.getProductsPrices();
    //private List<ProductPrice> productPriceList= new ArrayList<>(productPriceSet);

    public static List<UnifiedProduct> getAllProducts(List<Product> productList, List<ProductPrice> productPriceList){
        //System.out.println("-----------------------Check------------------------");
        //for(Product p: productList){
        //    System.out.println(p.getProductUid());
        //}
        List<UnifiedProduct> outputList = new ArrayList<UnifiedProduct>();
        for (int i = 0; i< productList.size(); i++){
            //System.out.println("i = " + i);
            UnifiedProduct o = new UnifiedProduct();
            for(int j = 0; j<= productPriceList.size(); j++){
                if(productList.get(i).getProductUid()== productPriceList.get(j).getProductUid()){
                    o.setProductUid(productList.get(i).getProductUid());
                    o.setProductType(productList.get(i).getProductType());
                    o.setName(productList.get(i).getName());
                    o.setFullUrl(productList.get(i).getFullUrl());
                    o.setUnitPrice(productPriceList.get(j).getUnitPrice());
                    o.setUnitPriceMeasure(productPriceList.get(j).getUnitPriceMeasure());
                    o.setUnitPriceMeasureAmount(productPriceList.get(j).getUnitPriceMeasureAmount());
                    break;
                }
            }
            outputList.add(o);
        }
        System.out.println(outputList);
        return outputList;
    }

    public static List<UnifiedProduct> getByType(List<Product> productList, List<ProductPrice> productPriceList, String type){
        //System.out.println("-----------------------Check------------------------");
        //for(Product p: productList){
        //    System.out.println(p.getProductUid());
        //}
        List<UnifiedProduct> outputList = new ArrayList<UnifiedProduct>();
        for (int i = 0; i< productList.size(); i++){
            //System.out.println("i = " + i);
            UnifiedProduct o = new UnifiedProduct();
            for(int j = 0; j<= productPriceList.size(); j++){
                if(productList.get(i).getProductUid()== productPriceList.get(j).getProductUid()){
                    o.setProductUid(productList.get(i).getProductUid());
                    o.setProductType(productList.get(i).getProductType());
                    o.setName(productList.get(i).getName());
                    o.setFullUrl(productList.get(i).getFullUrl());
                    o.setUnitPrice(productPriceList.get(j).getUnitPrice());
                    o.setUnitPriceMeasure(productPriceList.get(j).getUnitPriceMeasure());
                    o.setUnitPriceMeasureAmount(productPriceList.get(j).getUnitPriceMeasureAmount());
                    break;
                }
            }
            outputList.add(o);
        }
        //System.out.println(outputList);
        List<UnifiedProduct> op1 = new ArrayList<UnifiedProduct>();
        for (UnifiedProduct u: outputList){
            if(u.getProductType().equals(type) && u.getProductType()==type){
                op1.add(u);
            }
        }
        return op1;
    }

    public static void main(String[] args){

         List<Product> productList= new ArrayList<>(Arrays.asList(
                new Product(1081459, "BASIC", "Sainsbury's Coleslaw, Taste the Difference 300g","https://www.sainsburys.co.uk/gol-ui/product/sainsburys-coleslaw--taste-the-difference-300g"),
                new Product(7732081, "BASIC", "Sainsbury's Breaded Yorkshire Cured Cooked British Ham Slices, Taste the Difference x4 120g", "https://www.sainsburys.co.uk/gol-ui/product/sainsburys-breaded-yorkshire-ham--taste-the-difference-120g-7732081-p-44"),
                new Product(7554911, "BASIC2", "Sainsbury's Wafer Thin Air Dried British Ham Slices, Taste the Difference 120g", "https://www.sainsburys.co.uk/gol-ui/product/sainsburys-air-dried-lean-ham-finely-sliced--taste-the-difference-120g")
        ));

        List<ProductPrice> productPriceList= new ArrayList<>(Arrays.asList(
                new ProductPrice(1081459, 8.57, "kg",1),
                new ProductPrice(7732081, 7.5, "kg", 1),
                new ProductPrice(7554911, 1.88, "g", 100)
        ));
        //List<UnifiedProduct> op = getAllProducts(productList, productPriceList);
        //for(UnifiedProduct o: op){
        //    System.out.println(o);
        //}
        List<UnifiedProduct> op1 = getByType(productList, productPriceList, "BASIC");
        for(UnifiedProduct o: op1){
            System.out.println(o);
        }

    }



}

