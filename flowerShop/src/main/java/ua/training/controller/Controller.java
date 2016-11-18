package ua.training.controller;

import ua.training.model.Model;
import ua.training.model.entity.*;
import ua.training.view.View;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;


/**
 * Created by andrii on 18.11.16.
 */
public class Controller {

    /**
     *
     */
    Model model;

    /**
     *
     */
    View view;

    /**
     * initialize model and view
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    /**
     *
     */
    public void processUser(){
        ArrayList<Flower> flowers = initFlower();
        view.printMessage("Initial flowers");
        view.printMessage(flowers.toString());
        view.printMessage("");
        view.printMessage("Initial salableFlowers");
        ArrayList<SalableFlower> salableFlowers = initSalableFlower(flowers);
        view.printMessage(salableFlowers.toString());
        view.printMessage("");

        BouquetOfFlowers bouquet = model.createBouquetOfFlowers(salableFlowers);
        view.printMessage("Initial bouquet");
        view.printMessage(bouquet.toString());
        view.printMessage("");

        view.printMessage("flower to add");
        view.printMessage(salableFlowers.get(1).toString());
        view.printMessage("");

        view.printMessage("New bouquet");
        bouquet.addFlower(salableFlowers.get(1));
        view.printMessage(bouquet.toString());
        view.printMessage("");

        view.printMessage("SortByDateSupply");
        bouquet.sortByDateOfSupply();
        view.printMessage(bouquet.toString());
        view.printMessage("");

        view.printMessage("SortByLengthOfPlantStemRange [15.3; 18.8]");
        view.printMessage(bouquet.getFlowersByLengthOfPlantStemRange(15.3, 18.8).toString());

    }

    /**
     * Initialization flowers
     * @return ArrayList of flower
     */
    public ArrayList<Flower> initFlower() {
        ArrayList<Flower> flowers = new ArrayList<>();
        for (FlowerInit f : FlowerInit.values()) {
            Flower flower = new Flower(f.getName(), f.getColor(), f.getGenus(),
                    f.getLengthOfPlantStem());
            flowers.add(flower);
        }
        return flowers;
    }

    /**
     * Initialization salableFlowers
     * @param flowers ArrayList of flower
     * @return ArrayList of salableFlower
     */
    public ArrayList<SalableFlower> initSalableFlower(ArrayList<Flower> flowers) {
        ArrayList<SalableFlower> salableFlowers = new ArrayList<>();
        for (Flower flower : flowers) {
            Random random = new Random();
            SalableFlower salableFlower = new SalableFlower(flower,
                    random.nextDouble() * GlobalConstants.MAX_PRICE, LocalDate.of(GlobalConstants.YEAR,
                    Month.of(random.nextInt(GlobalConstants.MAX_MONTH) + 1),
                            random.nextInt(GlobalConstants.MAX_DAY) + 1));
            salableFlowers.add(salableFlower);
        }
        return salableFlowers;
    }

}
