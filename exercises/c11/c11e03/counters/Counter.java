package counters;

/**
 * Models a simple counter.
 */
public abstract class Counter {

    // Private components:

    protected int count;

    // Queries:

    /**
     * The current count for this Counter.
     */
    public int count () {
        return count;
    }

    // Commands:

    /**
     * Increment this Counter.
     */
    public abstract void increment ();

    /**
     * Decrement this counter by 1.
     * @ensure     this.count() ==
     *                 old.count() - 1
     */
    public void decrement () {
        count = count - 1;
    }
}
