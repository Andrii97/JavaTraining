package ua.training.model;

/**
 * Class that describes fake source for testing
 * @author Andrii Severin
 * @version 1.0 16 DEC 2016
 */
public class FakeSource implements Source {
    final char[] content;
    int currentIndex = 0;

    public FakeSource(String string) {
        content = string.toCharArray();
    }

    @Override
    public boolean hasNext() {
        return currentIndex < content.length;
    }

    @Override
    public int readNextCharacter() throws Exception {
        return content[currentIndex++];
    }

    @Override
    public void connect() throws Exception {

    }

    @Override
    public void close() throws Exception {

    }
}
