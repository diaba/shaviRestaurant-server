package com.shavi.shavirestaurant.service;

import com.shavi.shavirestaurant.model.Customer;
import com.shavi.shavirestaurant.repository.CustomerRepository;
import com.shavi.shavirestaurant.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CustomerService {
    private static final Logger LOGGER = Logger.getLogger(CustomerService.class.getName());

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public void setUserRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    /**
     * <h1>Find user by email address</h1>
     * @param email
     * @return
     */
    public Customer findUserByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

}
