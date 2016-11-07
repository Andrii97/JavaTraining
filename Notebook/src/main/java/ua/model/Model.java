package ua.model;

import java.util.ArrayList;

/**
 * Created by andrii on 06.11.16.
 */
public class Model {

    /**
     *
     */
    private ArrayList<Record> recordBook;

    /**
     *
     */
    public Model() {
        recordBook = new ArrayList<>();
    }

    // The Program logic

    /**
     *
     * @param record
     */
    public void addRecord(Record record){
        recordBook.add(record);
    }

    public ArrayList<Record> getRecord() {
        return recordBook;
    }
}
