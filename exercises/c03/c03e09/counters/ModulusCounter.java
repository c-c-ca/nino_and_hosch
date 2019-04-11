package counters;

/**
 * Models a counter that resets when the count reaches a maximum value.
 */
public class ModulusCounter {

    // Private components:

    private int count;      // the current count
    private int maxVal;     // the maximum value for this counter

    // Constructor:

    /**
     * Create a new ModulusCounter with a specified maximum value.
     * The count is initially set to 0.  The maximum value must be
     * a non-zero positive int.
     */
    public ModulusCounter (int maxVal) {
        this.count = 0;
        this.maxVal = maxVal;
    }

    // Queries:

    /**
     * The current count.
     */
    public int count () {
        return count;
    }

    /**
     * The maximum value for this ModulusCounter.
     */
    public int maxVal () {
        return maxVal;
    }

    // Commands:

    /**
     * Increments the current count by one.  The counter is reset if
     * the count reaches the maximum value.
     */
    public void increment () {
        this.count = (this.count + 1) % (maxVal + 1);
    }

}
