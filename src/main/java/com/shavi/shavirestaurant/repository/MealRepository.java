package com.shavi.shavirestaurant.repository;

import com.shavi.shavirestaurant.model.Category;
import com.shavi.shavirestaurant.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal,Long> {
    List<Meal> findAllById(Long id);
    List<Meal> findByCategoryId(Long id);

    Meal findByName(String name);

    Meal findMealByNameAndCategoryId(String name, Long categoryId);

    Meal findMealByIdAndCategoryId(Long mealId, Long categoryId);

   // boolean existsOrderListAndName(Long orderId, String name);
}
