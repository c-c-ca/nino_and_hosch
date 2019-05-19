package counters;

/**
 * A simple single digit, zero to nine, counter.
 */
public interface AbstractDigit {

    // Queries:

    /**
     * The count maintained by this AbstractDigit and its
     * high-order neighbor.
     */
    public int count ();

    // Commands:

    /**
     * Increment this AbstractDigit.
     */
    public void step ();

    /**
     * Reset this AbstractDigit.
     */
    public void reset ();
}
