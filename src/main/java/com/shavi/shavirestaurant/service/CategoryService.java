package com.shavi.shavirestaurant.service;

import com.shavi.shavirestaurant.exception.InformationExistsException;
import com.shavi.shavirestaurant.exception.InformationNotFoundException;
import com.shavi.shavirestaurant.model.Category;
import com.shavi.shavirestaurant.model.Meal;
import com.shavi.shavirestaurant.model.Nutrition;
import com.shavi.shavirestaurant.repository.CategoryRepository;
import com.shavi.shavirestaurant.repository.MealRepository;
import com.shavi.shavirestaurant.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private MealRepository mealRepository;
    private static final Logger LOGGER = Logger.getLogger(CategoryService.class.getName());

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setMealRepository(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    /**
     * Get list categories
     *
     * @return
     */
    public List<Category> getCategories() {
        System.out.println("service calling getCategories ==>");
        return categoryRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    public Category getCategory(Long id) {
        System.out.println("service calling getCategories ==>");
        return categoryRepository.findCategoryById(id);
    }

    /**
     * -- For admin to create category
     *
     * @param categoryObject
     * @return
     */
    public Category createCategory(Category categoryObject) {
        System.out.println("service calling createCategory ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        //if category exist
        Category category = categoryRepository.findCategoryByCategory(categoryObject.getCategory());
        if (category != null) {
            throw new InformationExistsException("category with name " + category.getCategory() + " already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }

    /**
     * @param categoryId
     * @param categoryObject
     * @return
     */
    public Category updateCategory(Long categoryId, Category categoryObject) {
        System.out.println("service calling updateCategory ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Category category = categoryRepository.findCategoryById(categoryId);
        if (category == null) {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        } else {
            category.setCategory(categoryObject.getCategory());
            return categoryRepository.save(category);
        }
    }

    /**
     * @param categoryId
     * @return
     */
    public String deleteCategory(Long categoryId) {
        System.out.println("service calling deleteCategory ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Category category = categoryRepository.findCategoryById(categoryId);
        if (category == null) {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        } else {
            categoryRepository.deleteById(categoryId);
            return "category with id " + categoryId + " has been successfully deleted";
        }
    }

    /**
     * @param categoryId
     * @param mealObject
     * @return
     */
    public Meal createCategoryMeal(Long categoryId, Meal mealObject) {
        System.out.println("service calling createCategoryMeal ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Category category = categoryRepository.findCategoryById(categoryId);
        if (category == null) {
            throw new InformationNotFoundException(
                    "category with id " + categoryId + " not belongs to this user or category does not exist");
        }
        Meal meal = mealRepository.findByName(mealObject.getName());
        if (meal != null) {
            throw new InformationExistsException("recipe with name " + meal.getName() + " already exists");
        }
        mealObject.setCategory(category);
        return mealRepository.save(mealObject);
    }


    /**
     * @param categoryId
     * @return
     */
    public List<Meal> getCategoryMeals(Long categoryId) {
        System.out.println("service calling getCategoryMeals ==>");

        Category category = categoryRepository.findCategoryById(categoryId);
        if (category == null) {
            throw new InformationNotFoundException(
                    "category with id " + categoryId + " not belongs to this user or category does not exist");
        }
        return mealRepository.findByCategoryId(categoryId);

    }

    public Meal getCategoryMeal(Long categoryId, Long mealId) {
        System.out.println("service calling getCategoryMeal ==>");

        Category category = categoryRepository.findCategoryById(categoryId);
        if (category == null) {
            throw new InformationNotFoundException(
                    "category with id " + categoryId + " not belongs to this user or category does not exist");
        } else {
            Meal meal = mealRepository.findMealByIdAndCategoryId(mealId, categoryId);

            if (meal == null) {
                throw new InformationNotFoundException(
                        "meal with id " + mealId + " not belongs meal does not exist");
            }
            return meal;
        }

    }
//    /**
//     *
//     * @param categoryId
//     * @param mealId
//     * @param mealObject
//     * @return
//     */
//    public Meal updateCategoryMeal(Long categoryId, Long mealId, Meal mealObject) {
//        System.out.println("service calling updateCategoryMeal ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Category category = categoryRepository.findCategoryById(categoryId);
//        if (category == null) {
//            throw new InformationNotFoundException("category with id " + categoryId + " not found");
//        } else {
//            // save meal
//            Meal meal = mealRepository.findMealByIdAndCategoryId(mealId, categoryId);
//
//            if (meal == null) {
//                throw new InformationNotFoundException(
//                    "meal with id " + mealId + " not belongs meal does not exist");
//            }
//            meal.setCategory(mealObject.getCategory());
//            meal.setImageUrl(mealObject.getImageUrl());
//            meal.setName(mealObject.getName());
//            meal.setPrice(mealObject.getPrice());
//            meal.setServing(mealObject.getServing());
//          return   mealRepository.save(meal);
//
//        }
//    }
//
//    /**
//     *
//     * @param categoryId
//     * @param mealId
//     * @return
//     */
//    public String deleteCategoryMeal(Long categoryId, Long mealId){
//        System.out.println("service calling deleteCategoryMeal ==>");
//
//        Category category = categoryRepository.findCategoryById(categoryId);
//        if (category == null) {
//            throw new InformationNotFoundException(
//                    "category with id " + categoryId + " not belongs to this user or category does not exist");
//        }else{
//            Meal meal = mealRepository.findMealByIdAndCategoryId(mealId, categoryId);
//
//            if (meal == null) {
//                throw new InformationNotFoundException(
//                        "meal with id " + mealId + " not belongs meal does not exist");
//            }
//            mealRepository.deleteById(mealId);
//            return "meal with id "+ mealId +" has been successfully deleted ";
//        }
//
//    }
//
//    /**
//     *
//     * @param categoryId
//     * @param mealId
//     * @return
//     */
//    public Nutrition getNutrition( Long categoryId, Long mealId){
//        Meal meal = getCategoryMeal(categoryId,mealId);
//        if (meal == null){
//            throw new InformationNotFoundException("Meal with id "+ mealId +" does not exist");
//        }
//        else{
//            return meal.getNutrition();
//        }
//    }
//
//    /**
//     *
//     * @param categoryId
//     * @param mealId
//     * @param ObjectNutrition
//     * @return
//     */
//    public Nutrition createNutrition( Long categoryId, Long mealId, Nutrition ObjectNutrition){
//        Meal meal = getCategoryMeal(categoryId,mealId);
//        if (meal == null){
//            throw new InformationNotFoundException("Meal with id "+ mealId +" does not exist");
//        }
//        else{
//           meal.setNutrition(ObjectNutrition);
//           mealRepository.save(meal);
//           return meal.getNutrition();
//        }
    //  }


}
