package com.pluralsight.NorthwindTradersSpringBoot.DAO;

import com.pluralsight.NorthwindTradersSpringBoot.Models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAO implements ProductDAO {

    private List<Product> products;
    private Product product;

    public SimpleProductDAO() {
        this.products = new ArrayList<>();
        this.products.add(new Product(1245, "Milk", "Dairy", 4.99));
        this.products.add(new Product(1234, "Chicken", "Meat", 9.99));
        this.products.add(new Product(4321, "Beef", "Meat", 10.99));

    }

    @Override
    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
//        return List.of();
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        try {
            for (Product product : this.products) {
                if (product.getProductId() == productId) {
                    return product;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateProduct(int productId, String productName, String productCategory, double productPrice) {
        try {
            for (Product product : this.products) {
                if (product.getProductId() == productId) {
                    product.setName(productName);
                    product.setCategory(productCategory);
                    product.setPrice(productPrice);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int productId) {
        try {
            for (Product product : this.products) {
                if (product.getProductId() == productId) {
                    this.products.remove(product);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
