package com.sda.tests.shipments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;

class ShipmentServiceTest {

    //MOCKS
    private UserService userService;
    private LocationService locationService;
    private PriceService priceService;


    //REAL OBJECT
    private ShipmentService shipmentService;

    @BeforeEach
    void setUp(){
        userService = mock(UserService.class);
        locationService = mock(LocationService.class);
        priceService = mock(PriceService.class);
    }

    @Test
    void sendToUser_shouldNotSend_locationNotAllowed() {

    }

    @Test
    void sendToUser_shouldSend_withRegularPrice() {

    }

    @Test
    void sendToUser_shouldSend_withReducedPrice() {

    }
}