package ua.controller;

import ua.model.Address;
import ua.model.Group;
import ua.model.Record;
import ua.view.View;
import ua.model.Model;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by andrii on 06.11.16.
 */
public class Controller {

    Model model;
    View view;

    // Constructor

    /**
     *
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method

    /**
     *
     */
    public void processUser(){
        Scanner sc = new Scanner(System.in);
        // while (true) {
            Record record = inputRecord(sc);
            model.addRecord(record);
            view.printRecordList(model.getRecord());
        // }

    }

    /**
     *
     * @param sc
     * @return
     */
    private Record inputRecord(Scanner sc) {
        String firstName = "232";
        String lastName = "34";
        String middleName="tr";
        String nickname="rtyt";
        String comment="Tghy";
        Group group = Group.EDUCATION;
        String homePhone = "565";
        String mobilePhone = "454";
        String additionalMobilePhone="tht";
        String email = "";
        String skype = " ";
        Address address = new Address("s","s","s","s", "s");
        Date dateOfCreation = new Date();
        Date dateOfLastModified = new Date();
        return new Record(firstName, lastName, middleName, nickname, comment,
                group, homePhone, mobilePhone, additionalMobilePhone, email,
                skype, address, dateOfCreation, dateOfLastModified);
    }

}
