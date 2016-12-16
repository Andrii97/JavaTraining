package ua.training.model;

import ua.training.view.View;

import java.io.File;
import java.io.FileReader;
import java.util.Objects;

/**
 * Class that describes file as source of information
 * @author Andrii Severin
 * @version 1.0 16 DEC 2016
 */
public class FileSource implements Source {
    /**
     * A file
     */
    private final File file;

    /**
     * A next character
     */
    private int nextCharacter;

    /**
     * A file reader
     */
    private FileReader fileReader;

    /**
     *
     * @param fileName
     */
    public FileSource(String fileName) {
        this.file = new File(fileName);
    }

    public FileSource(File file) {
        Objects.requireNonNull(file);
        this.file = file;
    }

    @Override
    public boolean hasNext() {
        return nextCharacter != -1;
    }

    @Override
    public int readNextCharacter() throws Exception {
        if(!hasNext()) {
            throw new Exception(View.EMPTY_STREAM);
        }
        int res = nextCharacter;
        if(fileReader == null) {
            throw new Exception(View.CONNECTION_FAIL);
        }
        nextCharacter = fileReader.read();
        return res;
    }

    @Override
    public void connect() throws Exception {
        if(fileReader != null) {
            return;
        }
        fileReader = new FileReader(file);
        nextCharacter = fileReader.read();
    }

    @Override
    public void close() throws Exception {
        if(fileReader == null) {
            return;
        }
        fileReader.close();
        nextCharacter = -1;
        fileReader = null;
    }
}
