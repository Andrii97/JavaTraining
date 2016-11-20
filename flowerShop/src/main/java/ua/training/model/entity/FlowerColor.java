package ua.training.model.entity;

/**
 * This enum contains colors that can be used for color of flower
 * @author Andrii Severin
 * @version 1.0 18 NOV 2016
 */
public enum FlowerColor {
    /**
     * Red color
     */
    RED("red"),
    /**
     * Blue color
     */
    BLUE("blue"),
    /**
     * Purple color
     */
    PURPLE("purple");

    /**
     * Name of color
     */
    private final String name;

    FlowerColor(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "FlowerColor{" +
//                "name='" + name + '\'' +
//                "} " + super.toString();
//    }
}
