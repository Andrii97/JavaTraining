package ua.training.model.entity;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This class represents state and functionality of bouquetOfFlowers entity
 * @author Andrii Severin
 * @version 1.0 18 NOV 2016
 */
public class BouquetOfFlowers implements Salable {

    /**
     * List of salable flowers
     */
    private List<SalableFlower> listOfFlowers;

    /**
     * List of accessory
     */
    private List<Accessory> listOfAccessory;

    /**
     * The Date of Supply
     */
    private LocalDate dateOfSupply;

    /**
     * Initializes fields
     */
    public BouquetOfFlowers() {
        dateOfSupply = LocalDate.now();
        listOfFlowers = new ArrayList<>();
        listOfAccessory = new ArrayList<>();
    }

    /**
     * Add accessory to bouquet of flowers
     * @param accessory that you want to add
     */
    public void addAccessory(Accessory accessory) {
        if (accessory == null) {
            return;
        }
        listOfAccessory.add(accessory);
    }

    /**
     * Removes accessory from bouquet of flowers
     * @param accessory accessory that you want to remove
     * @return <tt>true</tt> if this list contained the specified element
     */
    public boolean removeAccessory(Accessory accessory) {
        return listOfAccessory.remove(accessory);
    }

    /**
     * Add flower to bouquet of flowers
     * @param salableFlower flower that you want to add
     */
    public void addFlower(SalableFlower salableFlower) {
        if (salableFlower == null) {
            return;
        }
        listOfFlowers.add(salableFlower);
    }

    /**
     * Removes flower from bouquet of flowers
     * @param flower flower that you want to remove
     * @return <tt>true</tt> if this list contained the specified element
     */
    public boolean removeFlower(SalableFlower flower) {
        return listOfFlowers.remove(flower);
    }

    /**
     * Sorts list of flower by date of supply
     */
    public void sortByDateOfSupply(){
        Comparator comparatorByDateOfSupply = Comparator
                .comparing(SalableFlower::getDateOfSupply);
        Collections.sort(listOfFlowers, comparatorByDateOfSupply);
    }

    /**
     * Finds list of salableFlowers that app
     * @param condition Predicate to filter salableFlowers.
     * @return List of appropriate salableFlowers
     */
    public List<SalableFlower> findFlowers(Predicate<SalableFlower> condition) {
        return listOfFlowers.stream().filter(condition).collect(Collectors.toList());
    }

    /**
     * Get total price of bouquet
     * @return Total price
     */
    @Override
    public double getPrice() {
        double price = 0;
        for (SalableFlower flower : listOfFlowers) {
            price += flower.getPrice();
        }
        for (Accessory accessory : listOfAccessory) {
            price += accessory.getPrice();
        }
        return price;
    }

    public List<SalableFlower> getListOfFlowers() {
        return listOfFlowers;
    }

    public List<Accessory> getListOfAccessory() {
        return listOfAccessory;
    }

    @Override
    public LocalDate getDateOfSupply() {
        return dateOfSupply;
    }

    @Override
    public String toString() {
        return "BouquetOfFlowers{" +
                "flowers=" + listOfFlowers +//flowers +
                '}';
     }
}
