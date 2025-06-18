package com.pluralsight.NorthwindTradersSpringBoot.DAO;

import com.pluralsight.NorthwindTradersSpringBoot.Models.Category;
import com.pluralsight.NorthwindTradersSpringBoot.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCCategoryDAO implements CategoryDAO {
    private Category category;
    private List<Category> categories;
    private DataSource dataSource;

    @Autowired
    public JDBCCategoryDAO(DataSource dataSource) {
//        this.category = new Category();
//        this.categories = new ArrayList<>();
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAllCategories() {
        this.categories = new ArrayList<>();
        String query = "SELECT CategoryId, CategoryName FROM categories";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rows = statement.executeQuery();
            while (rows.next()) {
                this.categories.add(new Category(rows.getInt(1), rows.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.categories;
    }

    @Override
    public Category getCategoryById(int categoryId) {
        String query = "SELECT CategoryId, CategoryName FROM Categories WHERE CategoryId = ?;";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, categoryId);
            ResultSet rows = statement.executeQuery();
            if (rows.next()) {
                this.category = (new Category(rows.getInt(1), rows.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void addCategory(Category category) {
        Category createdCategory = null;
        String query = "INSERT INTO Categories (CategoryName) VALUES (?);";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, category.getCategoryName());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                createdCategory = getCategoryById(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
