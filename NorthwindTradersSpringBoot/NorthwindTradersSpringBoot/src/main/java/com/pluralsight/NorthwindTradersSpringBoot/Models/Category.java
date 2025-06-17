package com.pluralsight.NorthwindTradersSpringBoot.Models;

public class Category {
    private int categoryId;
    private String categoryName;


    public Category() {

    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
