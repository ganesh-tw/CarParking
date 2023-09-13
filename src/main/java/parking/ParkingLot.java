package parking;

public class ParkingLot {
    int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean park() {
        if (capacity > 0) {
            capacity--;
            return true;
        }
        return false;
    }
}
