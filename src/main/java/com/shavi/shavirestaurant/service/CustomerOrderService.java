package com.shavi.shavirestaurant.service;

import com.shavi.shavirestaurant.exception.InformationNotFoundException;
import com.shavi.shavirestaurant.model.CustomerOrder;
import com.shavi.shavirestaurant.model.Meal;
import com.shavi.shavirestaurant.model.Order;
import com.shavi.shavirestaurant.model.Tracking;
import com.shavi.shavirestaurant.model.request.OrderRequest;
import com.shavi.shavirestaurant.repository.CustomerOrderRepository;
import com.shavi.shavirestaurant.repository.MealRepository;
import com.shavi.shavirestaurant.repository.OrderRepository;
import com.shavi.shavirestaurant.repository.TrackingRepository;
import com.shavi.shavirestaurant.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerOrderService {
    private CustomerOrderRepository customerOrderRepository;
    private OrderRepository orderRepository;
    private TrackingRepository trackingRepository;
    private MealRepository mealRepository;

    @Autowired
    public void setMealRepository(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setCustomerOrderRepository(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    @Autowired
    public void setTrackingRepository(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }


    public Order createOrder(OrderRequest orderRequest){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         Order order = new Order();
         Optional<Meal> meal = mealRepository.findById(orderRequest.getMealId());
         if(meal.isEmpty()){
             throw new InformationNotFoundException("Meal not found");
         }
         order.setMeal(meal.get());
         order.setQuantity(orderRequest.getQuantity());
         //update orderdetails
      //  CustomerOrder customerOrder = new CustomerOrder();
        Order newOrder = orderRepository.save(order);
//        customerOrder.setCustomer(userDetails.getUser());
//        customerOrder.setOrder(order);
//        customerOrder.setDate(java.time.LocalDate.now().toString());
//        customerOrderRepository.save(customerOrder);
        return newOrder;
    }




//    /**
//     * <p>Get all order details</p>
//     * @return
//     */
//    public List<CustomerOrder> getAllCustomerOrders(){
//        return customerOrderRepository.findAll();
//    }
//
//    /**
//     * <p>Get an specific Order details by id</p>
//     * @param customerOrderId
//     * @return
//     */
//    public CustomerOrder getCustomerOrder( Long customerOrderId){
//        Optional<CustomerOrder> customerOrder = customerOrderRepository.findById(customerOrderId);
//        if(customerOrder.isEmpty()){
//            throw new InformationNotFoundException("Order details with id: "+customerOrderId +" was not found");
//        }
//        return customerOrder.get();
//    }
//    /**
//     * <p>Order details by customer</p>
//     * @param customerId
//     * @return
//     */
//    public List<CustomerOrder> getAllCustomerOrdersByCustomerId(Long customerId){
//        return customerOrderRepository.findAllByCustomerId(customerId);
//    }
//    /**
//     * <p> Add meal to customer order</p>
//     * @param customerId
//     * @param orderId
//     * @param mealObject
//     * @return
//     */
//    public Meal addMealToOrder(Long customerId, Long orderId, Meal mealObject) {
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        CustomerOrder customerOrder = customerOrderRepository.findByOrderIdAndCustomerId(orderId,userDetails.getUser().getId());
//        if (customerOrder == null){
//            throw new InformationNotFoundException("Order with id "+orderId +" does not exist");
//        }
//        else{
//            Order order = customerOrder.getOrder();
//            boolean isMealInOrder = mealRepository.existsOrderListAndName(orderId, mealObject.getName());
////            if (isMealInOrder){
////                order.setQuantity(order.getQuantity() + );
////            }
//            order.setMeal(mealObject);
//            orderRepository.save(order);
//            return mealObject;
//
//            //if meal is in the list increase quantity
//        }
//    }
////    public Order updateCustomerOrder(Long orderId, Long customerID, Order orderObject){
////        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
////                .getPrincipal();
////
////        Optional<Order> order = order
////        if (order.isEmpty()){
////            throw new InformationNotFoundException("Order not found.");
////        }else{
////            order.get().setQuantity(orderObject.getQuantity());
////            order.get().setMeal(orderObject.getMeal());
////            return orderRepository.save(order.get());
////        }
////    }
////    public String deleteOrder(Long orderId){
////        Optional<Order> order = getOrder(orderId);
////        if (order.isEmpty()){
////            throw new InformationNotFoundException("Order not found.");
////        }else{
////            orderRepository.delete(order.get());
////            return "Order with id: "+orderId +" was successfully deleted";
////        }
////    }
//
//    /**
//     * <p>Add tracking order detail</p>
//     * @param customerOrderId
//     * @return
//     */
//    public Tracking createTracking(Long customerOrderId){
//        try{
//            CustomerOrder customerOrder = getCustomerOrder(customerOrderId);
//            Tracking tracking = new Tracking();
//            tracking.setCustomerOrder(customerOrder);
//            tracking.setStatus("Confirmed");
//            return trackingRepository.save(tracking);
//
//        }catch (Exception e){
//            throw new InformationNotFoundException("Operation cancelled");
//        }
//    }
//
//    public Tracking getTracking(Long trackingId){
//        Tracking tracking = trackingRepository.getById(trackingId);
//        if (tracking == null){
//            throw new InformationNotFoundException("Tracking with id: "+trackingId+" was not found");
//        }
//        return tracking;
//    }
//
//    /**
//     * <p>Update the status</p>
//     * @param trackingId
//     * @param trackingObject
//     * @return
//     */
//    public Tracking updateTracking(Long trackingId, Tracking trackingObject){
//        try{
//            Tracking tracking = getTracking(trackingId);
//            tracking.setStatus(trackingObject.getStatus());
//           return trackingRepository.save(tracking);
//        }catch (Exception e){
//            throw new InformationNotFoundException("Operation was cancelled");
//        }
//    }


//    public Order addMealToOrder(){
//
//    }
























}
