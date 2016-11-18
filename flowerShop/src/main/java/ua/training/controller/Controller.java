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
     *  max price for salableFlower
     */
    final static int MAX_PRICE = 1234;
    /**
     * year for dateOfSupply salableFlower
     */
    final static int YEAR = 2016;
    /**
     * max month for dateOfSupply salableFlower
     */
    final static int MAX_MONTH = 12;
    /**
     * max day for dateOfSupply salableFlower
     */
    final static int MAX_DAY = 27;

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
        view.printMessage(flowers.toString());
        ArrayList<SalableFlower> salableFlowers = initSalableFlower(flowers);
        view.printMessage(salableFlowers.toString());

        BouquetOfFlowers bouquet = model.createBouquetOfFlowers(salableFlowers);
        view.printMessage(bouquet.toString());
        view.printMessage(salableFlowers.get(1).toString());
        bouquet.addFlower(salableFlowers.get(1));
        view.printMessage(bouquet.toString());
        bouquet.removeFlower(salableFlowers.get(1));
        view.printMessage(bouquet.toString());
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
                    random.nextDouble() * MAX_PRICE, LocalDate.of(YEAR,
                    Month.of(MAX_MONTH), random.nextInt(MAX_DAY) + 1));
            salableFlowers.add(salableFlower);
        }
        return salableFlowers;
    }

}
