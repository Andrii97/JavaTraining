package ua.training.model.entity;

import java.util.regex.Pattern;

/**
 * Enum that stores possible types of symbol
 * @author Andrii Severin
 * @version 1.0 11 DEC 2016
 */
public enum TypeOfSymbol {
    VOWEL("[aAeEiIoOuUyY]"),
    PUNCTUATION_MARK("[-`~@#$%^&*()_+=/|{}\\['\":;,<>]"),
    CONSONANT("[b-df-hj-np-tv-zB-DF-HJ-NP-TV-Z]"),
    NEW_PARAGRAPH("\\n"),
    NEW_SENTENCE("[!.?]"),
    SPACE("[ ]"),
    OTHER("");

    /**
     * A pattern of regular expression
     */
    private Pattern pattern;

    TypeOfSymbol(String regex) {
        pattern = Pattern.compile(regex);
    }

    public Pattern getPattern() {
        return pattern;
    }
}
