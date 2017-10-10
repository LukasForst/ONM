package cz.cvut.fel.omo.trackingSystem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kuki on 22/09/2017.
 */
public class TrackerTest {

    private Vehicle vehicle;
    private Tracker tracker;

    @Before
    public void setUp(){
        vehicle = new Vehicle("", "", 0);
        tracker = new Tracker(0);
        tracker.attachTracker(vehicle);
    }


    @Test
    public void attachTrackerTest(){
        assertEquals(vehicle, tracker.getCurrentVehicle());
    }

    @Test
    public void trackerMileageTest(){
        vehicle.drive(100);
        assertEquals(100, tracker.getTrackerMileage());

        tracker.resetTrackerMileage();
        assertEquals(0, tracker.getTrackerMileage());
    }

    @Test
    public void toStringTest(){
        String expected = "Tracker_[" + 0 + "], attached to [" + vehicle + "]";
        assertEquals(expected, tracker.toString());
    }
}