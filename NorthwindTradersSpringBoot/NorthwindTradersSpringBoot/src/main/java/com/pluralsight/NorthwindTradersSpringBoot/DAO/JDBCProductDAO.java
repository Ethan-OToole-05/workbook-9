package com.pluralsight.NorthwindTradersSpringBoot.DAO;

import com.mysql.cj.protocol.Resultset;
import com.pluralsight.NorthwindTradersSpringBoot.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCProductDAO implements ProductDAO {
    private Product product;
    private List<Product> products;
    private DataSource dataSource;

    @Autowired
    public JDBCProductDAO(DataSource dataSource) {
        this.product = new Product();
        this.products = new ArrayList<>();
        this.dataSource = dataSource;
    }

    @Override
    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        this.products.clear();
        String query = "SELECT ProductId, ProductName, Category, UnitPrice FROM Products;";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rows = statement.executeQuery();
            while (rows.next()) {
                this.products.add(new Product(rows.getInt(1), rows.getString(2), rows.getString(3), rows.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.products;
    }

    @Override
    public Product getProductById(int productId) {
        String query = "SELECT ProductId, ProductName, Category, UnitPrice FROM Products WHERE ProductId = ?;";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, productId);
            ResultSet rows = statement.executeQuery();
            if (rows.next()) {
                this.product = (new Product(rows.getInt(1), rows.getString(2), rows.getString(3), rows.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
        /*
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
         */
    }

    @Override
    public void updateProduct(int productId, String productName, String productCategory, double productPrice) {


        /*
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
        */
    }

    @Override
    public void deleteProduct(int productId) {
        /*
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
         */
    }
}
