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

    @GetMapping(("/meals"))
    public List<Meal> getAllMeals(){
        return mealService.getAllMeals();
    }

    /**
     *
     * @param mealId
     * @return
     */
    @GetMapping("/meals/{mealId}")
    public Meal getMeal(@PathVariable Long mealId){
        return mealService.getMeal(mealId);
    }

    /**
     *
     * @param name
     * @return
     */
    @GetMapping("/mealByyName/{name}")
    public Meal getMealByName(@PathVariable String name){
        return mealService.getMeal(name);
    }

    /**
     *
     * @param mealId
     * @param meal
     * @return
     */
    @PutMapping("/meals/{mealId}")
    public Meal updateMeal(@PathVariable Long mealId,@RequestBody Meal meal){
        return mealService.updateMeal(mealId, meal);
    }
}
