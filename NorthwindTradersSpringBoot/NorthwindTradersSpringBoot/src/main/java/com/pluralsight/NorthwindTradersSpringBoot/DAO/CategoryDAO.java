package com.pluralsight.NorthwindTradersSpringBoot.DAO;

import com.pluralsight.NorthwindTradersSpringBoot.Models.Category;

import java.util.List;

public interface CategoryDAO {
    public List<Category> getAllCategories();
    /*
    public void addProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(int productId);
    public void updateProduct(int productId, String productName, int productCategoryId, double productPrice);
    public void deleteProduct(int productId);
     */
}
