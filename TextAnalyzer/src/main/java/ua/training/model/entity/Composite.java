package ua.training.model.entity;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andrii Severin
 * @version 1.0 11 DEC 2016
 */
public class Composite implements Container{
    /**
     *
     */
    private List<TextElement> components;
    /**
     *
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
    public StringBuilder print() {
        StringBuilder string = new StringBuilder();
        for (TextElement textElement : components) {
            string.append(textElement.print());
        }
        return string;
    }
}
