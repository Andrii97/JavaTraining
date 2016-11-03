package ua;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by andrii on 30.10.16.
 */
public class ViewTest {

    public static View view;

    @BeforeClass
    public static void init(){
        view = new View();
    }

    @Test
    public void printMessageTest(){ }

    @Test(expected = Exception.class)
    public void printMessageAndLimitOrRangeTest(){
        view.printMessageAndLimitOrRange(null, 0, 0);
    }

    @Test
    public void printListOfAttemptsTest(){ }

}
