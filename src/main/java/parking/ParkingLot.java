package parking;

import java.util.HashSet;

public class ParkingLot {
    private final int capacity;
    private int availableSlots;
    private final HashSet<Parkable> parkedVehicles = new HashSet<Parkable>();

    private String parkingLotStatus = "Vacant";

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableSlots = capacity;
    }

    public void park(Parkable vehicle) {
        if (availableSlots > 0) {
            availableSlots--;
            parkedVehicles.add(vehicle);
            if (availableSlots == 0) {
                this.updateParkingLotStatus("Full");
            }
        }
    }

    public boolean isCarParked(Parkable vehicle) {
        return parkedVehicles.contains(vehicle);
    }

    public void unPark(Parkable vehicle) {
        if (isCarParked(vehicle)) {
            parkedVehicles.remove(vehicle);
            availableSlots++;
        }

        if (parkedVehicles.isEmpty()) {
            availableSlots = this.capacity;
        }
    }

    private void updateParkingLotStatus(String status) {
        this.parkingLotStatus = status;
    }

    public String getParkingLotStatus(){
        return this.parkingLotStatus;
    }
}
