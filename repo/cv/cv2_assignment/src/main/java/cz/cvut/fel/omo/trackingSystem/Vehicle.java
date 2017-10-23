package cz.cvut.fel.omo.trackingSystem;

/**
 * Class Vehicle represents a single car in company car park.
 */
public class Vehicle {
    private String manufacturer;
    private int mileage;
    private String VINCode;

    public Vehicle(String manufacturer, String VINCode, int mileage) {
        this.manufacturer = manufacturer;
        this.mileage = mileage;
        this.VINCode = VINCode;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getMileage() {
        return mileage;
    }

    public String getVINCode() {
        return VINCode;
    }

    public void drive(int mileageNumber){
        if(mileageNumber < 0){
            throw new IllegalArgumentException("Argument must be greater than zero!");
        }
        mileage += mileageNumber;
    }

    @Override
    public String toString() {
        return "[" + manufacturer + "], [" + VINCode + "]";
    }
}
