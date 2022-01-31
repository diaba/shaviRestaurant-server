package com.shavi.shavirestaurant.repository;

import com.shavi.shavirestaurant.model.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingRepository extends JpaRepository<Tracking,Long> {
    Tracking findByCustomerOrderId(Long id);
}
