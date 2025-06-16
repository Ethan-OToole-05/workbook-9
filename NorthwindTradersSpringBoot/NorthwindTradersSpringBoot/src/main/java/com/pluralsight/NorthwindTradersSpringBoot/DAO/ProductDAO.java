package com.pluralsight.NorthwindTradersSpringBoot.DAO;

import com.pluralsight.NorthwindTradersSpringBoot.Models.Product;

import java.util.List;

public interface ProductDAO {
    public void addProduct(Product product);
    public List<Product> getAllProducts();
}
