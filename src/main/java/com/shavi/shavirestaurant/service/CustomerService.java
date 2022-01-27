package com.shavi.shavirestaurant.service;

import com.shavi.shavirestaurant.exception.InformationExistsException;
import com.shavi.shavirestaurant.model.Customer;
import com.shavi.shavirestaurant.model.request.LoginRequest;
import com.shavi.shavirestaurant.model.response.LoginResponse;
import com.shavi.shavirestaurant.repository.CustomerRepository;
import com.shavi.shavirestaurant.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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
    /**
     * <h1> Create customer </h1>
     * <p>Check if the customer does not exist</p>
     * @param customerObject
     * @return
     */
    public Customer createCustomer(Customer customerObject){
        LOGGER.info("calling createCustomer method from service");
        if (!customerRepository.existsByEmail(customerObject.getEmail())) {
            customerObject.setPassword(passwordEncoder.encode(customerObject.getPassword()));
            return customerRepository.save(customerObject);
        } else {
            throw new InformationExistsException("customer with email address " +
                    customerObject.getEmail() + " already exists");
        }
    }

    /**
     * <h1>Login the customer</h1>
     * @param loginRequest
     * @return
     */
    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        final String jwt = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(jwt));
    }

}
