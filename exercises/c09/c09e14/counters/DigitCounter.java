package counters;

/**
 * A simple single digit, zero to nine, counter.
 */
public class DigitCounter implements AbstractDigit {

    // Private components:

    private int digit;               // this DigitCounter's
                                     // digit
    private AbstractDigit neighbor;  // this DigitCounter's
                                     // neighbor

    // Constructors:

    public DigitCounter (int digits) {
        this.digit = 0;
        if (digits <= 1)
            this.neighbor = new NullDigit();
        else
            this.neighbor = new DigitCounter(digits-1);
    }

    // Queries:

    /**
     * The count maintained by this DigitCounter and its
     * high-order neighbor.
     */
    public int count () {
        return neighbor.count() * 10 + digit;
    }

    // Commands:

    /**
     * Increment this DigitCounter.
     */
    public void step () {
        digit = (digit + 1) % 10;
        if (digit == 0)
            neighbor.step();
    }

    /**
     * Reset this DigitCounter to 0.
     * @ensure     this.digit() == 0
     */
    public void reset () {
        neighbor.reset();
        digit = 0;
    }

    /**
     * String representation of the count maintained by
     * this DigitCounter and its high-order neigbors.
     */
    public String toString () {
        return neighbor.toString() + digit;
    }
}
