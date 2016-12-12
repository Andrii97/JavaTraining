package ua.training.controller;

import ua.training.model.Model;
import ua.training.model.entity.Composite;
import ua.training.view.View;

import java.io.Console;

/**
 * This class represents Controller unit of MVC based architecture of program "TextAnalyzer".
 * @author Andrii Severin
 * @version 1.0 08 DEC 2016
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
        Composite text = model.loadText();

        view.printMessage(text.print().toString());
    }

}
