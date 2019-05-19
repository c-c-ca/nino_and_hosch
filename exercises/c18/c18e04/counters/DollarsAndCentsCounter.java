package counters;

import java.util.*;

/**
 * Models a simple counter that counts dollars and cents.
 */
public class DollarsAndCentsCounter extends Observable {

    // Private components:

    private int dollars;  // the dollar count
    private int cents;    // the cent count

    // Constructor:

    /**
     * Create a new DollarsAndCentsCounter.
     * @ensure    this.dollars() == 0 && this.cents() == 0
     */
    public DollarsAndCentsCounter () {
        dollars = 0;
        cents = 0;
    }

    // Queries:

    /**
     * The dollar count.
     * @ensure    this.dollars() >= 0
     */
    public int dollars () {
        return dollars;
    }

    /**
     * The cent count.
     * @ensure    0 <= this.cents() && this.cents <= 99
     */
    public int cents () {
        return cents;
    }

    // Commands:

    /**
     * Add the specified dollars and cents to this Counter.
     */
    public void add (int dollars, int cents) {
        this.cents += cents;
        this.dollars += dollars + this.cents / 100;
        this.cents %= 100;
        setChanged();
        notifyObservers();
    }

    /**
     * Subtract the specified dollars and cents from this Counter.
     * @require    0 <= cents && cents <= 99
     *             dollars < this.dollars() ||
     *             (dollars <= this.dollars() &&
     *             cents <= this.cents())
     */
    public void subtract (int dollars, int cents) {
        if (this.cents < cents) {
            this.dollars = this.dollars - 1;
            this.cents = this.cents + 100;
        }
        this.dollars = this.dollars - dollars;
        this.cents = this.cents - cents;
        setChanged();
        notifyObservers();
    }

    /**
     * Reset this Counter to 0.
     * @ensure    this.dollars() == 0 && this.cents() == 0
     */
    public void reset () {
        dollars = 0;
        cents = 0;
        setChanged();
        notifyObservers();
    }
}
