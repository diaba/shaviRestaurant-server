package com.shavi.shavirestaurant.service;

import com.shavi.shavirestaurant.exception.InformationNotFoundException;
import com.shavi.shavirestaurant.model.CustomerOrder;
import com.shavi.shavirestaurant.model.Meal;
import com.shavi.shavirestaurant.model.Order;
import com.shavi.shavirestaurant.model.request.OrderRequest;
import com.shavi.shavirestaurant.repository.CustomerOrderRepository;
import com.shavi.shavirestaurant.repository.MealRepository;
import com.shavi.shavirestaurant.repository.OrderRepository;
import com.shavi.shavirestaurant.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private CustomerOrderRepository customerOrderRepository;
    private MealRepository mealRepository;


    @Autowired
    public void setCustomerOrderRepository(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    @Autowired
    public void setMealRepository(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

//    /**
//     * <p>Return all orders from the database</p>
//     * @return
//     */
//    public List<Order>getAllOrders(){
//        return orderRepository.findAll();
//    }
//
//    /**
//     * <p>Find a specific order</p>
//     * @param id
//     * @return
//     */
//    public Optional<Order> getOrder(Long id){
//        Optional<Order> order = orderRepository.findById(id);
//        if (order == null){
//            throw new InformationNotFoundException(" Order not found ");
//        }
//        return order;
//
//    }
//
    /**
     * <p>Create order with meal and quantity passing</p>
     * @param orderRequest
     * @return
     */
    public Order createOrder(OrderRequest orderRequest){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Order order = new Order();
        Optional<Meal> meal = mealRepository.findById(orderRequest.getMealId());
        if(meal.isEmpty()){
                throw new InformationNotFoundException("Meal not found");
        }
        order.setMeal(meal.get());
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrder(order);
        customerOrder.setCustomer(userDetails.getUser());
        customerOrder.setDate(new Date().toString());
        customerOrderRepository.save(customerOrder);
        order.setQuantity(orderRequest.getQuantity());
        return orderRepository.save(order);
    }
//
//    /**
//     * <p>Update order</p>
//     * @param orderId
//     * @param orderObject
//     * @return
//     */
//    public Order updateOrder(Long orderId, Order orderObject){
//        Optional<Order> order = getOrder(orderId);
//        if (order.isEmpty()){
//            throw new InformationNotFoundException("Order not found.");
//        }else{
//            order.get().setQuantity(orderObject.getQuantity());
//            order.get().setMeal(orderObject.getMeal());
//            return orderRepository.save(order.get());
//        }
//    }
//    public String deleteOrder(Long orderId){
//        Optional<Order> order = getOrder(orderId);
//        if (order.isEmpty()){
//            throw new InformationNotFoundException("Order not found.");
//        }else{
//            orderRepository.delete(order.get());
//            return "Order with id: "+orderId +" was successfully deleted";
//        }
//    }


}
