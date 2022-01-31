package com.shavi.shavirestaurant.controller;

import com.shavi.shavirestaurant.model.CustomerOrder;
import com.shavi.shavirestaurant.model.Tracking;
import com.shavi.shavirestaurant.service.CustomerOrderService;
import com.shavi.shavirestaurant.service.CustomerService;
import com.shavi.shavirestaurant.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/tracking/{trackingId}")
public class TrackingController {
    private TrackingService trackingService;

    @Autowired
    public void setTrackingService(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    /**
     *
     * @param trackingId
     * @return
     */
    @GetMapping
    public Tracking getTracking(@PathVariable Long trackingId){
        return trackingService.getTracking(trackingId);
    }

    @PutMapping
    public Tracking updateTracking(@PathVariable Long trackingId, @RequestBody Tracking tracking){
        return trackingService.updateTracking(trackingId, tracking);
    }
}
