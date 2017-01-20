package ua.training.model;

import ua.training.model.entity.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents Model unit of MVC based architecture of program "TextAnalyzer"
 * @author Andrii Severin
 * @version 1.0 16 JAN 2017
 */
public class Model {
    /**
     * Symbol factory
     */
    SymbolFactory symbolFactory = SymbolFactory.getInstance();

    Symbol currentSymbol;

    Source source;

    /**
     * Get composite from source
     * @param source source of information
     * @return text composed of paragraph and new paragraph mark
     * @throws Exception
     */
    public Container loadText(Source source) throws Exception {
        Objects.requireNonNull(source);

        setSource(source);
        source.connect();

        return createText();
    }

    /**
     * Create text from source
     * @return text composed of paragraph
     */
    Container createText() {
        Composite text = new Composite(TypeOfTextElement.TEXT);
        while (sourceHasNext()) {
            text.addComponent(createParagraph());
            if(currentSymbol.isNewParagraph())
                text.addComponent(currentSymbol);
        }
        return text;
    }

    /**
     * Create paragraph from source
     * @return paragraph composed of sentence and new sentence mark
     */
    private Container createParagraph() {
        Container currentParagraph = new Composite(TypeOfTextElement.PARAGRAPH);
        do {
            currentParagraph.addComponent(createSentence());
            if (currentSymbol.isNewSentence()) {
                currentParagraph.addComponent(currentSymbol);
            }
            else {
                return currentParagraph;
            }
        } while (sourceHasNext());

        return currentParagraph;
    }

    /**
     * Create sentence from source
     * @return sentence composed of words and punctuation
     */
    private Container createSentence() {
        Container currentSentence = new Composite(TypeOfTextElement.SENTENCE);
        do {
            currentSentence.addComponent(createWord());
            if(currentSymbol.getTypeOfSymbol() == TypeOfSymbol.SPACE  ||
                    currentSymbol.getTypeOfSymbol() == TypeOfSymbol.PUNCTUATION_MARK)
                currentSentence.addComponent(currentSymbol);
            else
                return currentSentence;
        }
        while (sourceHasNext());

        return currentSentence;
    }

    /**
     * Create word from source
     * @return word composed of character
     */
    private Container createWord() {
        Container currentWord = new Composite(TypeOfTextElement.WORD);
        do {
            currentSymbol = getNextSymbol();
            if (!currentSymbol.isCharacter())
                return currentWord;
            currentWord.addComponent(currentSymbol);
        }
        while (sourceHasNext());
        return currentWord;
    }

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
            for (TextElement child : text.getComponents()) {
                if(child.getType() == TypeOfTextElement.SYMBOL) {
                    continue;
                }
                Container textElement = removeWords((Container) child, length);
                if (textElement.getType() == TypeOfTextElement.WORD &&
                        textElement.countChilds() == length &&
                        ((Symbol)textElement.getComponent(0)).isVowel()) {
                    listOfRemovedElements.add(textElement);
                }
            }
            listOfRemovedElements.forEach(text::removeComponent);
            return text;
        }
    }

    private boolean sourceHasNext() {
        return source.hasNext();
    }

    /**
     * Read from source next character and convert it to Symbol
     * @return symbol, that fetched from source
     */
    private Symbol getNextSymbol() {
        char charSymbol = 0;
        try {
            charSymbol = (char) source.readNextCharacter();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return symbolFactory.getSymbol(charSymbol);
    }

    public void setSource(Source source) {
        this.source = source;
    }
}