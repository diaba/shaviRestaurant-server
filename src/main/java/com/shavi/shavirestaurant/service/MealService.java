package com.shavi.shavirestaurant.service;
import com.shavi.shavirestaurant.exception.InformationNotFoundException;
import com.shavi.shavirestaurant.model.Meal;
import com.shavi.shavirestaurant.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MealService {
    private static final Logger LOGGER = Logger.getLogger(MealService.class.getName());

    private MealRepository mealRepository;

    @Autowired
    public void setMealRepository(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    /**
     * <p>Get all meals</p>
     * @return
     */
    public List<Meal> getAllMeals(){
        return mealRepository.findAll();
    }

    /**
     * <p>Find a specific meal by id</p>
     * @param mealId
     * @return
     */
    public Meal getMeal(Long mealId){
        Optional<Meal> meal = mealRepository.findById(mealId);
        if (meal.isEmpty()){
            throw new InformationNotFoundException("Meal is not found");
        }
        return meal.get();
    }
    /**
     * <p>Find a specific meal by name</p>
     * @param name
     * @return
     */
    public Meal getMeal(String name){
        Meal meal = mealRepository.findByName(name);
        if (meal == null){
            throw new InformationNotFoundException("Meal is not found");
        }
        return meal;
    }

    /**
     *
     * @param mealId
     * @return
     */
    public Meal updateMeal(Long mealId, Meal mealObject){
        Optional<Meal> meal = mealRepository.findById(mealId);
        if (meal.isEmpty()){
            throw new InformationNotFoundException("Meal is not found");
        }
        meal.get().setServing(mealObject.getServing());
        meal.get().setPrice(mealObject.getPrice());
        meal.get().setImageUrl(mealObject.getImageUrl());
        meal.get().setName(mealObject.getName());
        return mealRepository.save(meal.get());
    }

}
