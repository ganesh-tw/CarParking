import org.junit.jupiter.api.Test;
import parking.ParkingLot;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {

    @Test
    public void checkIfCarIsParkedInParkingLot() {
        Vehicle car = new Vehicle();
        ParkingLot parkingLot = new ParkingLot(2);

        boolean isParked = parkingLot.park(car);

        assertTrue(isParked);

    }

    @Test
    public void checkIfCarIsParkingFullAndFailedToPark() {
        Vehicle car1 = new Vehicle();
        Vehicle car2 = new Vehicle();
        ParkingLot parkingLot = new ParkingLot(1);

        boolean isParked = parkingLot.park(car1);

        isParked = parkingLot.park(car2);

        assertFalse(isParked);
    }

    @Test
    public void checkIfMultipleCarsAreAllowedToParkInParkingLot(){
        Vehicle car1 = new Vehicle();
        Vehicle car2 = new Vehicle();
        ParkingLot parkingLot = new ParkingLot(4);

        boolean isFirstCarParked = parkingLot.park(car1);
        assertTrue(isFirstCarParked);
        boolean isSecondCarParked = parkingLot.park(car2);
        assertTrue(isSecondCarParked);
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
    public void checkDriverShouldBeAbleToUnParkTheVehicleIs(){
        ParkingLot parkingLot = new ParkingLot(4);
        Vehicle car = new Vehicle();

        parkingLot.park(car);
        parkingLot.unPark(car);

        boolean isVehicleParked = parkingLot.isCarParked(car);
        assertFalse(isVehicleParked);
    }
}
