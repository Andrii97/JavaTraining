package ua.training.model.entity;

import java.time.LocalDate;

/**
 * Created by andrii on 18.11.16.
 */
public class SalableFlower implements Salable, Comparable {

    /**
     * The flower
     */
    private Flower flower;

    /**
     * The price of flower
     */
    private double price;

    /**
     * The date of supply
     */
    private LocalDate dateOfSupply;

    /**
     * Parameterized constructor with all parameters
     * @param flower
     * @param price
     * @param dateOfSupply
     */
    public SalableFlower(Flower flower, double price, LocalDate dateOfSupply) {
        this.flower = flower;
        this.price = price;
        this.dateOfSupply = dateOfSupply;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public LocalDate getDateOfSupply() {
        return dateOfSupply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalableFlower)) return false;

        SalableFlower that = (SalableFlower) o;

        if (Double.compare(that.price, price) != 0) return false;
        if (!flower.equals(that.flower)) return false;
        return dateOfSupply != null ? dateOfSupply.equals(that.dateOfSupply) : that.dateOfSupply == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = flower.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dateOfSupply != null ? dateOfSupply.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (this.equals(o)) {
            return 0;
        } else if (this.getFlower().getLengthOfPlantStem() >
                ((SalableFlower)o).getFlower().getLengthOfPlantStem()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "SalableFlower{" +
                "flower=" + flower +
                /*", price=" + price +
                ", dateOfSupply=" + dateOfSupply*/ +
                '}';
    }

}
