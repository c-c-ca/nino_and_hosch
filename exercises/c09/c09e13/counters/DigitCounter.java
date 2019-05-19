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

    public DigitCounter (AbstractDigit neighbor) {
        this.digit = 0;
        this.neighbor = neighbor;
    }

    // Queries:

    /**
     * The current digit of this DigitCounter.
     * @ensure     0 <= this.digit() &&
     *             this.digit() <= 9
     */
    public int digit () {
        return digit;
    }

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
