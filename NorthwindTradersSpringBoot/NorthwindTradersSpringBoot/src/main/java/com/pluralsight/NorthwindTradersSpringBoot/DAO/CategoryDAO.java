package com.pluralsight.NorthwindTradersSpringBoot.DAO;

import com.pluralsight.NorthwindTradersSpringBoot.Models.Category;

import java.util.List;

public interface CategoryDAO {
    public List<Category> getAllCategories();
    public Category getCategoryById(int categoryId);
    public void addCategory(Category category);
}
