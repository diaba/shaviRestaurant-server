package com.shavi.shavirestaurant.repository;

import com.shavi.shavirestaurant.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);

    Customer findCustomerByEmail(String email);

    Customer findCustomerById(Long customerId);
}