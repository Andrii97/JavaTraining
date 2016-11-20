package ua.training.model.entity;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by andrii on 18.11.16.
 */
public class BouquetOfFlowers implements Salable {

    /**
     * List of salable flowers
     */
    private ArrayList<SalableFlower> listOfFlowers;

    /**
     * The Date of Supply
     */
    private LocalDate dateOfSupply;

    public BouquetOfFlowers() {
        dateOfSupply = LocalDate.now();
        listOfFlowers = new ArrayList<>();
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
     * Remove flower from bouquet of flowers
     * @param flower
     * @return
     */
    public boolean removeFlower(SalableFlower flower) {
        return listOfFlowers.remove(flower);
    }

    /**
     * Sorting list of flower by date of supply
     */
    public void sortByDateOfSupply(){
        Comparator comparatorByDateOfSupply = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1.equals(o2)) {
                    return 0;
                } else if (((SalableFlower)o1).getDateOfSupply().getMonthValue() >
                        ((SalableFlower)o2).getDateOfSupply().getMonthValue()) {
                    return 1;
                } else if (((SalableFlower)o1).getDateOfSupply().getMonthValue() ==
                        ((SalableFlower)o2).getDateOfSupply().getMonthValue() &&
                        ((SalableFlower)o1).getDateOfSupply().getDayOfMonth() >
                                ((SalableFlower)o2).getDateOfSupply().getDayOfMonth()) {
                    return 1;
                } else {
                        return -1;
                }
            }
        };
        Collections.sort(listOfFlowers, comparatorByDateOfSupply);
    }

    /**
     * Get list of flowers which is in the range [left;right]
     * @param left left limit
     * @param right right limit
     * @return new list of appropriate flowers
     */
    public ArrayList<SalableFlower> getFlowersByLengthOfPlantStemRange(double left, double right) {
        ArrayList<SalableFlower> result = new ArrayList<>();
        for(SalableFlower f : listOfFlowers) {
            double length = f.getFlower().getLengthOfPlantStem();
            if (length > left && length < right) {
                result.add(f);
            }
        }
        return result;
    }

    /**
     * Get total price of bouquet
     * @return total price
     */
    @Override
    public double getPrice() {
        double price = 0;
        for (SalableFlower flower : listOfFlowers) {
            price += flower.getPrice();
        }
        return price;
    }

    public ArrayList<SalableFlower> getListOfFlowers() {
        return listOfFlowers;
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
