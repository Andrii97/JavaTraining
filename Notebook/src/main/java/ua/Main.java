package ua;

import ua.controller.Controller;
import ua.model.Model;
import ua.view.View;

/**
 * Console input data into a notebook
 *
 */
public class Main {

    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }

}