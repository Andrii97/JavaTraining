package ua.training.controller;

import ua.training.model.FileSource;
import ua.training.model.Model;
import ua.training.model.Source;
import ua.training.model.entity.Container;
import ua.training.view.View;

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
     * Source of text
     */
    Source sourceOfText;

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
        Container text;
        try (Source sourceOfText = new FileSource(View.FILE_NAME)){
            text = model.loadText(sourceOfText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        view.printMessage(View.ORIGINAL_TEXT);
        view.printMessage(text.getContent());
        view.printMessage(View.UPDATED_TEXT);
        view.printMessage(model.removeWords(text, 2).getContent());
    }

}
