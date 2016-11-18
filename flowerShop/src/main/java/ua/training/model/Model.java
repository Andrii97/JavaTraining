package ua.training.model;

import ua.training.model.entity.BouquetOfFlowers;
import ua.training.model.entity.SalableFlower;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by andrii on 18.11.16.
 */
public class Model {

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


}
