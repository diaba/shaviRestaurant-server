package com.shavi.shavirestaurant.repository;

import com.shavi.shavirestaurant.model.CustomerOrder;
import com.shavi.shavirestaurant.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    List<CustomerOrder> findAllByCustomerId(Long customerId);

    CustomerOrder findByOrderIdAndCustomerId(Long orderId, Long customerId);


}
