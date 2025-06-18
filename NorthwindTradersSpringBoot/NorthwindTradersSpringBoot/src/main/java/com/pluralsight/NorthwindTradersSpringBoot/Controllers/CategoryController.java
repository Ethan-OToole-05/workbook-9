package com.pluralsight.NorthwindTradersSpringBoot.Controllers;


import com.pluralsight.NorthwindTradersSpringBoot.Models.Category;
import com.pluralsight.NorthwindTradersSpringBoot.Models.Product;
import com.pluralsight.NorthwindTradersSpringBoot.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable int categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @RequestMapping(path = "/categories", method = RequestMethod.POST)
    public void add(@RequestBody Category category) {
        categoryService.addCategory(category);
    }
}
