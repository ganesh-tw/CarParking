package parking;

import java.util.HashSet;

public class ParkingLot {
    private final int capacity;
    private int availableSlots;
    private final HashSet<Parkable> parkedVehicles = new HashSet<Parkable>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableSlots = capacity;
    }

    public boolean park(Parkable vehicle) {
        if (availableSlots > 0) {
            availableSlots--;
            parkedVehicles.add(vehicle);
            return true;
        }
        return false;
    }

    public boolean isCarParked(Parkable vehicle) {
        return parkedVehicles.contains(vehicle);
    }

    public void unPark(Parkable vehicle) {
        parkedVehicles.remove(vehicle);
        availableSlots++;
        if (parkedVehicles.isEmpty()) {
            availableSlots = this.capacity;
        }
    }
}
