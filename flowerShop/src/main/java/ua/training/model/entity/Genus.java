package ua.training.model.entity;

/**
 * This enum contains genuses that can be used for genus of flower
 * @author Andrii Severin
 * @version 1.0 18 NOV 2016
 */
public enum Genus {
    GERBERA("Gerbera"),
    ROSE("Rose"),
    DIANTHUS("Dianthus"),
    CHRYSANTHEMUM("Chrysanthemum"),
    TULIP("Tulip");

    /**
     * Name of Genus
     */
    private final String name;

    Genus(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "Genus{" +
//                "name='" + name + '\'' +
//                "} " + super.toString();
//    }
}
