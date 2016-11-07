package ua.view;

import ua.model.Record;

import java.util.ArrayList;

/**
 * Created by andrii on 06.11.16.
 */
public class View {
    // Text's constants
    public static final String INPUT_INT_DATA = "Input INT value = ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String OUR_INT = "INT value = ";

    /**
     *
     * @param message
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     *
     * @param recordBook
     */
    public void printRecordList(ArrayList<Record> recordBook) {
        for (Record r : recordBook) {
            System.out.println(r);
        }
    }
}