package ua.training.model.entity;

/**
 * Stores original char and {@link TypeOfSymbol} of that char.
 * Represents leaf in composite pattern.
 * @author Andrii Severin
 * @version 1.0 11 DEC 2016
 */
public class Symbol implements TextElement {
    /**
     *
     */
    private final char symbol;
    /**
     *
     */
    private final TypeOfTextElement type;
    /**
     *
     */
    private final TypeOfSymbol typeOfSymbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
        type = TypeOfTextElement.SYMBOL;
        for(TypeOfSymbol type : TypeOfSymbol.values()) {
            if (type.getPattern().matcher(String.valueOf(symbol)).matches()) {
                typeOfSymbol = type;
                return;
            }
        }
        typeOfSymbol = TypeOfSymbol.OTHER;
    }

    public Symbol(char symbol, TypeOfSymbol typeOfSymbol) {
        this.symbol = symbol;
        type = TypeOfTextElement.SYMBOL;
        this.typeOfSymbol = typeOfSymbol;
    }

    public boolean isCharacter() {
        return (getTypeOfSymbol() == TypeOfSymbol.VOWEL ||
                getTypeOfSymbol() == TypeOfSymbol.CONSONANT);
    }

    public boolean isNewParagraph() {
        return getTypeOfSymbol() == TypeOfSymbol.NEW_PARAGRAPH;
    }

    public boolean isNewSentence() {
        return getTypeOfSymbol() == TypeOfSymbol.NEW_SENTENCE;
    }

    public char getSymbol() {
        return symbol;
    }

    public TypeOfSymbol getTypeOfSymbol() {
        return typeOfSymbol;
    }

    @Override
    public TypeOfTextElement getType() {
        return type;
    }

    @Override
    public StringBuilder print() {
        return new StringBuilder().append(getSymbol()); //.append(getTypeOfSymbol()).append( getSymbol()).append('\n');
    }
}
