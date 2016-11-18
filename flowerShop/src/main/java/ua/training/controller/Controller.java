package ua.training.controller;

import ua.training.model.Model;
import ua.training.view.View;

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

    }


}
