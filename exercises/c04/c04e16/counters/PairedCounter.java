package counters;

/**
 * Models a counter that resets when the count reaches a maximum value
 * and resets its partner.
 */
public class PairedCounter {

    // Private components:

    private int count;              // the current count
    private int maxValue;           // the maximum value for this counter
    private PairedCounter partner;  // this counter's partner

    // Constructor:

    /**
     * Create a new PairedCounter with a specified maximum value.
     * @ensure    this.count() == 0
     * @require   0 <= this.maxValue()
     */
    public PairedCounter (int maxValue) {
        this.count = 0;
        this.maxValue = maxValue;
        this.partner = null;
    }

    // Queries:

    /**
     * The current count.
     */
    public int count () {
        return count;
    }

    /**
     * The maximum value for this PairedCounter.
     */
    public int maxValue () {
        return maxValue;
    }

    // Commands:

    /**
     * Increments the current count by one.  The counter is reset if
     * the count reaches the maximum value.
     * @ensure    0 <= this.count() && this.count() <= maxValue()
     */
    public void increment () {
        count = (count + 1) % (maxValue + 1);
        if (count == 0 && partner != null)
            partner.reset();
    }

    /**
     * Reset this counter.
     * @ensure    this.count() == 0
     */
    private void reset () {
        count = 0;
    }

    /**
     * Set the partner of this PairedCounter as specified.
     */
    public void setPartner (PairedCounter partner) {
        this.partner = partner;
    }

}
