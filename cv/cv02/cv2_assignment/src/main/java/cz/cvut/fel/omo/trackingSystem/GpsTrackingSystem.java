package cz.cvut.fel.omo.trackingSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuki on 22/09/2017.
 * GpsTrackingSystem class represents the newly introduced tool for gaining control over company car park.
 */
public class GpsTrackingSystem {
    private static int counter = 0;

    protected ArrayList<Tracker> activeTrackers = new ArrayList<>();

    public void attachTrackingDevices(List<Vehicle> vehicles){
        for (Vehicle vehicle: vehicles) {
            Tracker tracker = new Tracker(counter++);
            tracker.attachTracker(vehicle);
            activeTrackers.add(tracker);
        }
    }

    public void generateMonthlyReport(){
        System.out.println("—– GPS Tracking system: Monthly report —–");
        activeTrackers.forEach(System.out::println);
        int finalDistance = activeTrackers.stream().mapToInt(Tracker::getTrackerMileage).sum();
        System.out.println("This month traveled distance: " + finalDistance + ".");
    }

}
