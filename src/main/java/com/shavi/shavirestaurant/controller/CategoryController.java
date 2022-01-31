package com.shavi.shavirestaurant.controller;

import com.shavi.shavirestaurant.model.Category;
import com.shavi.shavirestaurant.model.Meal;
import com.shavi.shavirestaurant.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * @param categoryId
     * @return
     */
    @GetMapping("/api/categories/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        return categoryService.getCategory(categoryId);
    }

    /**
     * @return
     */
    @GetMapping("/api/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }


    /**
     * @param categoryId
     * @return
     */
    @GetMapping("/api/categories/{categoryId}/meals")
    public List<Meal> getMeals(@PathVariable(value = "categoryId") Long categoryId) {
        return categoryService.getCategoryMeals(categoryId);
    }

    /**
     * @param categoryId
     * @param mealId
     * @return
     */
    @GetMapping("/api/categories/{categoryId}/meals/{mealId}")
    public Meal getMeal(@PathVariable(value = "categoryId") Long categoryId, @PathVariable Long mealId) {
        return categoryService.getCategoryMeal(categoryId, mealId);
    }

    /**
     * @param category
     * @return
     */
    @PostMapping("/api/categories")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }
}
