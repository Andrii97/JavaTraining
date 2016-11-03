package ua;

import java.util.ArrayList;
import java.io.InputStream;

/**
 * Created by andrii on 30.10.16.
 */
public class View {
    // Text's constants
    public static final String INPUT_INT_DATA = "Please, input INT value in appropriate range = ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String LIST_OF_ATTEMPTS = "List of your attempts: ";
    public static final String CURRENT_RANGE = "Current range [%d;%d]\n";
    public static final String NUMBER_OF_ATTEMPTS = "Number of attempts ";
    public static final String WRONG_RANGE_DATA = "Wrong range! Repeat please! ";
    public static final String CONGRATULATION = "CONGRATULATION!!! Secret value = ";
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
     * @param minBarrier Minimum barrier of range
     * @param maxBarrier Maximum barrier of range
     */
    public void printMessageAndLimitOrRange(String message, int minBarrier, int maxBarrier){
        System.out.format(message, minBarrier, maxBarrier);
    }

    /**
     * Print list
     * @param list information to print
     */
    public void printList(ArrayList<Integer> list){
        System.out.println(list);
    }

}
