package ua.training.model.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that describes container objects in composite pattern.
 * Stores list of {@link TextElement} class objects.
 * Can store another composites.
 * @author Andrii Severin
 * @version 1.0 11 DEC 2016
 */
public class Composite implements Container{
    /**
     * List of components
     */
    private List<TextElement> components;

    /**
     * Type Of TextElement
     */
    private TypeOfTextElement type;

    public Composite(TypeOfTextElement type) {
        this.type = type;
        this.components = new LinkedList<>();
    }

    @Override
    public TypeOfTextElement getType() {
        return type;
    }

    @Override
    public void addComponent(TextElement component) {
        components.add(component);
    }

    @Override
    public void removeComponent(TextElement component) {
        components.remove(component);
    }

    @Override
    public boolean isEmpty() {
        return components.isEmpty();
    }

    @Override
    public List<TextElement> getComponents() {
        return components;
    }

    @Override
    public TextElement getComponent(int index) {
        return components.get(index);
    }

    @Override
    public int countChilds() {
        return components.size();
    }

    @Override
    public String getContent() {
        StringBuilder string = new StringBuilder();
        for (TextElement textElement : components) {
            string.append(textElement.getContent());
        }
        return string.toString();
    }
}
