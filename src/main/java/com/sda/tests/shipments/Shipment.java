package com.sda.tests.shipments;

public class Shipment {
    private User user;
    private Location location;
    private double price;

    public Shipment(User user, Location location, double price) {
        this.user = user;
        this.location = location;
        this.price = price;
    }
}
