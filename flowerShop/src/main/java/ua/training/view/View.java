package ua.training.view;

/**
 * This class represents View unit of MVC based architecture of program "FlowerShop".
 * @author Andrii Severin
 * @version 1.0 18 NOV 2016
 */
public class View {

    // Text's constants
    public static final String INITIAL = "Initial ";
    public static final String FLOWERS = "flowers ";
    public static final String SALABLE_FLOWERS = "salableFlowers ";
    public static final String BOUQUET = "bouquet ";
    public static final String EMPTY_LINE = "";
    public static final String SORT_BY_DATE_OF_SUPPLY = "SortByDateOfSupply ";
    public static final String FLOWERS_THAT_ARE_IN_RANGE = "Flowers that are in range ";
    public static final String FLOWER_TO_ADD = "flower to add ";

    /**
     * Print message
     * @param message information to print
     */
    public void printMessage(String message){
        System.out.println(message);
    }


}