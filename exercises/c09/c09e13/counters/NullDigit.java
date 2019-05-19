package counters;

/**
 * A null digit that serves as the high-order digit
 * of a DigitCounter.
 */
public class NullDigit implements AbstractDigit {

    // Queries:

    /**
     * The current digit of this AbstractDigit.
     * @ensure     0 <= this.digit() &&
     *             this.digit() <= 9
     */
    public int digit () {
        return 0;
    }

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
