package com.shavi.shavirestaurant.repository;

import com.shavi.shavirestaurant.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
   List<Payment> findByCustomerId(Long id);

    Payment findByCustomerIdAndId(Long paymentId, Long id);
}
