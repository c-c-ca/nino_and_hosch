package banking;

/**
 * Models a dollars and cents amount.
 */
public class Money {

    // Private components:

    private final int dollars;
    private final int cents;

    // Constructors:

    /**
     * Create a new Money instance.
     */
    public Money (int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    // Queries:

    /**
     * The number of dollars in this amount.
     * @require    dollars >= 0
     */
    public int dollars () {
        return dollars;
    }

    /**
     * The number of cents in this amount.
     * @require    0 <= cents && cents <= 99
     */
    public int cents () {
        return cents;
    }

    /**
     * A String representation for this Money object.
     */
    public String toString () {
        String leadingZero;
        if (cents < 10)
            leadingZero = "0";
        else
            leadingZero = "";
        return "$" + dollars + "." + leadingZero + cents;
    }
}
