import org.junit.jupiter.api.Test;
import parking.ParkingLot;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {

    @Test
    public void checkIfCarIsParkedInParkingLot() {
        String carNumber = "MH-23-1111";
        ParkingLot parkingLot = new ParkingLot(2);

        boolean isParked = parkingLot.park(carNumber);

        assertTrue(isParked);

    }

    @Test
    public void checkIfCarIsParkingFullAndFailedToPark() {
        String carNumber1 = "MH-23-1111";
        String carNumber2 = "MH-23-1112";
        ParkingLot parkingLot = new ParkingLot(1);

        boolean isParked = parkingLot.park(carNumber1);

        isParked = parkingLot.park(carNumber2);

        assertFalse(isParked);
    }

    @Test
    public void checkIfMultipleCarsAreAllowedToParkInParkingLot(){
        String carNumber1 = "MH-23-1111";
        String carNumber2 = "MH-23-1112";
        ParkingLot parkingLot = new ParkingLot(4);

        boolean isFirstCarParked = parkingLot.park(carNumber1);
        assertTrue(isFirstCarParked);
        boolean isSecondCarParked = parkingLot.park(carNumber2);
        assertTrue(isSecondCarParked);
    }

    @Test
    public void checkIfVehicleIsParked(){
        ParkingLot parkingLot = new ParkingLot(4);
        String carNumber1 = "MH-23-1111";
        parkingLot.park(carNumber1);

        boolean isVehicleParked = parkingLot.isCarParked(carNumber1);
        assertTrue(isVehicleParked);
    }

    @Test
    public void checkDriverShouldBeAbleToUnParkTheVehicleIs(){
        ParkingLot parkingLot = new ParkingLot(4);
        String carNumber1 = "MH-23-1111";

        parkingLot.park(carNumber1);
        parkingLot.unPark(carNumber1);

        boolean isVehicleParked = parkingLot.isCarParked(carNumber1);
        assertFalse(isVehicleParked);
    }
}
