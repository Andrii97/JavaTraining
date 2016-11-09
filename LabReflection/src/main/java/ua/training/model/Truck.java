package ua.training.model;

/**
 * Created by andrii on 08.11.16.
 */
public class Truck extends Vehicle {
    /**
     *
     */
    private double bearingCapacity;

    /**
     *
     * @param brand
     * @param numberOfCylinders
     * @param power
     * @param bearingCapacity
     */
    public Truck(String brand, int numberOfCylinders, double power, double bearingCapacity) {
        super(brand, numberOfCylinders, power);
        this.bearingCapacity = bearingCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "bearingCapacity=" + bearingCapacity +
                "} " + super.toString();
    }
}
