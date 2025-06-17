package com.pluralsight.NorthwindTradersSpringBoot.Controllers;


import com.pluralsight.NorthwindTradersSpringBoot.Models.Category;
import com.pluralsight.NorthwindTradersSpringBoot.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
