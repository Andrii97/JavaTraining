package ua.training.model;

/**
 * Interface that describes source of information
 * @author Andrii Severin
 * @version 1.0 16 DEC 2016
 */
public interface Source extends AutoCloseable {
    /**
     * Checks if a source has more elements
     * @return true if source has next element
     */
    boolean hasNext();

    /**
     * Read from source next character
     * @return code of character, that fetched from source
     * @throws Exception
     */
    int readNextCharacter() throws Exception;

    /**
     * Establish a connection to the source.
     * Need to be called, before use of any methods
     * @throws Exception
     */
    void connect() throws Exception;
}
