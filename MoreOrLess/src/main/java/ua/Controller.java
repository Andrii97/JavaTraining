package ua;

import java.util.Scanner;

/**
 * Created by andrii on 30.10.16.
 */
public class Controller {
    // The Constants
    public static final int leftLimitRange = 0;
    public static final int rightLimitRange = 100;

    Model model;
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
     * Run game:
     * 1) generate value
     * 2) get userValue
     * 3) check value, change range
     * 4) show game information
     * 5) go to step 2, until userValue != correctValue
     * 6) show history of attempts
     */
    public void runGame(){
        model.generateValue(leftLimitRange, rightLimitRange);

        Scanner sc = new Scanner(view.INPUT_STREAM);
        boolean isFinishState = false;
        while (!isFinishState) {
            view.printMessage(view.LIST_OF_ATTEMPTS);
            view.printListOfAttempts(model.getListOfAttempts());
            view.printMessageAndLimitOrRange(view.CURRENT_RANGE,
                    model.getLeftLimit(), model.getRightLimit());
            isFinishState = model.isCorrectValue(inputIntValueWithScanner(sc));
        }
        view.printMessage(view.VICTORY);
        view.printMessage(view.LIST_OF_ATTEMPTS);
        view.printListOfAttempts(model.getListOfAttempts());
        view.printMessage(view.NUMBER_OF_ATTEMPTS + model.getListOfAttempts().size());
    }

    /**
     * Scan stream and recognize integer value
     * @param sc Input stream
     * @return integer value
     */
    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessage(view.INPUT_INT_DATA);
        while (! sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT_INT_DATA + "\n" + view.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }

}
