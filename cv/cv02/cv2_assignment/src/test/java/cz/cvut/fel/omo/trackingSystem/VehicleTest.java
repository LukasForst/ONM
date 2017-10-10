package cz.cvut.fel.omo.trackingSystem;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kuki on 22/09/2017.
 */
public class VehicleTest {

    @Test
    public void driveTest(){
        Vehicle vehicle = new Vehicle("", "", 0);
        assertEquals(vehicle.getMileage(), 0);
        vehicle.drive(100);
        assertEquals(vehicle.getMileage(), 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void driveFailedTest(){
        Vehicle vehicle = new Vehicle("", "", 0);
        vehicle.drive(-1);
    }

    @Test
    public void toStringTest(){
        Vehicle vehicle = new Vehicle("", "", 0);
        String expected = "[" + vehicle.getManufacturer() + "], [" + vehicle.getVINCode() + "]";
        assertEquals(expected, vehicle.toString());
    }
}