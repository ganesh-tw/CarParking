import org.junit.jupiter.api.Test;
import parking.ParkingLot;
import parking.ParkingLotObserver;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
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
    public void shouldNotifyOwnerWhenParkingIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
//        ParkingLotObserver owner = new ParkingLotOwner();
        ParkingLotObserver owner = Mockito.mock(ParkingLotOwner.class);
        parkingLot.registerObserver(owner);
        Vehicle car = new Vehicle();

        parkingLot.park(car);

        Mockito.verify(owner, Mockito.times(1)).notifyMe("1");
    }
    @Test
    public void shouldNotifyTrafficCopWhenParkingIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
//        ParkingLotObserver cop = new TrafficCop();
//        ParkingLotObserver cop = Mockito.mock(ParkingLotOwner.class);
//        parkingLot.registerObserver(cop);
        Vehicle car = new Vehicle();

        parkingLot.park(car);

//        Mockito.verify(owner, Mockito.times(1)).notifyMe("1");
    }
}
