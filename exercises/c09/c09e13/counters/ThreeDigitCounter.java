package counters;

/**
 * Models a simple three digit counter.
 */
public class ThreeDigitCounter {

    // Private components:

    private NullDigit nullDigit;
    private DigitCounter hundreds;
    private DigitCounter tens;
    private DigitCounter ones;

    // Constructors:

    public ThreeDigitCounter () {
        nullDigit = new NullDigit();
        hundreds = new DigitCounter(nullDigit);
        tens = new DigitCounter(hundreds);
        ones = new DigitCounter(tens);
    }

    public void step () {
        ones.step();
    }

    public String toString () {
        return ones.toString();
    }
}
