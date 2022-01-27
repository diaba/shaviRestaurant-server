package com.shavi.shavirestaurant.controller;
import com.shavi.shavirestaurant.model.Category;
import com.shavi.shavirestaurant.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api")
public class MealController {

    private static final Logger LOGGER = Logger.getLogger(MealController.class.getName());
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     *
     * @return
     */
    @GetMapping("/categories/")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

}
