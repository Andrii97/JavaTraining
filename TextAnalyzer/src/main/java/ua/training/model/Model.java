package ua.training.model;

import ua.training.model.entity.*;

import java.util.LinkedList;
import java.util.List;

/**
 * This class represents Model unit of MVC based architecture of program "TextAnalyzer"
 * @author Andrii Severin
 * @version 1.0 08 DEC 2016
 */
public class Model {
    // TODO: javadoc, new source
    private static String MY_TEXT = "dfg  ea fg os f. gefr df ads ao g! df\n ef e g!r \t \nad.sd \ndv gbg \nere";

    /**
     * Symbol factory
     */
    SymbolFactory symbolFactory = SymbolFactory.getInstance();

    /**
     * Get composite from // TODO source
     * @return composite of text
     */
    public Composite loadText() {
        Composite text = new Composite(TypeOfTextElement.TEXT);
        Composite currentWord = new Composite(TypeOfTextElement.WORD);
        Composite currentSentence = new Composite(TypeOfTextElement.SENTENCE);
        Composite currentParagraph = new Composite(TypeOfTextElement.PARAGRAPH);

        char[] data = MY_TEXT.toCharArray();

        for (int i = 0; i < data.length; i++) {
            Symbol symbol = symbolFactory.getSymbol(data[i]);
            if (!symbol.isCharacter()) {
                if (!currentWord.isEmpty()) {
                    currentSentence.addComponent(currentWord);
                    currentWord = new Composite(TypeOfTextElement.WORD);
                }
                if (!symbol.isNewParagraph()) {
                    currentSentence.addComponent(symbol);
                }
                if (symbol.isNewSentence()) {
                    if (!currentSentence.isEmpty()) {
                        currentParagraph.addComponent(currentSentence);
                        currentSentence = new Composite(TypeOfTextElement.SENTENCE);
                    }
                }
                if (symbol.isNewParagraph()) {
                    if (!currentSentence.isEmpty()) {
                        currentParagraph.addComponent(currentSentence);
                        currentSentence = new Composite(TypeOfTextElement.SENTENCE);
                    }
                    if (!currentParagraph.isEmpty()) {
                        if (!currentSentence.isEmpty()) {
                            currentParagraph.addComponent(currentSentence);
                            currentSentence = new Composite(TypeOfTextElement.SENTENCE);
                        }
                        currentParagraph.addComponent(symbol);
                        text.addComponent(currentParagraph);
                        currentParagraph = new Composite(TypeOfTextElement.PARAGRAPH);
                    }
                }
            } else {
                currentWord.addComponent(symbol);
            }
        }
        if (!currentWord.isEmpty()) {
            currentSentence.addComponent(currentWord);
        }
        if (!currentSentence.isEmpty()) {
            currentParagraph.addComponent(currentSentence);
        }
        text.addComponent(currentParagraph);
        return text;
    }

    // TODO : predicate
    /**
     * Removes words of a given length that starts with vowel letter
     * @param text container of TextElement
     * @param length a given length
     * @return container without words of a given length that starts with vowel letter
     */
    public Container removeWords(Container text, int length) {
        if (text.getType() == TypeOfTextElement.WORD) {
            return text;
        } else {
            List<TextElement> listOfRemovedElements = new LinkedList<>();
            List<TextElement> components = text.getComponents();
            for (TextElement child : components) {
                if(child.getType() == TypeOfTextElement.SYMBOL) {
                    continue;
                }
                Container textElement = removeWords((Container) child, length);
                if (textElement.getType() == TypeOfTextElement.WORD &&
                        textElement.countChilds() == length) {
                    if (((Symbol)textElement.getComponent(0)).getTypeOfSymbol() == TypeOfSymbol.VOWEL) {
                        listOfRemovedElements.add(textElement);
                    }
                }
            }
            components.removeAll(listOfRemovedElements);
            return text;
        }
    }

}