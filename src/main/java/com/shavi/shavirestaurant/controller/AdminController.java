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

    /**
     *
     * @return
     */
    @GetMapping("/users")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomer();
    }

    /**
     *
     * @param customerId
     * @param customer
     * @return
     */
    @PutMapping("/users/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer){
        return customerService.updateCustomer(customerId, customer);
    }
    /**
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/categories/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId){
        return  categoryService.getCategory(categoryId);
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return  categoryService.getCategories();
    }
    /**
     *
     * @param category
     * @return
     */
    @PostMapping ("/categories")
    public Category createCategory(@RequestBody Category category){
       return  categoryService.createCategory(category);
    }

    /**
     *
     * @param categoryId
     * @param categoryObject
     * @return
     */
    @PutMapping("/categories/{categoryId}")
    public Category updateCategory(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Category categoryObject) {
        return categoryService.updateCategory(categoryId, categoryObject);
    }
    @DeleteMapping("/categories/{categoryId}")
    public String deleteCategory(@PathVariable(value = "categoryId") Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
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
    @GetMapping("/categories/{categoryId}/meals")
    public List<Meal> getMeals(@PathVariable(value = "categoryId") Long categoryId) {
        return categoryService.getCategoryMeals(categoryId);
    }
    @PutMapping("/categories/{categoryId}/meals/{mealId}")
    public  Meal getMeal(@PathVariable(value = "categoryId") Long categoryId, @PathVariable Long mealId ,@RequestBody Meal meal) {
        return categoryService.updateCategoryMeal(categoryId,mealId,meal);
    }
    @GetMapping("/categories/{categoryId}/meals/{mealId}")
    public  Meal getMeal(@PathVariable(value = "categoryId") Long categoryId, @PathVariable Long mealId) {
        return categoryService.getCategoryMeal(categoryId,mealId);
    }
    @DeleteMapping("/categories/{categoryId}/meals/{mealId}")
    public  String deleteMeal( @PathVariable Long categoryId, @PathVariable Long mealId) {
        return categoryService.deleteCategoryMeal(categoryId,mealId);
    }
    @GetMapping("/categories/{categoryId}/meals/{mealId}/nutrition")
    public Nutrition getNutrition(@PathVariable(value = "categoryId") Long categoryId, @PathVariable Long mealId) {
        return categoryService.getNutrition(categoryId,mealId);
    }
    @PutMapping("/categories/{categoryId}/meals/{mealId}/nutrition")
    public Nutrition addNutrition(@PathVariable(value = "categoryId") Long categoryId, @PathVariable Long mealId, @RequestBody Nutrition nutrition) {
        return categoryService.createNutrition(categoryId,mealId, nutrition);
    }
}
