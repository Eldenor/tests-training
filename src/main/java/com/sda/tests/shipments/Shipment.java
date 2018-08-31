package com.sda.tests.shipments;

import java.util.Objects;

public class Shipment {
    private User user;
    private Location location;
    private double price;

    public Shipment(User user, Location location, double price) {
        this.user = user;
        this.location = location;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return Double.compare(shipment.price, price) == 0 &&
                Objects.equals(user, shipment.user) &&
                Objects.equals(location, shipment.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, location, price);
    }
}
