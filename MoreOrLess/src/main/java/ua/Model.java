package ua;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by andrii on 30.10.16.
 */
public class Model {
    private int value;
    private ArrayList<Integer> listOfAttempts;
    private int rightLimit;
    private int leftLimit;

    // Constructor
    public Model() {
        listOfAttempts = new ArrayList<>();
    }

    public int getValue() { return value; }

    public ArrayList<Integer> getListOfAttempts() {
        return listOfAttempts;
    }


    public int getRightLimit() {
        return rightLimit;
    }

    public int getLeftLimit() {
        return leftLimit;
    }

    // The Program logic

    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public int randInt(int min, int max){
        Random rnd = new Random();

        int randomNum = min + rnd.nextInt(max - min + 1);

        return randomNum;
    }

    /**
     * Generate a number and record it in a variable value
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     */
    public void generateValue(int min, int max){
        listOfAttempts.clear();
        leftLimit = min;
        rightLimit = max;
        value = randInt(leftLimit, rightLimit);
    }

    /**
     * Check if user correctly specified number and
     * if userValue is in the range, but it is not a correct value,
     * move the limit of the range
     * @param userValue Value that a user has entered
     * @return if userValue is not int the range, return false
     * if userValue == correct value, return true
     * else return false
     */
    public boolean isCorrectValue(int userValue){
        if(userValue > rightLimit || userValue < leftLimit)
            return false;
        listOfAttempts.add(userValue);
        if(userValue == value)
            return true;
        if(userValue > value)
            rightLimit = userValue - 1;
        else
            leftLimit = userValue + 1;
        return false;
    }

}
