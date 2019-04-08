/**
 * Models a simple integer counter.
 */
public class Counter {

    // Private components:

    private int count;

    // Constructor:

    /**
     * Create a new Counter, with the count initialized
     * to 0.
     */
    public Counter () {
        count = 0;
    }

    // Queries:

    /**
     * The number of items counted.
     */
    public int currentCount () {
        return count;
    }

    // Commands:

    /**
     * Increment the count by 1.
     */
    public void incrementCount () {
        count = count + 1;
    }

    /**
     * Reset the count to 0.
     */
    public void reset () {
        count = 0;
    }

    /**
     * Doubles the count.
     */
    public void doubleCount () {
        count *= 2;
    }

}
