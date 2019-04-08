/**
 * Models a simple integer counter.
 */
public class Counter {

    // Private components:

    private int count;
    private int previousCount;      // count before last reset

    // Constructor:

    /**
     * Create a new Counter, with the count initialized
     * to 0.
     */
    public Counter () {
        count = 0;
        previousCount = 0;
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
        previousCount = count;      // save the current count
        count = 0;
    }

    /**
     * Doubles the count.
     */
    public void doubleCount () {
        count *= 2;
    }

    /**
     * Resets the count to what it was before
     * previous reset.
     */
    public void unReset () {
        count = previousCount;
    }

}
