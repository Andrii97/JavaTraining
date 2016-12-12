package ua.training.model.entity;

import java.util.List;

/**
 * Class that describes container objects in composite pattern.
 * Stores list of {@link TextElement} class objects.
 * Can store another composites.
 * @author Andrii Severin
 * @version 1.0 11 DEC 2016
 */
public interface Container extends TextElement {
    void addComponent(TextElement component);

    void removeComponent(TextElement component);

    /**
     * Check is current composite object has any child.
     */
    boolean isEmpty();

    List<TextElement> getComponents();
}
