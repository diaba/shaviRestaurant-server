package com.shavi.shavirestaurant.controller;

import com.shavi.shavirestaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "/api")
public class TrackingController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
//    @GetMapping("/customers/{customerId}/customerOrder/{customerOrderId}/tracking/{trackingId}")
//    public  Tracking getTracking()
}
