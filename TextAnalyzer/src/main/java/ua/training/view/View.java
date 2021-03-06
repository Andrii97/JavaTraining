package ua.training.view;

/**
 * This class represents View unit of MVC based architecture of program "TextAnalyzer".
 * @author Andrii Severin
 * @version 1.0 08 DEC 2016
 */
public class View {
    // Text's constants
    public static final String ORIGINAL_TEXT = "Original text";
    public static final String UPDATED_TEXT = "Updated text";
    public static final String EMPTY_STREAM = "Empty stream";
    public static final String CONNECTION_FAIL = "Connection fail";
    public static final String FILE_NAME = "input.txt";

    /**
     * Print message
     * @param message information to getContent
     */
    public void printMessage(String message){
        System.out.println(message);
    }


}