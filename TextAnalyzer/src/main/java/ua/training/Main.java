package ua.training;

import ua.training.controller.Controller;
import ua.training.model.Model;
import ua.training.view.View;

/**
 * This class is used for initialization and to start the program
 * @author Andrii Severin
 * @version 1.0 08 DEC 2016
 */
public class Main
{
    /**
     * Initializes all units of MVC architecture and runs the processUser
     * @param args do not used
     */
    public static void main( String[] args ){
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();

    }
}
