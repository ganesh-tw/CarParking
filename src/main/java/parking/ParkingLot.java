package parking;

public class ParkingLot {
    int parkingSpaceCount;

    public ParkingLot(int parkingSpaceCount) {
        this.parkingSpaceCount = parkingSpaceCount;
    }

    public boolean park() {
        if (parkingSpaceCount>0) {
            parkingSpaceCount--;
            return true;
        }
        return false;
    }
}
