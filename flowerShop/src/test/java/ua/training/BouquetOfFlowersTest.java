package ua.training;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.training.model.Model;
import ua.training.model.entity.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Random;
import ua.training.controller.GlobalConstants;
import static org.junit.Assert.*;

public class BouquetOfFlowersTest {

    private static BouquetOfFlowers bouquetOfFlowers;
    private static Model model;

    private static double LEFT_LIMIT = 12;
    private static double RIGHT_LIMIT = 18;

    @BeforeClass
    public static void init() {
        model = new Model();
        ArrayList<Flower> flowers = new ArrayList<>();
        for (FlowerInit f : FlowerInit.values()) {
            Flower flower = new Flower(f.getName(), f.getColor(), f.getGenus(),
                    f.getLengthOfPlantStem());
            flowers.add(flower);
        }
        ArrayList<SalableFlower> salableFlowers = new ArrayList<>();
        for (Flower flower : flowers) {
            Random random = new Random();
            SalableFlower salableFlower = new SalableFlower(flower,
                    random.nextDouble() * GlobalConstants.MAX_PRICE, LocalDate.of(GlobalConstants.YEAR,
                    Month.of(random.nextInt(GlobalConstants.MAX_MONTH) + 1),
                    random.nextInt(GlobalConstants.MAX_DAY) + 1));
            salableFlowers.add(salableFlower);
        }
        bouquetOfFlowers = model.createBouquetOfFlowers(salableFlowers);
    }

    @Test
    public void getFlowersByLengthOfPlantStemRangeTest(){
        ArrayList<SalableFlower> flowers = bouquetOfFlowers
                .getFlowersByLengthOfPlantStemRange(LEFT_LIMIT, RIGHT_LIMIT);
        for(SalableFlower salableFlower : flowers) {
            double length = salableFlower.getFlower().getLengthOfPlantStem();
            assertFalse(length <= LEFT_LIMIT && length >= RIGHT_LIMIT);
        }
    }

}
