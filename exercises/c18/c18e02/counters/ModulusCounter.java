package counters;

/**
 * Models a counter that resets when the count reaches a maximum value.
 */
public class ModulusCounter extends Counter {

    // Private components:

    private int maxValue;   // the maximum value for this counter

    // Constructor:

    /**
     * Create a new ModulusCounter with a specified maximum value.
     * @require    maxValue >= 0
     * @ensure     this.count() == 0
     */
    public ModulusCounter (int maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * The maximum value for this ModulusCounter.
     * @ensure     result >= 0
     */
    public int maxValue () {
        return maxValue;
    }

    // Commands:

    /**
     * Increments the current count by one.  The counter is reset if
     * the count reaches the maximum value.
     * @ensure     this.count() == old.count() + 1 ||
     *             this.count() == 0
     */
    public void increment () {
        super.increment();
        if (this.count() > maxValue)
            super.reset();
    }

}
