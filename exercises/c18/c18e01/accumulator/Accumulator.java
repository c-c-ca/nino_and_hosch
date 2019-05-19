package accumulator;

import java.util.*;

/**
 * A simple object that maintains a running integer sum.
 */
class Accumulator extends Observable {

    // Private components:

    private int sum;
    private int summand;

    // Constructors:

    /**
     * Create a new Accumulator, with sum and summand
     * set to 0.
     */
    public Accumulator () {
        this.sum = 0;
        this.summand = 0;
    }

    // Queries:

    /**
     * The running sum.
     */
    public int sum () {
        return sum;
    }

    /**
     * The value to be added to the sum.
     */
    public int summand () {
        return summand;
    }

    // Commands:

    /**
     * Add summand to sum.
     */
    public void add () {
        sum = sum + summand;
        setChanged();
        notifyObservers();
    }

    /**
     * Set the value of the summand.
     */
    public void setSummand (int val) {
        summand = val;
    }

    /**
     * Set the value of the sum and summand to 0.
     */
    public void reset () {
        sum = 0;
        summand = 0;
        setChanged();
        notifyObservers();
    }
}
