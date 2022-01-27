package com.shavi.shavirestaurant.controller;
import com.shavi.shavirestaurant.model.Customer;
import com.shavi.shavirestaurant.model.request.LoginRequest;
import com.shavi.shavirestaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/auth/users")
public class CustomerController {
    private CustomerService customerService ;
    private static final Logger LOGGER = Logger.getLogger(CustomerController.class.getName());

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     *
     * @param customerObject
     * @return
     */
    @PostMapping("/register")
    public Customer createCustomer(@RequestBody Customer customerObject) {
        LOGGER.info("calling createCustomer method from controller");
        return customerService.createCustomer(customerObject);
    }

    /**
     *
     * @param loginRequest
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        return customerService.loginUser(loginRequest);
    }
}
