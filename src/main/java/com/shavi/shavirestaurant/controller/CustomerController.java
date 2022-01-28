package com.shavi.shavirestaurant.controller;
import com.shavi.shavirestaurant.model.*;
import com.shavi.shavirestaurant.model.request.LoginRequest;
import com.shavi.shavirestaurant.service.CategoryService;
import com.shavi.shavirestaurant.service.CustomerService;
import com.shavi.shavirestaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "")
@CrossOrigin
public class CustomerController {
    private static final Logger LOGGER = Logger.getLogger(CustomerController.class.getName());
    private CustomerService customerService ;
//    private CategoryService categoryService;
//    private OrderService orderService;
//    private CustomerController customerOrderService;

//    @Autowired
//    public void setCustomerOrderService(CustomerController customerOrderService) {
//        this.customerOrderService = customerOrderService;
//    }



//    @Autowired
//    public void setOrderService(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
//    @Autowired
//    public void setCategoryService(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }

    public String defaultPage(){
        return "Home Page";
    }
    /**
     *
     * @param customerObject
     * @return
     */
    @PostMapping("/auth/users/register")
    public Customer createCustomer(@RequestBody Customer customerObject) {
        LOGGER.info("calling createCustomer method from controller");
        return customerService.createCustomer(customerObject);
    }

    /**
     *
     * @param loginRequest
     * @return
     */
    @PostMapping("/auth/users/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        return customerService.loginUser(loginRequest);
    }
    /**
     *
     * @param customer
     * @return
     */
    @PutMapping("/api/customers")
    public Customer updateCustomer( @RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
    @GetMapping("/api/customers")
    public Customer getCustomer( ){
        return customerService.getCustomer();
    }
//    /**
//     *
//     * @param categoryId
//     * @return
//     */
//    @GetMapping("/api/categories/{categoryId}")
//    public Category getCategory(@PathVariable Long categoryId){
//        return  categoryService.getCategory(categoryId);
//    }
//
//    /**
//     *
//     * @return
//     */
//    @GetMapping("/api/categories")
//    public List<Category> getCategories(){
//        return  categoryService.getCategories();
//    }
//
//
//    /**
//     *
//     * @param categoryId
//     * @return
//     */
//    @GetMapping("/api/categories/{categoryId}/meals")
//    public List<Meal> getMeals(@PathVariable(value = "categoryId") Long categoryId) {
//        return categoryService.getCategoryMeals(categoryId);
//    }
//
//    /**
//     *
//     * @param categoryId
//     * @param mealId
//     * @return
//     */
//    @GetMapping("/api/categories/{categoryId}/meals/{mealId}")
//    public  Meal getMeal(@PathVariable(value = "categoryId") Long categoryId, @PathVariable Long mealId) {
//        return categoryService.getCategoryMeal(categoryId,mealId);
//    }
//
//    /**
//     *
//     * @param categoryId
//     * @param mealId
//     * @return
//     */
//    @GetMapping("/api/categories/{categoryId}/meals/{mealId}/nutrition")
//    public Nutrition getNutrition(@PathVariable(value = "categoryId") Long categoryId, @PathVariable Long mealId) {
//        return categoryService.getNutrition(categoryId,mealId);
//    }
//
//    /**
//     *
//     * @param orderId
//     * @param customerId
//     * @param mealObject
//     * @return
//     */
////    @PutMapping("api/orders/{orderId}/customer/{customerId}")
////    public Order updateOrder(@PathVariable Long orderId,@PathVariable Long customerId, @RequestBody Order order){
////        return orderService.updateOrder(orderId,customerId,order);
////    }
//
//
//    //    api/customer/{customerId}/orders/{orderId}/meal	post
//    @PostMapping("/customer/{customerId}/orders/{orderId}/meal")
//    public Meal addMealToOrder(@PathVariable Long customerId,@PathVariable Long orderId, Meal mealObject ){
//
//        return customerOrderService.addMealToOrder(customerId,orderId,mealObject);
//    }
//
//



//    api/customer/{customerId}/orders/{orderId}	put
//    api/customer/{customerId}/orders	get
//    api/customers/{customerId}/payments	get
//    api/customers/{customerId}/payments/{paymentId}	get
//    api/customers/{customerId}/payments/{paymentId}	Delete
//    api/customers/{customerId}/payments	post
//    api/customers/{customerId}/payments/{paymentId}	put
//    api/customers/{customerId}/customerOrder/{customerOrderId}/delivery/{deliveryId}	get
//    api/customers/{customerId}/customerOrder/{customerOrderId}/delivery/{deliveryId}	put
//    api/customers/{customerId}/customerOrder/{customerOrderId}/tracking/{trackingId}	get
//    api/customers/{customerId}/customerOrder/{customerOrderId}/tracking/{trackingId}	put





}
