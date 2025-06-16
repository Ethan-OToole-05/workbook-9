package com.pluralsight.NorthwindTradersSpringBoot.Models;

public class Product {

    private int productId;
    private String name;
    private String category;
    private double price;

    public Product() {

    }

    public Product(int productId, String name, String category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
