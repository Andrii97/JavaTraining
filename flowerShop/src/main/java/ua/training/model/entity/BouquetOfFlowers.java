package ua.training.model.entity;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by andrii on 18.11.16.
 */
public class BouquetOfFlowers implements Salable {

    /**
     *
     */
    private TreeMap<SalableFlower, Integer> flowers;

    /**
     * The Date of Supply
     */
    private LocalDate dateOfSupply;

    public BouquetOfFlowers() {
        flowers = new TreeMap<>();
        dateOfSupply = LocalDate.now();
    }

    public SortedMap<Double, SalableFlower> sortByFreshness(){
        return null;
    }

    /**
     * Add flower to bouquet of flowers
     * @param salableFlower flower that you want to add
     */
    public void addFlower(SalableFlower salableFlower) {
        if (salableFlower == null) {
            return;
        }
        if (flowers.containsKey(salableFlower)) {
            flowers.replace(
                    salableFlower,
                    flowers.get(salableFlower) + 1);
        } else {
            flowers.put(salableFlower, 1);
        }
    }

    /**
     * Remove flower from bouquet of flowers
     * @param flower
     * @return
     */
    public boolean removeFlower(SalableFlower flower) {
        if (flower == null) {
            return false;
        }
        if (flowers.containsKey(flower)) {
            if (flowers.get(flower) > 1) {
                flowers.replace(
                        flower,
                        flowers.get(flower) - 1
                );
            } else {
                flowers.remove(flower);
            }
            return true;
        }
        return false;
    }

    public SortedMap<Double, TreeMap<SalableFlower, Integer>> getFlowersByLengthOfPlantStemRange(
            double left, double right) {
        TreeMap treeMap = new TreeMap<Double, TreeMap<SalableFlower, Integer>>();

        return null;//flowers.subMap(left, right);
    }

    /**
     *
     * @return
     */
    @Override
    public double getPrice() {
        double price = 0;
/*
        for (SalableFlower flower : flowers) {
            price += flower.getPrice();
        }
*/
        for(Map.Entry<SalableFlower, Integer> flower : flowers.entrySet()) {
            price += flower.getKey().getPrice();
        }
        return price;
    }

    @Override
    public LocalDate getDateOfSupply() {
        return null;
    }

    @Override
    public String toString() {
        return "BouquetOfFlowers{" +
                "flowers=" + flowers +
                '}';
    }
}
