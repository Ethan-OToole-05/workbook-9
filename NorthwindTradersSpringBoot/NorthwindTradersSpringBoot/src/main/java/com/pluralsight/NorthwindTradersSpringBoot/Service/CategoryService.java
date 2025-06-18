package com.pluralsight.NorthwindTradersSpringBoot.Service;


import com.pluralsight.NorthwindTradersSpringBoot.DAO.CategoryDAO;
import com.pluralsight.NorthwindTradersSpringBoot.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryDAO categoryDAO;

    @Autowired
    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    public Category getCategoryById(int categoryId) {
        return categoryDAO.getCategoryById(categoryId);
    }

    public void addCategory(Category category) {
        categoryDAO.addCategory(category);
    }
}
