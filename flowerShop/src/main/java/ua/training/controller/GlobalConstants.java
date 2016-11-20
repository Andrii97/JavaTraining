package ua.training.controller;

/**
 * This interface describes global constants that can be used
 * to generate random initial salableFlowers
 * @author Andrii Severin
 * @version 1.0 18 NOV 2016
 */
public interface GlobalConstants {
    /**
     *  Maximum price for salableFlower
     */
    int MAX_PRICE = 1234;
    /**
     * Year for dateOfSupply salableFlower
     */
    int YEAR = 2016;
    /**
     * Maximum month for dateOfSupply salableFlower
     */
    int MAX_MONTH = 12;
    /**
     * Maximum day for dateOfSupply salableFlower
     */
    int MAX_DAY = 27;

    /**
     * Maximum length of plant stem for find flowers in the range
     */
    double MAX_LENGTH_OF_PLANT_STEM = 18.8;

    /**
     * Minimum length of plant stem for find flowers in the range
     */
    double MIN_LENGTH_OF_PLANT_STEM = 15.3;
}
