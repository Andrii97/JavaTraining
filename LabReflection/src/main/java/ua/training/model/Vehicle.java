package ua.training.model;

/**
 * Created by andrii on 08.11.16.
 */
public class Vehicle {
    @AnnotationForFields
    /**
     *
     */
    public static final String DEFAULT_BRAND = "Renault";

    @AnnotationForFields
    /**
     *
     */
    private String brand;

    /**
     *
     */
    private int numberOfCylinders;

    @AnnotationForFields
    /**
     *
     */
    private double power;

    /**
     *
     */
    public Vehicle() {
    }

    /**
     *
     * @param brand
     * @param numberOfCylinders
     * @param power
     */
    public Vehicle(String brand, int numberOfCylinders, double power) {
        this.brand = brand;
        this.numberOfCylinders = numberOfCylinders;
        this.power = power;
    }

    protected void changeBrand(){
        this.brand = DEFAULT_BRAND;
    }

    @AnnotationForMethods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (numberOfCylinders != vehicle.numberOfCylinders) return false;
        if (Double.compare(vehicle.power, power) != 0) return false;
        return brand != null ? brand.equals(vehicle.brand) : vehicle.brand == null;

    }

    @AnnotationForMethods
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + numberOfCylinders;
        temp = Double.doubleToLongBits(power);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @AnnotationForMethods
    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", numberOfCylinders=" + numberOfCylinders +
                ", power=" + power +
                '}';
    }
}
