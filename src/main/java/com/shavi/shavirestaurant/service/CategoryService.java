package com.shavi.shavirestaurant.service;

import com.shavi.shavirestaurant.exception.InformationExistsException;
import com.shavi.shavirestaurant.exception.InformationNotFoundException;
import com.shavi.shavirestaurant.model.Category;
import com.shavi.shavirestaurant.repository.CategoryRepository;
import com.shavi.shavirestaurant.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private static final Logger LOGGER = Logger.getLogger(CategoryService.class.getName());

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Get list categories
     * @return
     */
   public List<Category> getCategories() {
        System.out.println("service calling getCategories ==>");
       return categoryRepository.findAll();
    }

    /**
     * -- For admin to create category
     * @param categoryObject
     * @return
     */
    public Category createCategory(Category categoryObject) {
        System.out.println("service calling createCategory ==>");
        //if category exist
        Category category = categoryRepository.findCategoryByCategory(categoryObject.getCategory());
        if (category != null) {
            throw new InformationExistsException("category with name " + category.getCategory() + " already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }

    /**
     *
     * @param categoryId
     * @param categoryObject
     * @return
     */
    public Category updateCategory(Long categoryId, Category categoryObject) {
        System.out.println("service calling updateCategory ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Category category = categoryRepository.findCategoryByCategory(categoryObject.getCategory());
        if (category == null) {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        } else {
            category.setCategory(categoryObject.getCategory());
            return categoryRepository.save(category);
        }
    }

}
