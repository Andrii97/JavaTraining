package ua.training.model.entity;

/**
 * This class represents common state and functionality of flower entity
 * @author Andrii Severin
 * @version 1.0 18 NOV 2016
 */
public class Flower {
    /**
     * Name of flower
     */
    private String name;

    /**
     * Color of flower
     */
    private FlowerColor color;

    /**
     * Genus of Flower
     */
    private Genus genus;

    /**
     * Length of plant stem
     */
    private double lengthOfPlantStem;

    /**
     * Initializes fields of flower entity
     * @param name Name of flower
     * @param color Color of flower
     * @param genus Genus of Flower
     * @param lengthOfPlantStem Length of plant stem
     */
    public Flower(String name, FlowerColor color, Genus genus, double lengthOfPlantStem) {
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

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name /*+ '\'' +
                ", color=" + color +
                ", genus=" + genus*/ +
                ", lengthOfPlantStem=" + lengthOfPlantStem +
                '}';
    }
}
