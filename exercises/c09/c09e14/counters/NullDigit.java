package counters;

/**
 * A null digit that serves as the high-order digit
 * of a DigitCounter.
 */
public class NullDigit implements AbstractDigit {

    // Queries:

    /**
     * The count maintained by this AbstractDigit and its
     * high-order neighbor.
     */
    public int count () {
        return 0;
    }

    // Commands:

    /**
     * Increment this AbstractDigit.
     */
    public void step () {}

    /**
     * Reset this AbstractDigit.
     */
    public void reset () {}

    /**
     * An empty String.
     */
    public String toString () {
        return "";
    }

}
