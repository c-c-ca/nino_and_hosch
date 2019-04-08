package counters;

/**
 * A simple tester for the class Counter.
 */
public class ModulusCounterTester {

    private ModulusCounter counter;

    /**
     * Create a new CounterTester
     */
    public ModulusCounterTester () {}

    /**
     * Run the test.
     */
    public void start () {
        // Test a ModulusCounter with a maximum value of 1
        counter = new ModulusCounter(1);
        System.out.println("Initialize a counter with a maximum value of 1.");
        System.out.print("Starting count:     ");
        System.out.println(counter.count());
        counter.increment();
        System.out.print("After 1 increment:  ");
        System.out.println(counter.count());
        counter.increment();
        System.out.print("After 2 increments: ");
        System.out.println(counter.count());
        counter.increment();
        System.out.print("After 3 increments: ");
        System.out.println(counter.count());
        System.out.println();

        // Test a ModulusCounter with a maximum value of 3
        counter = new ModulusCounter(3);
        System.out.println("Initialize a counter with a maximum value of 3.");
        System.out.print("Starting count:     ");
        System.out.println(counter.count());
        counter.increment();
        System.out.print("After 1 increment:  ");
        System.out.println(counter.count());
        counter.increment();
        System.out.print("After 2 increments: ");
        System.out.println(counter.count());
        counter.increment();
        System.out.print("After 3 increments: ");
        System.out.println(counter.count());
        System.out.println();

        // Test a ModulusCounter with a maximum value of 5
        counter = new ModulusCounter(5);
        System.out.println("Initialize a counter with a maximum value of 5.");
        System.out.print("Starting count:     ");
        System.out.println(counter.count());
        counter.increment();
        System.out.print("After 1 increment:  ");
        System.out.println(counter.count());
        counter.increment();
        System.out.print("After 2 increments: ");
        System.out.println(counter.count());
        counter.increment();
        System.out.print("After 3 increments: ");
        System.out.println(counter.count());
        counter.increment();
        System.out.print("After 4 increments: ");
        System.out.println(counter.count());
        counter.increment();
        System.out.print("After 5 increments: ");
        System.out.println(counter.count());
        counter.increment();
        System.out.print("After 6 increments: ");
        System.out.println(counter.count());
        System.out.println();
    }
}
