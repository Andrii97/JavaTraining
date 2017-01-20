package ua.training.model.entity;

/**
 * Stores original char and {@link TypeOfSymbol} of that char.
 * Represents leaf in composite pattern.
 * @author Andrii Severin
 * @version 1.0 11 DEC 2016
 */
public
class Symbol implements TextElement {
    /**
     * Content of Symbol
     */
    private final char symbol;

    /**
     * Type of TextElement
     */
    private final TypeOfTextElement type;

    /**
     * Type of Symbol
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

    /**
     *
     * @return
     */
    public boolean isCharacter() {
        return (getTypeOfSymbol() == TypeOfSymbol.VOWEL ||
                getTypeOfSymbol() == TypeOfSymbol.CONSONANT);
    }

    /**
     *
     * @return
     */
    public boolean isNewParagraph() {
        return getTypeOfSymbol() == TypeOfSymbol.NEW_PARAGRAPH;
    }

    /**
     *
     * @return
     */
    public boolean isNewSentence() {
        return getTypeOfSymbol() == TypeOfSymbol.NEW_SENTENCE;
    }

    /**
     *
     * @return
     */
    public boolean isVowel() {
        return getTypeOfSymbol() == TypeOfSymbol.VOWEL;
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
    public String getContent() {
        return new StringBuilder().append(getSymbol()).toString();
        //.append(getTypeOfSymbol()).append( getSymbol()).append('\n');
    }
}
