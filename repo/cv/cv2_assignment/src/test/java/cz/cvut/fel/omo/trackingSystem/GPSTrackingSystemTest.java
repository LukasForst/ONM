package cz.cvut.fel.omo.trackingSystem;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kuki on 22/09/2017.
 */
public class GPSTrackingSystemTest {
    private GPSTrackingSystemExposed companySpy;

    @Before
    public void setUp() {
        companySpy = new GPSTrackingSystemExposed();
    }

    @Test
    public void attachTrackingDevicesTest() {
        ArrayList<Vehicle> vehiclesToAdd = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            vehiclesToAdd.add(new Vehicle("", "", i));
        }

        companySpy.attachTrackingDevices(vehiclesToAdd);
        companySpy.getActiveTrackers().forEach(tracker -> assertTrue(vehiclesToAdd.contains(tracker.getCurrentVehicle())));
    }

}

class GPSTrackingSystemExposed extends GpsTrackingSystem {
    public ArrayList<Tracker> getActiveTrackers() {
        return new ArrayList<>(activeTrackers);
    }
}