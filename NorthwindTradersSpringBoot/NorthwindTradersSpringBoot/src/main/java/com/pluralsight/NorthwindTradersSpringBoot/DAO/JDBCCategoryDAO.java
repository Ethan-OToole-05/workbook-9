package com.pluralsight.NorthwindTradersSpringBoot.DAO;

import com.pluralsight.NorthwindTradersSpringBoot.Models.Category;
import com.pluralsight.NorthwindTradersSpringBoot.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCategoryDAO implements CategoryDAO {
    private Category category;
    private List<Category> categories;
    private DataSource dataSource;

    @Autowired
    public JDBCCategoryDAO(DataSource dataSource) {
        this.category = new Category();
        this.categories = new ArrayList<>();
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAllCategories() {
        String query = "SELECT * FROM categories";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rows = statement.executeQuery();
            while (rows.next()) {
                this.categories.add(new Category(rows.getInt(1), rows.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.categories;
    }
}
