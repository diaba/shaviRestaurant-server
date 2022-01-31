package com.shavi.shavirestaurant.controller;

import com.shavi.shavirestaurant.model.Payment;
import com.shavi.shavirestaurant.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "")
@CrossOrigin
public class PaymentController {
    private PaymentService paymentService;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     *
     * @return
     */
    @GetMapping("/api/payments")
    public List<Payment> getPayments(){
        return paymentService.getPayments();
    }

    /**
     *
     * @param paymentId
     * @return
     */
    @GetMapping("/api/payments/{paymentId}")
    public Payment getPayment(@PathVariable Long paymentId){
        return paymentService.getPayment(paymentId);
    }

    /**
     *
     * @param payment
     * @return
     */
    @PostMapping("/api/payments")
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.createPayment(payment);
    }

    /**
     *
     * @param paymentId
     * @return
     */
    @DeleteMapping ("/api/payments/{paymentId}")
    public String deletePayment(@PathVariable Long paymentId){
        return paymentService.deletePayment(paymentId);
    }

    /**
     *
     * @param paymentId
     * @param payment
     * @return
     */
    @PutMapping ("/api/payments/{paymentId}")
    public Payment updatePayment(@PathVariable Long paymentId,@RequestBody Payment payment){
        return paymentService.updatePayment(paymentId, payment);
    }
}
