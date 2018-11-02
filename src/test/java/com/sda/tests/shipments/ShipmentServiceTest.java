package com.sda.tests.shipments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        shipmentService = new ShipmentService(locationService, userService, priceService);
    }

    @Test
    void sendToUser_shouldNotSend_locationNotAllowed() {
        //given

        Location userLocation = new Location(1, 2);
        User u1 = new User("u1", userLocation);

        when(locationService.isLocationAllowd(userLocation)).thenReturn(false);

        //when
        Optional<Shipment> actualShipmentResult = shipmentService.sendToUser(u1, userLocation);

        verify(locationService).isLocationAllowd(any());
        assertTrue(!actualShipmentResult.isPresent());
    }

    @Test
    void sendToUser_shouldSend_withRegularPrice() {

    }

    @Test
    void sendToUser_shouldSend_withReducedPrice() {

    }
}