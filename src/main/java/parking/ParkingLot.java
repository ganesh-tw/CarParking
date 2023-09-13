package parking;

public class ParkingLot {
    private int capacity;

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
