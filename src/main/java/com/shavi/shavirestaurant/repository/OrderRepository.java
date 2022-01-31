package com.shavi.shavirestaurant.repository;

import com.shavi.shavirestaurant.model.Meal;
import com.shavi.shavirestaurant.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByIdAndAndMeal(Long orderId, Meal meal);

}
