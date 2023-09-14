package parking;

import java.util.ArrayList;
import java.util.HashSet;

public class ParkingLot {
    private final int capacity;
    private int availableSlots;
    private final HashSet<Parkable> parkedVehicles = new HashSet<Parkable>();

    private final HashSet<ParkingLotObserver> observers = new HashSet<ParkingLotObserver>();
    private String parkingLotStatus = "Vacant";

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableSlots = capacity;
    }

    public void park(Parkable vehicle) {
        if (availableSlots > 0) {
            availableSlots--;
            parkedVehicles.add(vehicle);
            notifyObservers();
        }
    }

    private void notifyObservers() {
        if (availableSlots == 0) {
//                this.updateParkingLotStatus("Full");
            observers.forEach(observer -> observer.notifyMe("Full"));
        }
        if (availableSlots == 1) {
            observers.forEach(observer -> observer.notifyMe("Vacant"));
        }
    }

    public boolean isCarParked(Parkable vehicle) {
        return parkedVehicles.contains(vehicle);
    }

    public void unPark(Parkable vehicle) {
        if (isCarParked(vehicle)) {
            parkedVehicles.remove(vehicle);
            availableSlots++;
            notifyObservers();
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

    public void registerObserver(ParkingLotObserver observer) {
        observers.add(observer);
    }

    public void unRegisterObserver(ParkingLotObserver observer) {
       observers.remove(observer);
    }
}
