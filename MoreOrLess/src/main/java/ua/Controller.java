package ua;

import java.util.Scanner;

/**
 * Created by andrii on 30.10.16.
 */
public class Controller {
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
     * set barriers
     * set secret value
     * while not correct value read and user value
     * show history of attempts
     */
    public void runGame(){
        Scanner sc = new Scanner(view.INPUT_STREAM);

        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);
        model.setSecretValue();
        // System.out.println(model.getSecretValue());
        while (!model.isCorrectValue(inputIntValueWithScanner(sc))){}

        view.printMessage(View.CONGRATULATION + model.getSecretValue());
        view.printMessage(view.LIST_OF_ATTEMPTS);
        view.printList(model.getListOfAttempts());
        view.printMessage(view.NUMBER_OF_ATTEMPTS + model.getListOfAttempts().size());
    }

    // The Utility methods

    /**
     * Scan stream and recognize integer value
     * @param sc Input stream
     * @return Integer value in the current range [maxBarrier; minBarrier]
     */
    public int inputIntValueWithScanner(Scanner sc) {
        int res = 0;
        view.printMessageAndLimitOrRange(view.CURRENT_RANGE,
                model.getMinBarrier(), model.getMaxBarrier());
        view.printMessage(view.INPUT_INT_DATA);
        while( true ) {
            // check int - value
            while (!sc.hasNextInt()) {
                view.printMessage(View.WRONG_INPUT_INT_DATA);
                view.printMessage(View.CURRENT_RANGE);
                view.printMessage(View.INPUT_INT_DATA);
                sc.next();
            }
            // check value in diapason
            if ((res = sc.nextInt()) <= model.getMinBarrier() ||
                    res >= model.getMaxBarrier()) {
                view.printMessage(View.WRONG_RANGE_DATA);
                view.printMessageAndLimitOrRange(view.CURRENT_RANGE,
                        model.getMinBarrier(), model.getMaxBarrier());
                view.printMessage(View.INPUT_INT_DATA);
                continue;
            }
            break;
        }
        return res;
    }

}
