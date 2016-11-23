package ua.training.model.entity;

import java.time.LocalDate;

/**
 * This class represents common state and functionality of accessory entity
 * @author Andrii Severin
 * @version 1.0 23 NOV 2016
 */
public class Accessory implements Salable {

    /**
     * Name of accessory
     */
    private String name;

    /**
     * Price of accessory
     */
    private double price;

    /**
     * The date of supply
     */
    private LocalDate dateOfSupply;

    /**
     * Type of accessory
     */
    private TypeOfAccessory type;

    public Accessory(String name, double price, LocalDate dateOfSupply, TypeOfAccessory type) {
        this.name = name;
        this.price = price;
        this.dateOfSupply = dateOfSupply;
        this.type = type;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public LocalDate getDateOfSupply() {
        return dateOfSupply;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfAccessory getType() {
        return type;
    }

    public void setType(TypeOfAccessory type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", dateOfSupply=" + dateOfSupply +
                ", type=" + type +
                '}';
    }
}
