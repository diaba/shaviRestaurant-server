package com.shavi.shavirestaurant.controller;
import com.shavi.shavirestaurant.model.Category;
import com.shavi.shavirestaurant.model.Meal;
import com.shavi.shavirestaurant.service.CategoryService;
import com.shavi.shavirestaurant.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class MealController {

    private static final Logger LOGGER = Logger.getLogger(MealController.class.getName());
    private MealService mealService;

    @Autowired
    public void setMealService(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping(("/api/meals"))
    public List<Meal> getAllMeals(){
        return mealService.getAllMeals();
    }


}
