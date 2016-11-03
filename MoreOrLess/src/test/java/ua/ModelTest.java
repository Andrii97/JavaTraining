package ua;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by andrii on 30.10.16.
 */
public class ModelTest {

    private static Model model;

    private static final int NUMBER_OF_GENERATE_SECRET_VALUE = 1000;

    @BeforeClass
    public static void init() {
        model = new Model();
    }

    @Test
    public void setPrimaryBarrierTest(){

    }

    @Test
    public void setSecretValueTest(){
        int value;
        for (int i = 0; i < NUMBER_OF_GENERATE_SECRET_VALUE; i++){
            model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                    GlobalConstants.PRIMARY_MAX_BARRIER);
            model.setSecretValue();
            value = model.getSecretValue();
            assertTrue(value > model.getMinBarrier() && value < model.getMaxBarrier());
        }
    }

    @Test
    public void isCorrectValueTestIncorrectValue(){
        assertFalse(model.isCorrectValue(GlobalConstants.PRIMARY_MIN_BARRIER - 1));
    }

    @Test
    public void isCorrectValueTestCorrectValue(){
        assertTrue(model.isCorrectValue(model.getSecretValue()));
    }

}
