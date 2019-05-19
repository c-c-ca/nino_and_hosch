package counters;

/**
 * Models a simple cell-division counter.
 */
public class CellDivisionCounter extends Counter {

    // Constructors:

    /**
     * Create a new CellDivisionCounter.
     * @ensure     this.count() == 1
     */
    public CellDivisionCounter () {
        count = 1;
    }


    // Commands:

    /**
     * Double the current count.
     * @ensure     this.count() ==
     *                 old.count() * 2
     */
    public void increment () {
        count = count * 2;
    }
}
