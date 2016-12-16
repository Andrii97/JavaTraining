package ua.training.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.training.model.entity.Container;

/**
 * Test for model
 * @author Andrii Severin
 * @version 1.0 16 DEC 2016
 */
public class ModelTest {
    public static final String STRING = "Fish and chips is a dish. It is British.\n " +
            "It is very famous. \n";
    public static final String EXPECTED_STRING = "Fish and chips  a dish.   British.\n " +
            "  very famous. \n";

    Model model = new Model();
    Source source;

    @Before
    public void setUp() throws Exception {
        source = new FakeSource(STRING);
    }

    @Test
    public void loadTextTest() throws Exception {
        Container text = model.loadText(source);
        Assert.assertEquals(STRING, text.getContent().toString());
    }

    @Test
    public void removeWords() throws Exception {
        Container text = model.loadText(source);
        Assert.assertEquals(EXPECTED_STRING,
                model.removeWords(text, 2).getContent().toString());
    }

}