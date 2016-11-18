package ua.training.model.entity;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by andrii on 18.11.16.
 */
public enum FlowerInit {
    FLOWER1("Rose 1", FlowerColor.RED, Genus.ROSE, 15.4),
    FLOWER2("Rose 2", FlowerColor.PURPLE, Genus.ROSE, 18),
    FLOWER3("DIANTHUS 1", FlowerColor.RED, Genus.DIANTHUS, 15.2),
    FLOWER4("DIANTHUS 2", FlowerColor.BLUE, Genus.DIANTHUS, 12),
    FLOWER5("TULIP 1", FlowerColor.RED, Genus.TULIP, 12),
    FLOWER6("TULIP 2", FlowerColor.PURPLE, Genus.TULIP, 20);

    private String name;

    private FlowerColor color;

    private Genus genus;

    private double lengthOfPlantStem;

    FlowerInit(String name, FlowerColor color, Genus genus, double lengthOfPlantStem) {
        this.name = name;
        this.color = color;
        this.genus = genus;
        this.lengthOfPlantStem = lengthOfPlantStem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FlowerColor getColor() {
        return color;
    }

    public void setColor(FlowerColor color) {
        this.color = color;
    }

    public Genus getGenus() {
        return genus;
    }

    public void setGenus(Genus genus) {
        this.genus = genus;
    }

    public double getLengthOfPlantStem() {
        return lengthOfPlantStem;
    }

    public void setLengthOfPlantStem(double lengthOfPlantStem) {
        this.lengthOfPlantStem = lengthOfPlantStem;
    }
}
