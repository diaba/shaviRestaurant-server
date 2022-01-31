package com.shavi.shavirestaurant.service;

import com.shavi.shavirestaurant.exception.InformationNotFoundException;
import com.shavi.shavirestaurant.model.Payment;
import com.shavi.shavirestaurant.repository.PaymentRepository;
import com.shavi.shavirestaurant.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    @Autowired
    public void setPaymentRepository(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    /**
     *
     * @return
     */
    public List<Payment> getPayments(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       return paymentRepository.findByCustomerId(userDetails.getUser().getId());
    }

    public Payment getPayment(Long paymentId){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Payment payment =  paymentRepository.findByCustomerIdAndId(userDetails.getUser().getId(),paymentId );
        if (payment == null){
            throw new InformationNotFoundException("Payment with id "+ paymentId +" was not found");
        }
        return payment;
    }
    /**
     *
     * @param payment
     * @return
     */
    public Payment createPayment(Payment payment){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        payment.setCustomer(userDetails.getUser());
        return  paymentRepository.save(payment);
    }

    /**
     *
     * @param paymentId
     * @param paymentObject
     * @return
     */
    public Payment updatePayment(Long paymentId, Payment paymentObject){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Payment payment = paymentRepository.findByCustomerIdAndId(userDetails.getUser().getId(), paymentId);
        if (payment == null){
            throw new InformationNotFoundException("Payment with id "+paymentId +" was not found");
        }
        payment.setCardName(paymentObject.getCardName());
        payment.setCardNumber(paymentObject.getCardNumber());
        return  paymentRepository.save(payment);
    }
    public String deletePayment(Long paymentId){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Payment payment = paymentRepository.findByCustomerIdAndId(userDetails.getUser().getId(), paymentId);
        if (payment == null){
            throw new InformationNotFoundException("Payment with id "+paymentId +" was not found");
        }
       paymentRepository.delete(payment);
        return "Payment with id "+paymentId +" was successfully deleted";
    }

}
