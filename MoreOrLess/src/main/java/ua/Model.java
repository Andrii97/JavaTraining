package ua;

import java.util.ArrayList;

/**
 * Created by andrii on 30.10.16.
 */
public class Model {
    /**
     * It is secret value, which player need to guess
     */
    private int secretValue;
    /**
     * It is a list, which is used for saving history of attempts
     */
    private ArrayList<Integer> listOfAttempts;
    /**
     * It is a max barrier of current range
     */
    private int maxBarrier;
    /**
     * It is a min barrier of current range
     */
    private int minBarrier;

    // Constructor
    public Model() {
        listOfAttempts = new ArrayList<>();
    }

    // The Program logic

    /**
     * Check if user value == secretValue, return true
     * else return false and decrease range (change barrier)
     * @param userValue Value that a user has entered
     * @return if userValue == correct secretValue, return true, else return false
     */
    public boolean isCorrectValue(int userValue){
        listOfAttempts.add(userValue);
        if(userValue == secretValue)
            return true;
        if(userValue > secretValue)
            maxBarrier = userValue;
        else
            minBarrier = userValue;
        return false;
    }

    /**
     * Set min and max barriers of range
     * @param minBarrier Minimum barrier of range
     * @param maxBarrier Maximum barrier of range. Must be greater than minBarrier
     */
    public void setPrimaryBarrier(int minBarrier, int maxBarrier){
        this.minBarrier = minBarrier; // check
        this.maxBarrier = maxBarrier;
    }

    /**
     * Generate a number and record it in a variable secretValue
     */
    public void setSecretValue() {
        listOfAttempts.clear();
        secretValue = (int)Math.ceil(Math.random() *
                (maxBarrier - minBarrier - 1) + minBarrier);
    }


    public int getSecretValue() { return secretValue; }

    public ArrayList<Integer> getListOfAttempts() {
        return listOfAttempts;
    }


    public int getMaxBarrier() {
        return maxBarrier;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

}
