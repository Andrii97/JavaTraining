package ua.training.model.entity;

/**
 * Interface that describes component.
 * Part of composite pattern
 * @author Andrii Severin
 * @version 1.0 11 DEC 2016
 */
public interface TextElement {
    TypeOfTextElement getType();

    StringBuilder print();
}
