package com.anirudh.aopapp.services.impl;

import com.anirudh.aopapp.service.ShipmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShipmentServiceImplTest {

    @Autowired
    private ShipmentService shipmentService;

    @Test
    void aopTestOrderPackage(){
        shipmentService.orderPackage(4L);
    }

    @Test
    void aopTestTrackPackage(){
        shipmentService.trackPackage(4L);
    }

}
