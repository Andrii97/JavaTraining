package ua.training.init;

import ua.training.model.entity.Flower;
import ua.training.model.entity.FlowerColor;
import ua.training.model.entity.Genus;

/**
 * This enum contains data and is used to replace user input for test or demonstration purposes.
 * @author Andrii Severin
 * @version 1.0 18 NOV 2016
 */
public enum FlowerInit {
    FLOWER1(new Flower("Rose 1", FlowerColor.RED, Genus.ROSE, 15.4)),
    FLOWER2(new Flower("Rose 2", FlowerColor.PURPLE, Genus.ROSE, 18)),
    FLOWER3(new Flower("DIANTHUS 1", FlowerColor.RED, Genus.DIANTHUS, 15.2)),
    FLOWER4(new Flower("DIANTHUS 2", FlowerColor.BLUE, Genus.DIANTHUS, 12)),
    FLOWER5(new Flower("TULIP 1", FlowerColor.RED, Genus.TULIP, 12)),
    FLOWER6(new Flower("TULIP 2", FlowerColor.PURPLE, Genus.TULIP, 20));

    private Flower flower;

    FlowerInit(Flower flower) {
        this.flower = flower;
    }

    public Flower getFlower() {
        return flower;
    }
}
