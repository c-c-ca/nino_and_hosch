package counters;

public class Counter {

    // Nested member interface:

    private interface Incrementor {
        public void increment ();
    }

    // Nested member classes:

    private static class AddOneIncrementor
        implements Incrementor {

        private Counter counter;

        private AddOneIncrementor (Counter counter) {
            this.counter = counter;
            this.counter.incrementor = this;
        }

        public void increment () {
            counter.count = counter.count + 1;
        }
    }

    private static class DoubleIncrementor
        implements Incrementor {

        private Counter counter;

        private DoubleIncrementor (Counter counter) {
            this.counter = counter;
            this.counter.count = 1;
            this.counter.incrementor = this;
        }

        public void increment () {
            counter.count = counter.count * 2;
        }
    }

    // Static methods:

    public static Counter createStandardCounter () {
        Counter counter = new Counter();
        new AddOneIncrementor(counter);
        return counter;
    }

    public static Counter createCellDivisionCounter () {
        Counter counter = new Counter();
        new DoubleIncrementor(counter);
        return counter;
    }

    // Private components:

    private int count;
    private Incrementor incrementor;

    // Constructors:

    /**
     * Create a new Counter.
     */
    protected Counter () {
        count = 0;
        incrementor = null;
    }

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
     * @ensure     this.count() > old.count()
     */
    public void increment () {
        incrementor.increment();
    }

    /**
     * Decrement this Counter.
     * @ensure     this.count() < old.count()
     */
    public void decrement () {
        count = count - 1;
    }

}
