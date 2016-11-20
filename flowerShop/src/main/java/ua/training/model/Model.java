package ua.training.model;

import ua.training.model.entity.BouquetOfFlowers;
import ua.training.model.entity.SalableFlower;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents Model unit of MVC based architecture of program "FlowerShop"
 * @author Andrii Severin
 * @version 1.0 18 NOV 2016
 */
public class Model {

    public ArrayList<BouquetOfFlowers> listOfBouquetOfFlowers = new ArrayList<>();

    /**
     * Create BouquetOfFlowers from list of SalableFlower
     * @param flowers ArrayList of SalableFlower
     * @return BouquetOfFlowers
     */
    public BouquetOfFlowers createBouquetOfFlowers(ArrayList<SalableFlower> flowers) {
        BouquetOfFlowers bouquet = new BouquetOfFlowers();
        for (SalableFlower flower : flowers) {
            bouquet.addFlower(flower);
        }
        return bouquet;
    }

    /**
     * Add bouquetOfFlowers to list of bouquetOfFlowers
     * @param bouquet Bouquet that you want to add
     */
    public void addBouquetOfFlowers(BouquetOfFlowers bouquet) {
        listOfBouquetOfFlowers.add(bouquet);
    }

    public ArrayList<BouquetOfFlowers> getListOfBouquetOfFlowers() {
        return listOfBouquetOfFlowers;
    }
}
