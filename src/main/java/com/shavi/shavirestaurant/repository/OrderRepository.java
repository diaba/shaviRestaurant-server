package com.shavi.shavirestaurant.repository;

import com.shavi.shavirestaurant.model.Meal;
import com.shavi.shavirestaurant.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByIdAndAndMeal(Long orderId, Meal meal);

}
