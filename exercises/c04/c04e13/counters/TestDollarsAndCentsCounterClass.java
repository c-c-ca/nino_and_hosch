package counters;

/**
 * A simple class to test the class DollarsAndCentsCounter.
 */
class DollarsAndCentsCounterTest {

    // Private components:

    private DollarsAndCentsCounter counter;  // the object to test

    // Constructors:

    /**
     * Create a new DollarsAndCentsCounterTest.
     */
    public DollarsAndCentsCounterTest () {
        counter = new DollarsAndCentsCounter();
    }

    /**
     * Run the test.
     */
    public void runTest () {
        testInitialState();
        testAdd();
    }

    /**
     * Test the DollarsAndCentsCounter's initial state.
     */
    private void testInitialState () {
        verify(counter.dollars() == 0, "initial state, the dollar count");
        verify(counter.cents() == 0, "initial state, the cents count");
    }

    /**
     * Test the add method.
     */
    private void testAdd () {
        counter.add(0,0);  // add 0 dollars and 0 cents
        verify(counter.dollars() == 0 && counter.cents() == 0, "add 0 dollars, 0 cents");
        counter.add(0,1);  // add 0 dollars and 1 cent
        verify(counter.dollars() == 0 && counter.cents() == 1, "add 0 dollars, 1 cent");
        counter.reset();
        counter.add(1,0);  // add 1 dollar and 0 cents
        verify(counter.dollars() == 1 && counter.cents() == 0, "add 1 dollar, 0 cents");
        counter.add(0,1);  // add 1 cent to 1 dollar
        verify(counter.dollars() == 1 && counter.cents() == 1, "add 1 cent to 1 dollar");
        counter.reset();
        counter.add(0,99); // add 1 cent to 99 cents
        counter.add(0,1);
        verify(counter.dollars() == 1 && counter.cents() == 0, "add 1 cent to 99 cents");
        counter.reset();
        counter.add(1,23); // add 3 dollars 21 cents to 1 dollars 23 cents
        counter.add(3,21);
        verify(counter.dollars() == 4 && counter.cents() == 44, "add dollars and cents, no cents to dollars");
        counter.reset();
        counter.add(7,89); // add 9 dollars 87 cents to 7 dollars 89 cents
        counter.add(9,87);
        verify(counter.dollars() == 17 && counter.cents() == 76, "add dollars and cents, cents to dollars");
    }

    /**
     * Verify the specified test condition.  Print message if the test fails.
     */
    private void verify (Boolean test, String message) {
        if (!test)
            System.out.println(
                "Verification failed: " + message);
    }
} // end of class DollarsAndCentsCounterTest

/**
 * A simple test system for the class DollarsAndCentsCounter.
 */
public class TestDollarsAndCentsCounterClass {

    /**
     * Run a DollarsAndCentsCounterTest.
     */
    public static void main (String[] args) {
        (new DollarsAndCentsCounterTest()).runTest();
    }
}
