package com.anirudh.aopapp.service.impl;

import com.anirudh.aopapp.aspect.MyLoggingAnnotation;
import com.anirudh.aopapp.service.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Override
    @MyLoggingAnnotation
    public String orderPackage(Long orderId) {
//        log.info("orderPackage is called");
        try {
            log.info("Processing the order....");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Error occured while processing the order", e);
        }

        return "Order has been processed successfully, orderId: " + orderId;
    }

    @Override
    public String trackPackage(Long orderId) {
//        log.info("trackPackage is called");
        try {
            log.info("Tracking the package...");
            Thread.sleep(500);
            throw new RuntimeException("Exception occured during Tracking Package");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
