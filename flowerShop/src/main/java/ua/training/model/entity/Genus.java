package ua.training.model.entity;

/**
 * Created by andrii on 18.11.16.
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
