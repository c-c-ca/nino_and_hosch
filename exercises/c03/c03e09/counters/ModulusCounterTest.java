package counters;

/**
 * A simple class to test the class ModulusCounter.
 */
class ModulusCounterTest {

    /**
     * Run the test.
     */
    public void runTest () {
        ModulusCounter counter;
        // create a ModulusCounter with a maximum value of 0
        counter = new ModulusCounter(0);
        testInitialState(counter);
        testStepCount(counter);

        // create a ModulusCounter with a maximum value of 1
        counter = new ModulusCounter(1);
        testInitialState(counter);
        testStepCount(counter);

        // create a ModulusCounter with a maximum value of 3
        counter = new ModulusCounter(3);
        testInitialState(counter);
        testStepCount(counter);
    }

    /**
     * Test the ModulusCounter's initial state.
     */
    private void testInitialState (ModulusCounter counter) {
        System.out.println("testInitialState:");
        System.out.println("Initial count:  " + counter.count());
        System.out.println("Maximum value:  " + counter.maxVal());
    }

    /**
     * Test the method increment method.
     */
    private void testStepCount (ModulusCounter counter) {
        System.out.println("testStepCount:");
        System.out.println("Starting count: " + counter.count());
        counter.increment();
        System.out.println("After 1 step:   " + counter.count());
        counter.increment();
        System.out.println("After 2 steps:  " + counter.count());
        counter.increment();
        System.out.println("After 3 steps:  " + counter.count());
        counter.increment();
        System.out.println("After 4 steps:  " + counter.count());
        System.out.println();
    }

}
