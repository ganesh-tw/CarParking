import org.junit.jupiter.api.Test;
import parking.ParkingLot;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    public void checkIfCarIsParkedInParkingLot() {
        Vehicle car = new Vehicle();
        ParkingLot parkingLot = new ParkingLot(2);

        parkingLot.park(car);
        boolean isParked = parkingLot.isCarParked(car);

        assertTrue(isParked);
    }

    @Test
    public void checkIfCarIsParkingFullAndFailedToPark() {
        Vehicle car1 = new Vehicle();
        Vehicle car2 = new Vehicle();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(car1);
        parkingLot.park(car2);


        boolean isParked = parkingLot.isCarParked(car2);

        assertFalse(isParked);
    }

    @Test
    public void checkIfMultipleCarsAreAllowedToParkInParkingLot(){
        Vehicle car1 = new Vehicle();
        Vehicle car2 = new Vehicle();
        ParkingLot parkingLot = new ParkingLot(4);

        parkingLot.park(car1);
        assertTrue(parkingLot.isCarParked(car1));
         parkingLot.park(car2);
        assertTrue(parkingLot.isCarParked(car2));
    }

    @Test
    public void checkIfVehicleIsParked(){
        ParkingLot parkingLot = new ParkingLot(4);
        Vehicle car = new Vehicle();
        parkingLot.park(car);

        boolean isVehicleParked = parkingLot.isCarParked(car);
        assertTrue(isVehicleParked);
    }

    @Test
    public void checkDriverShouldBeAbleToUnParkTheVehicleIs() {
        ParkingLot parkingLot = new ParkingLot(4);
        Vehicle car = new Vehicle();

        parkingLot.park(car);
        parkingLot.unPark(car);

        boolean isVehicleParked = parkingLot.isCarParked(car);
        assertFalse(isVehicleParked);
    }

    @Test
    public void checkParkingFullStatus() {
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle car = new Vehicle();

        parkingLot.park(car);

        String parkingStatus = parkingLot.getParkingLotStatus();
        assertEquals(parkingStatus, "Full");
    }
}
