package com.anirudh.aopapp.service;

public interface ShipmentService {

    String orderPackage(Long orderId);
    String trackPackage(Long orderId);

}
