package ua;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by andrii on 30.10.16.
 */
public class ModelTest {

    public static final int min = 0;
    public static final int max = 100;

    private static Model model;

    @BeforeClass
    public static void init() {
        model = new Model();
    }

    @Before
    public void initValue() {
        model.generateValue(min, max);
    }

    @Test
    public void randIntTestCorrectArgs(){
        int randomNum = model.randInt(min, max);
        assertTrue(randomNum >= min && randomNum <= max);
    }

    @Test(expected = Exception.class)
    public void randIntTestIncorrectArgs(){
        model.randInt(max, min);
    }

    @Test
    public void generateValueTest(){
        int value = model.getValue();
        assertTrue(value >= model.getLeftLimit() && value <= model.getRightLimit());
    }

    @Test
    public void isCorrectValueTestIncorrectValue(){
        assertFalse(model.isCorrectValue(min - 1));
    }

    @Test
    public void isCorrectValueTestCorrectValue(){
        assertTrue(model.isCorrectValue(model.getValue()));
    }

    @Test
    public void isCorrectValueTestCorrectSituation(){
        assertTrue(model.isCorrectValue(min) || model.getLeftLimit() != min);
        assertTrue(model.isCorrectValue(max) || model.getRightLimit() != max);
    }

}
