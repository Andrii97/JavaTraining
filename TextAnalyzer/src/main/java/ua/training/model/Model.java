package ua.training.model;

import ua.training.model.entity.Composite;
import ua.training.model.entity.Symbol;
import ua.training.model.entity.SymbolFactory;
import ua.training.model.entity.TypeOfTextElement;

/**
 * This class represents Model unit of MVC based architecture of program "TextAnalyzer"
 * @author Andrii Severin
 * @version 1.0 08 DEC 2016
 */
public class Model {

    private static String MY_TEXT = "dfg fg f.gefr df   g! df\n ef e g!r \t   \nere";

    // parser
    public Composite loadText() {
        Composite text = new Composite(TypeOfTextElement.TEXT);
        Composite currentWord = new Composite(TypeOfTextElement.WORD);
        Composite currentSentence = new Composite(TypeOfTextElement.SENTENCE);
        Composite currentParagraph = new Composite(TypeOfTextElement.PARAGRAPH);

        char[] data = MY_TEXT.toCharArray();

        for (int i = 0; i < data.length; i++) {
            Symbol symbol = SymbolFactory
                    .getInstance().getSymbol(data[i]);
            if(!symbol.isCharacter()) {
                if(!currentWord.isEmpty()) {
                    currentSentence.addComponent(currentWord);
                    currentWord = new Composite(TypeOfTextElement.WORD);
                }
                currentSentence.addComponent(symbol);
                if(symbol.isNewSentence()) {
                    if(!currentSentence.isEmpty()) {
                        currentParagraph.addComponent(currentSentence);
                        currentSentence = new Composite(TypeOfTextElement.SENTENCE);
                    }
                }
                if(symbol.isNewParagraph()) {
                    if(!currentParagraph.isEmpty()) {
                        if(!currentSentence.isEmpty()) {
                            currentParagraph.addComponent(currentSentence);
                            currentSentence = new Composite(TypeOfTextElement.SENTENCE);
                        }
                        text.addComponent(currentParagraph);
                        currentParagraph = new Composite(TypeOfTextElement.PARAGRAPH);
                    }
                }
                // text.addComponent(symbol);

            } else {
                currentWord.addComponent(symbol);
            }
        }
        if(!currentWord.isEmpty()) {
            currentSentence.addComponent(currentWord);
        }
        if(!currentSentence.isEmpty()) {
            currentParagraph.addComponent(currentSentence);
        }
        text.addComponent(currentParagraph);
        return text;
    }
}