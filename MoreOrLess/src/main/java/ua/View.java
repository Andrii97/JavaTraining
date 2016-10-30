package ua;

import java.util.ArrayList;
import java.io.InputStream;

/**
 * Created by andrii on 30.10.16.
 */
public class View {
    // Text's constants
    public static final String INPUT_INT_DATA = "Input INT value = ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String LIST_OF_ATTEMPTS = "List of your attempts: ";
    public static final String CURRENT_RANGE = "Current range [%d;%d]\n";
    public static final String VICTORY = "You won";
    public static final String NUMBER_OF_ATTEMPTS = "Number of attempts ";
    public static final InputStream INPUT_STREAM = System.in;

    /**
     * Print message
     * @param message information to print
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * Add limits of the range to message, print range
     * @param message information to print
     * @param leftLimit
     * @param rightLimit
     */
    public void printMessageAndLimitOrRange(String message, int leftLimit, int rightLimit){
        System.out.format(message, leftLimit, rightLimit);
    }

    /**
     * Print list of attempts
     * @param listOfAttempts information to print
     */
    public void printListOfAttempts(ArrayList<Integer> listOfAttempts){
        System.out.println(listOfAttempts);
    }

}
