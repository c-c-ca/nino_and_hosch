package counters;

/**
 * Models a counter that resets when the count reaches a maximum value.
 */
class ModulusCounter {

    // Constructor:

    /**
     * Create a new ModulusCounter with a specified maximum value.
     * The count is initially set to 0.
     */
    public ModulusCounter (int maxVal) {}

    // Queries:

    /**
     * The current count.
     */
    public int count () { return 0; }

    // Commands:

    /**
     * Increments the current count by one.  The counter is reset if
     * the count reaches the maximum value.
     */
    public void increment () {}

}