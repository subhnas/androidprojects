package com.example.myapplication;

public class ProductModel {

    String productName;
    int image;

    public ProductModel(String productName, int image) {
        this.productName = productName;
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public int getImage() {
        return image;
    }
}
