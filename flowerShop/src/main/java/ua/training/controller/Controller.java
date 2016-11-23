package ua.training.controller;

import ua.training.init.FlowerInit;
import ua.training.model.Model;
import ua.training.model.entity.*;
import ua.training.view.View;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Predicate;


/**
 * This class represents Controller unit of MVC based architecture of program "FlowerShop".
 * @author Andrii Severin
 * @version 1.0 18 NOV 2016
 */
public class Controller {

    /**
     * Reference to model unit of MVC based architecture of program
     */
    Model model;

    /**
     * Reference to view unit of MVC based architecture of program
     */
    View view;
    ArrayList<Flower> flowers = initFlower();

    /**
     * Initializes model and view
     * @param model reference to model unit of application
     * @param view reference to view unit of application
     */
    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    /**
     * Runs main program cycle
     */
    public void processUser(){

        view.printMessage(View.INITIAL + View.FLOWERS);
        view.printMessage(flowers.toString());
        view.printMessage(View.EMPTY_LINE);
        view.printMessage(View.INITIAL + View.SALABLE_FLOWERS);
        ArrayList<SalableFlower> salableFlowers = initSalableFlower(flowers);
        view.printMessage(salableFlowers.toString());
        view.printMessage(View.EMPTY_LINE);

        BouquetOfFlowers bouquet = model.createBouquetOfFlowers(salableFlowers);
        view.printMessage(View.INITIAL + View.BOUQUET);
        view.printMessage(bouquet.toString());
        view.printMessage(View.EMPTY_LINE);

        view.printMessage(View.FLOWER_TO_ADD);
        view.printMessage(salableFlowers.get(1).toString());
        view.printMessage(View.EMPTY_LINE);

        view.printMessage(View.BOUQUET);
        bouquet.addFlower(salableFlowers.get(1));
        view.printMessage(bouquet.toString());
        view.printMessage(View.EMPTY_LINE);

        view.printMessage(View.SORT_BY_DATE_OF_SUPPLY);
        bouquet.sortByDateOfSupply();
        view.printMessage(bouquet.toString());
        view.printMessage(View.EMPTY_LINE);

        view.printMessage(View.FLOWERS_THAT_ARE_IN_RANGE);
        Predicate<SalableFlower> condition = i -> (i.getFlower()
                .getLengthOfPlantStem() > GlobalConstants.MIN_LENGTH_OF_PLANT_STEM) &&
                (i.getFlower().getLengthOfPlantStem() < GlobalConstants.MAX_LENGTH_OF_PLANT_STEM);
        view.printMessage(bouquet.findFlowers(condition).toString());
    }

    /**
     * Initializes flowers
     * @return ArrayList of flower
     */
    public ArrayList<Flower> initFlower() {
        ArrayList<Flower> flowers = new ArrayList<>();
        for (FlowerInit flower : FlowerInit.values()) {
            flowers.add(flower.getFlower());
        }
        return flowers;
    }

    /**
     * Initializes salableFlowers
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
