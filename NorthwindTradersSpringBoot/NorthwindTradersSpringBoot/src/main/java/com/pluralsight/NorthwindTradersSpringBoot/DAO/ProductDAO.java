package com.pluralsight.NorthwindTradersSpringBoot.DAO;

import com.pluralsight.NorthwindTradersSpringBoot.Models.Product;

import java.util.List;

public interface ProductDAO {
    public void addProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(int productId);
    public void updateProduct(int productId, String productName, String productCategory, double productPrice);
    public void deleteProduct(int productId);
}
