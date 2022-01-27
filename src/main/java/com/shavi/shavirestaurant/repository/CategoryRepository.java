package com.shavi.shavirestaurant.repository;
import com.shavi.shavirestaurant.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository <Category,Long>{

    Category findCategoryByCategory(String cat);
//    Category findByIdAndUserId(Long categoryId, Long id);
//    Category findByUserIdAndName(Long id, String name);

}
