package ua.model;

/**
 * Created by andrii on 06.11.16.
 */
public enum Group {
    FRIENDS("Friends"),
    RELATIVES("Relatives"),
    WORK("Work"),
    EDUCATION("Education");

    private final String name;

    Group(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }
}
