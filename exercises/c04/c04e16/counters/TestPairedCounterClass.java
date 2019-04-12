package counters;

/**
 * A simple class to test the class PairedCounter.
 */
class PairedCounterTest {

    // Private components:

    private PairedCounter counter1;  // the first counter to test
    private PairedCounter counter2;  // the second counter to test

    // Constructors:

    /**
     * Create a new PairedCounterTest.
     */
    public PairedCounterTest () {
        counter1 = new PairedCounter(0);
        counter2 = new PairedCounter(1);
    }

    // Commands:

    /**
     * Run the test.
     */
    public void runTest () {
        testInitialState();
        testIncrement();
    }

    /**
     * Test the PairedCounter's initial state.
     */
    private void testInitialState () {
        verify(counter1.count() == 0 && counter1.maxValue() == 0,
            "initial state");
        verify(counter2.count() == 0 && counter2.maxValue() == 1,
            "initial state");
    }

    /**
     * Test the method increment method.
     */
    private void testIncrement () {
        counter1.setPartner(counter2);
        counter2.increment();
        verify(counter1.count() == 0 && counter2.count() == 1,
            "counter max of 1 after 1 step");
        counter1.increment();
        verify(counter1.count() == 0 && counter2.count() == 0,
            "counter resets when partner resets");
        counter2.increment();
        counter2.increment();
        verify(counter1.count() == 0 && counter2.count() == 0,
            "reset counter that has a null partner");

    }

    /**
     * Verify the specified test condition.  Print message if the test fails.
     */
    private void verify (Boolean test, String message) {
        if (!test)
            System.out.println(
                "Verification failed: " + message);
    }
} // end of class PairedCounterTest

/**
 * A simple test system for the class PairedCounter.
 */
public class TestPairedCounterClass {

    /**
     * Run a PairedCounterTest.
     */
    public static void main (String[] args) {
        (new PairedCounterTest()).runTest();
    }
}
