package com.sda.tests.shipments;

import java.time.LocalDateTime;

public interface LocationService {

    String getAddressForLocation(Location location);

    Location getLocationForAddress(String address);

    boolean isLocationAllowd(Location location);

}
