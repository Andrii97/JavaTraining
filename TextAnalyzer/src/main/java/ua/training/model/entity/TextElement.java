package ua.training.model.entity;

/**
 * Interface that describes component.
 * Part of composite pattern
 * @author Andrii Severin
 * @version 1.0 11 DEC 2016
 */
public interface TextElement {
    /**
     * Get type of TextElement
     * @return type of TextElement
     */
    TypeOfTextElement getType();

    /**
     * Collect text to StringBuilder
     * @return text of TextElement
     */
    String getContent();
}
