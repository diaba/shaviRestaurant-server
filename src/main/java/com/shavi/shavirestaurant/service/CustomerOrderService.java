package com.shavi.shavirestaurant.service;

import com.shavi.shavirestaurant.exception.InformationNotFoundException;
import com.shavi.shavirestaurant.model.CustomerOrder;
import com.shavi.shavirestaurant.model.Order;
import com.shavi.shavirestaurant.model.Tracking;
import com.shavi.shavirestaurant.repository.CustomerOrderRepository;
import com.shavi.shavirestaurant.repository.TrackingRepository;
import com.shavi.shavirestaurant.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerOrderService {
    private CustomerOrderRepository customerOrderRepository;
    private TrackingRepository trackingRepository;

    @Autowired
    public void setCustomerOrderRepository(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    @Autowired
    public void setTrackingRepository(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }

    /**
     * <p>Get all order details</p>
     * @return
     */
    public List<CustomerOrder> getAllCustomerOrders(){
        return customerOrderRepository.findAll();
    }

    /**
     * <p>Get an specific Order details by id</p>
     * @param customerOrderId
     * @return
     */
    public CustomerOrder getCustomerOrder( Long customerOrderId){
        Optional<CustomerOrder> customerOrder = customerOrderRepository.findById(customerOrderId);
        if(customerOrder.isEmpty()){
            throw new InformationNotFoundException("Order details with id: "+customerOrderId +" was not found");
        }
        return customerOrder.get();
    }
    /**
     * <p>Order details by customer</p>
     * @param customerId
     * @return
     */
    public List<CustomerOrder> getAllCustomerOrdersByCustomerId(Long customerId){
        return customerOrderRepository.findAllByCustomerId(customerId);
    }

//    public Order updateCustomerOrder(Long orderId, Long customerID, Order orderObject){
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//
//        Optional<Order> order = order
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

    /**
     * <p>Add tracking order detail</p>
     * @param customerOrderId
     * @return
     */
    public Tracking createTracking(Long customerOrderId){
        try{
            CustomerOrder customerOrder = getCustomerOrder(customerOrderId);
            Tracking tracking = new Tracking();
            tracking.setCustomerOrder(customerOrder);
            tracking.setStatus("Confirmed");
            return trackingRepository.save(tracking);

        }catch (Exception e){
            throw new InformationNotFoundException("Operation cancelled");
        }
    }

    public Tracking getTracking(Long trackingId){
        Tracking tracking = trackingRepository.getById(trackingId);
        if (tracking == null){
            throw new InformationNotFoundException("Tracking with id: "+trackingId+" was not found");
        }
        return tracking;
    }

    /**
     * <p>Update the status</p>
     * @param trackingId
     * @param trackingObject
     * @return
     */
    public Tracking updateTracking(Long trackingId, Tracking trackingObject){
        try{
            Tracking tracking = getTracking(trackingId);
            tracking.setStatus(trackingObject.getStatus());
           return trackingRepository.save(tracking);
        }catch (Exception e){
            throw new InformationNotFoundException("Operation was cancelled");
        }
    }





}
