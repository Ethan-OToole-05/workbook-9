package com.pluralsight.NorthwindTradersSpringBoot.DAO;

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
        Product createdProduct = null;
        String query = "INSERT INTO Products (ProductName, CategoryId, UnitPrice) VALUES (?, ?, ?);";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, product.getName());
            statement.setInt(2, product.getCategoryId());
            statement.setDouble(3, product.getPrice());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()) {
                createdProduct = getProductById(generatedKeys.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        this.products.clear();
        String query = "SELECT ProductId, ProductName, CategoryId, UnitPrice FROM Products;";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rows = statement.executeQuery();
            while (rows.next()) {
                this.products.add(new Product(rows.getInt(1), rows.getString(2), rows.getInt(3), rows.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.products;
    }

    @Override
    public Product getProductById(int productId) {
        String query = "SELECT ProductId, ProductName, CategoryId, UnitPrice FROM Products WHERE ProductId = ?;";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, productId);
            ResultSet rows = statement.executeQuery();
            if (rows.next()) {
                this.product = (new Product(rows.getInt(1), rows.getString(2), rows.getInt(3), rows.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void updateProduct(int productId, String productName, int productCategory, double productPrice) {
        String query = "UPDATE Products SET ProductName = ?, CategoryID = ?, UnitPrice = ? WHERE ProductID = ?";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, productName);
            statement.setInt(2, productCategory);
            statement.setDouble(3, productPrice);
            statement.setInt(4, productId);
            ResultSet rows = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*
        try {
            for (Product product : this.products) {
                if (product.getProductId() == productId) {
                    product.setName(productName);
                    product.setCategoryId(productCategory);
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
