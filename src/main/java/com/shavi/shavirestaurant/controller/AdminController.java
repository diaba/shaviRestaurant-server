package com.shavi.shavirestaurant.controller;

import com.shavi.shavirestaurant.model.Category;

import com.shavi.shavirestaurant.model.Customer;
import com.shavi.shavirestaurant.model.Meal;
import com.shavi.shavirestaurant.model.Nutrition;
import com.shavi.shavirestaurant.service.CategoryService;
import com.shavi.shavirestaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin
@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    private CategoryService categoryService;
    private CustomerService customerService;

    private static final Logger LOGGER = Logger.getLogger(AdminController.class.getName());

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String adminHome(){
        return "admin";
    }

    // create meal , category to feed database
        /**
     *
     * @param category
     * @return
     */
    @PostMapping ("/categories")
    public Category createCategory(@RequestBody Category category){
       return  categoryService.createCategory(category);
    }
//    /**
//     *
//     * @return
//     */
//    @GetMapping("/customers")
//    public List<Customer> getAllCustomers(){
//        return customerService.getAllCustomer();
//    }
//
//
//    /**
//     *
//     * @param categoryId
//     * @return
//     */
////    @GetMapping("/categories/{categoryId}")
////    public Category getCategory(@PathVariable Long categoryId){
////        return  categoryService.getCategory(categoryId);
////    }
//
////    @GetMapping("/categories")
////    public List<Category> getCategories(){
////        return  categoryService.getCategories();
////    }

//
//    /**
//     *
//     * @param categoryId
//     * @param categoryObject
//     * @return
//     */
//    @PutMapping("/categories/{categoryId}")
//    public Category updateCategory(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Category categoryObject) {
//        return categoryService.updateCategory(categoryId, categoryObject);
//    }
//    @DeleteMapping("/categories/{categoryId}")
//    public String deleteCategory(@PathVariable(value = "categoryId") Long categoryId) {
//        return categoryService.deleteCategory(categoryId);
//    }
    /**
     *
     * @param categoryId
     * @param meal
     * @return
     */
    @PostMapping("/categories/{categoryId}/meals")
    public Meal createMeal(
            @PathVariable(value = "categoryId") Long categoryId,
            @RequestBody Meal meal
    ) {
        return categoryService.createCategoryMeal(categoryId,meal);
    }
//
//
//
//    /**
//     *
//     * @param categoryId
//     * @param mealId
//     * @param meal
//     * @return
//     */
//    @PutMapping("/categories/{categoryId}/meals/{mealId}")
//    public  Meal getMeal(@PathVariable(value = "categoryId") Long categoryId, @PathVariable Long mealId ,@RequestBody Meal meal) {
//        return categoryService.updateCategoryMeal(categoryId,mealId,meal);
//    }
//
//    /**
//     *
//     * @param categoryId
//     * @param mealId
//     * @return
//     */
//    @DeleteMapping("/categories/{categoryId}/meals/{mealId}")
//    public  String deleteMeal( @PathVariable Long categoryId, @PathVariable Long mealId) {
//        return categoryService.deleteCategoryMeal(categoryId,mealId);
//    }
//
//
//
//    /**
//     *
//     * @param categoryId
//     * @param mealId
//     * @param nutrition
//     * @return
//     */
//    @PutMapping("/categories/{categoryId}/meals/{mealId}/nutrition")
//    public Nutrition addNutrition(@PathVariable(value = "categoryId") Long categoryId, @PathVariable Long mealId, @RequestBody Nutrition nutrition) {
//        return categoryService.createNutrition(categoryId,mealId, nutrition);
//    }
//
//
//
//


}
