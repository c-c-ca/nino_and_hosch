package counters;

/**
 * Models a simple integer counter.
 */
public class Counter {

    // Private components:

    private int count;  // current count

    // Constructor:

    /**
     * Create a new Counter.
     * @ensure     this.count() == 0
     */
    public Counter () {
        count = 0;
    }

    // Queries:

    /**
     * The number of items counted.
     */
    public int count () {
        return count;
    }

    // Commands:

    /**
     * Increments the current count by 1.
     * @ensure     this.count() == old.count() + 1
     */
    public void increment () {
        ++count;
    }

    /**
     * Reset the count to 0.
     * @ensure     this.count() == 0
     */
    public void reset () {
        count = 0;
    }

}
