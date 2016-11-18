package ua.training.model.entity;

/**
 * Created by andrii on 18.11.16.
 */
public enum FlowerColor {
    RED("red"),
    BLUE("blue"),
    PURPLE("purple");

    /**
     *
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
