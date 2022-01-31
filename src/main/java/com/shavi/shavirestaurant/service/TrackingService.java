package com.shavi.shavirestaurant.service;
import com.shavi.shavirestaurant.exception.InformationNotFoundException;
import com.shavi.shavirestaurant.model.CustomerOrder;
import com.shavi.shavirestaurant.model.Tracking;
import com.shavi.shavirestaurant.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrackingService {

    private TrackingRepository trackingRepository;

    @Autowired
    public void setTrackingRepository(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }

    /**
     *
     * @param customerOrder
     */
    public void createTracking(CustomerOrder customerOrder){
        Tracking tracking = new Tracking();
        tracking.setStatus("Confirmed");
        tracking.setCustomerOrder(customerOrder);
        trackingRepository.save(tracking);
    }

    /**
     *
     * @param customerOrder
     * @return
     */
    public Tracking getTracking(CustomerOrder customerOrder){
        Tracking tracking = trackingRepository.findByCustomerOrderId(customerOrder.getId());
        if(tracking == null){
            throw new InformationNotFoundException("Tracking with order with id "+customerOrder.getId() +" was not found");
        }
        return tracking;
    }

    /**
     *
     * @param trackingId
     * @return
     */
    public Tracking getTracking(Long trackingId){
        Optional<Tracking> tracking = trackingRepository.findById(trackingId);
        if (tracking.isEmpty()){
            throw new InformationNotFoundException("Tracking with order with id "+trackingId+" was not found");
        }
        return tracking.get();
    }

    /**
     *
     * @param trackingId
     * @param trackingObject
     * @return
     */
    public Tracking updateTracking(Long trackingId, Tracking trackingObject){
        Optional<Tracking> tracking = trackingRepository.findById(trackingId);
        if (tracking.isEmpty()){
            throw new InformationNotFoundException("Tracking with order with id "+trackingId +" was not found");
        }
       tracking.get().setStatus(trackingObject.getStatus());
       return trackingRepository.save(tracking.get());
    }




}

