package com.sda.tests.shipments;

import javax.swing.text.html.Option;
import java.util.Optional;

public class ShipmentService {

    private LocationService locationService;

    private UserService userService;

    private PriceService priceService;

    public ShipmentService(LocationService locationService, UserService userService, PriceService priceService) {
        this.locationService = locationService;
        this.userService = userService;
        this.priceService = priceService;
    }

    public Optional<Shipment> sendToUser(User user, Location location){
        if(locationService.isLocationAllowd(location)){
            return Optional.empty();
        }

        double priceForShipment = priceService.getPriceForShipment(location, user);
        double finalPrice = userService.getLowerPriceForUser(priceForShipment, user);

        return Optional.of(new Shipment(user, location, finalPrice));
    }
}
