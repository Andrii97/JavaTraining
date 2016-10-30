package ua;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by andrii on 30.10.16.
 */
public class ControllerTest {

    private static Controller controller;

    @BeforeClass
    public static void init() {
        controller = new Controller(null, null);
    }

    @Test(expected = Exception.class)
    public void runGameTest(){
        controller.runGame();
    }

    @Test(expected = NullPointerException.class)
    public void inputIntValueWithScannerTest() {
        controller.inputIntValueWithScanner(null);
    }
}
