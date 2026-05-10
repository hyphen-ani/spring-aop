package com.anirudh.aopapp.services.impl;

import com.anirudh.aopapp.service.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShipmentServiceImplTest {

    @Autowired
    private ShipmentService shipmentService;

    @Test
    void aopTestOrderPackage(){
        String orderString = shipmentService.orderPackage(4L);
        log.info(orderString);
    }

    @Test
    void aopTestTrackPackage(){
        shipmentService.trackPackage(4L);
    }

}
