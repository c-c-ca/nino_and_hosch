package counters;

/**
 * Models a simple step-counter.
 */
public class StandardCounter extends Counter {

    // Constructors:

    /**
     * Create a new StandardCounter.
     * @ensure     this.count() == 0
     */
    public StandardCounter () {
        count = 0;
    }

    // Commands:

    /**
     * Increment the current count by 1.
     * @ensure     this.count() ==
     *                 old.count() + 1
     */
    public void increment () {
        count = count + 1;
    }
}
