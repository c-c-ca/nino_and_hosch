package counters;

/**
 * Models a counter that resets when the count reaches a maximum value.
 */
public class ModulusCounter {

    // Private components:

    private int count;      // the current count
    private int maxValue;   // the maximum value for this counter

    // Constructor:

    /**
     * Create a new ModulusCounter with a specified maximum value.
     * @require    maxValue >= 0
     * @ensure     this.count() == maxValue
     */
    public ModulusCounter (int maxValue) {
        this.count = 0;
        this.maxValue = maxValue;
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
    public int maxValue () {
        return maxValue;
    }

    // Commands:

    /**
     * Increments the current count by one.  The counter is reset if
     * the count reaches the maximum value.
     */
    public void increment () {
        this.count = (this.count + 1) % (maxValue + 1);
    }

}
