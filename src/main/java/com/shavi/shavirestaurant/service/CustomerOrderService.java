package com.shavi.shavirestaurant.service;

import com.shavi.shavirestaurant.model.CustomerOrder;
import com.shavi.shavirestaurant.model.Order;
import com.shavi.shavirestaurant.repository.CustomerOrderRepository;
import com.shavi.shavirestaurant.repository.MealRepository;
import com.shavi.shavirestaurant.repository.OrderRepository;
import com.shavi.shavirestaurant.repository.TrackingRepository;
import com.shavi.shavirestaurant.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerOrderService {
    private CustomerOrderRepository customerOrderRepository;
    private OrderRepository orderRepository;
    private TrackingService trackingService;
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
    public void setTrackingService(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    /**
     * @param customerOrder
     */
    public void createCustomerOrder(CustomerOrder customerOrder) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        customerOrder.setCustomer(userDetails.getUser());
        customerOrder.setDate(java.time.LocalDate.now().toString());
        CustomerOrder newCustomerOrder = customerOrderRepository.save(customerOrder);
        // create tracking
        trackingService.createTracking(newCustomerOrder);
    }

    /**
     *
     * @param orderId
     * @param orderObject
     */
    public void updateCustomerOrder(Long orderId, Order orderObject) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        CustomerOrder customerOrder = customerOrderRepository.findByOrderIdAndCustomerId(orderId, userDetails.getUser().getId());
        customerOrder.setOrder(orderObject);
        customerOrderRepository.save(customerOrder);
    }

    /**
     *
     * @param orderId
     */
    public void deleteCustomerOrder(Long orderId) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        CustomerOrder customerOrder = customerOrderRepository.findByOrderIdAndCustomerId(orderId, userDetails.getUser().getId());
        customerOrderRepository.delete(customerOrder);
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