package com.shavi.shavirestaurant.controller;

import com.shavi.shavirestaurant.model.Category;
import com.shavi.shavirestaurant.repository.CategoryRepository;
import com.shavi.shavirestaurant.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    private CategoryService categoryService;
    private static final Logger LOGGER = Logger.getLogger(AdminController.class.getName());

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String adminHome(){
        return "admin";
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return  categoryService.getCategories();
    }


    @PostMapping ("/categories/add")
    public Category createCategory(@RequestBody Category category){
       return  categoryService.createCategory(category);
    }
}
