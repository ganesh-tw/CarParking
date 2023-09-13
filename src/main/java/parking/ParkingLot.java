package parking;

import java.util.HashSet;

public class ParkingLot {
    private int capacity;
    private final HashSet<String> parkedVehicles = new HashSet<String>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean park(String carIdentifier) {
        if (capacity > 0) {
            capacity--;
            parkedVehicles.add(carIdentifier);
            return true;
        }
        return false;
    }

    public boolean isCarParked(String carIdentifier) {
        return parkedVehicles.contains(carIdentifier);
    }

    public void unPark(String carIdentifier) {
        parkedVehicles.remove(carIdentifier);
    }
}
