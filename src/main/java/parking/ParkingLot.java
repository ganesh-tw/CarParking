package parking;

import java.util.HashSet;

public class ParkingLot {
    private final int capacity;
    private int availableSlots;
    private final HashSet<String> parkedVehicles = new HashSet<String>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableSlots = capacity;
    }

    public boolean park(String carIdentifier) {
        if (availableSlots > 0) {
            availableSlots--;
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
        availableSlots++;
        if (parkedVehicles.isEmpty()) {
            availableSlots = this.capacity;
        }
    }
}
