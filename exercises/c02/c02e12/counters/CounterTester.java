package counters;

/**
 * A simple tester for the class Counter.
 */
public class CounterTester {

    private Counter counter;

    /**
     * Create a new CounterTester
     */
    public CounterTester () {
        counter = new Counter();
    }

    /**
     * Run the test.
     */
    public void start () {
        System.out.println("Starting count:");
        System.out.println(counter.currentCount());
        counter.incrementCount();
        counter.incrementCount();
        counter.incrementCount();
        counter.incrementCount();
        counter.incrementCount();
        counter.incrementCount();
        counter.incrementCount();
        counter.incrementCount();
        counter.incrementCount();
        counter.incrementCount();
        System.out.println("After 10 increments:");
        System.out.println(counter.currentCount());
        counter.reset();
        System.out.println("After reset:");
        System.out.println(counter.currentCount());
        counter.unReset();
        System.out.println("After unreset:");
        System.out.println(counter.currentCount());
    }
}
