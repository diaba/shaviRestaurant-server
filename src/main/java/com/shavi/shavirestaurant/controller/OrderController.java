package com.shavi.shavirestaurant.controller;

import com.shavi.shavirestaurant.model.Order;
import com.shavi.shavirestaurant.model.request.OrderRequest;
import com.shavi.shavirestaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "")
@CrossOrigin
public class OrderController {
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     *
     * @param request
     * @return
     */
    @PostMapping("/api/orders")
    Order createOrder(@RequestBody OrderRequest request){
        return orderService.createOrder(request);
    }

    /**
     *
     * @return
     */
    @GetMapping("/api/orders")
    public List<Order> getOrders(){
        return orderService.getOrders() ;
    }

    /**
     *
     * @param orderId
     * @return
     */
    @GetMapping("/api/orders/{orderId}")
    public Order getOrder(@PathVariable Long orderId){
        return orderService.getOrder(orderId) ;
    }

    /**
     *
     * @param orderId
     * @return
     */
    @PutMapping("/api/orders/{orderId}")
    public Order updateOrder(@PathVariable Long orderId, @RequestBody Order order){
        return orderService.updateOrder(orderId, order) ;
    }
    /**
     *
     * @param orderId
     * @return
     */
    @DeleteMapping("/api/orders/{orderId}")
    public String deleteOrder(@PathVariable Long orderId){
        return orderService.deleteOrder(orderId) ;
    }
}
