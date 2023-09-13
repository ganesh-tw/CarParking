import org.junit.jupiter.api.Test;
import parking.ParkingLot;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {
    @Test
    public void checkIfCarIsParkedInParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2);

        boolean isParked = parkingLot.park();

        assertTrue(isParked);
    }

    @Test
    public void checkIfCarIsParkingFullAndFailedToPark() {
        ParkingLot parkingLot = new ParkingLot(1);

        boolean isParked = parkingLot.park();

        isParked = parkingLot.park();

        assertFalse(isParked);
    }
}
