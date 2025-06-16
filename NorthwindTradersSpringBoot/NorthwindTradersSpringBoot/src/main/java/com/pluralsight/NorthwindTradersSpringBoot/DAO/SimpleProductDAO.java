package com.pluralsight.NorthwindTradersSpringBoot.DAO;

import com.pluralsight.NorthwindTradersSpringBoot.Models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAO implements ProductDAO{

    private List<Product> products;

    public SimpleProductDAO() {
        this.products = new ArrayList<>();
        this.products.add(new Product(1245, "Milk", "Dairy", 4.99));
        this.products.add(new Product(1234, "Chicken", "Meat", 4.99));
        this.products.add(new Product(4321, "Beef", "Meat", 4.99));

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
}
