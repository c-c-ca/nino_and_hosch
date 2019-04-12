package counters;

/**
 * A simple class to test the class BaseballCounter.
 */
class BaseballCounterTest {

    // Private components:

    private BaseballCounter counter;  // the object to test

    // Constructors:

    /**
     * Create a new BaseballCounterTest.
     */
    public BaseballCounterTest () {
        counter = new BaseballCounter();
    }

    /**
     * Run the test.
     */
    public void runTest () {
        testInitialState();
        testIncrementStrikes();
        testIncrementBalls();
    }

    /**
     * Test the BaseballCounter's initial state.
     */
    private void testInitialState () {
        verify(counter.strikes() == 0, "initial state, number of strikes");
        verify(counter.balls() == 0, "initial state, number of balls");
    }

    /**
     * Test the incrementStrikes method.
     */
    private void testIncrementStrikes () {
        counter.incrementBalls();    // test ball count reset after 3rd strike
        counter.incrementStrikes();  // strike 1
        verify(counter.strikes() == 1 && counter.balls() == 1,
            "increment strike count for counter with a strike count of 0");
        counter.incrementStrikes();  // strike 2
        verify(counter.strikes() == 2 && counter.balls() == 1,
            "increment strike count for counter with a strike count of 1");
        counter.incrementStrikes();  // strike 3
        verify(counter.strikes() == 0 && counter.balls() == 0,
            "increment strike count for counter with a strike count of 2");
    }

    /**
     * Test the incrementBalls method.
     */
    private void testIncrementBalls () {
        counter.incrementStrikes();  // test strike count reset after 4th ball
        counter.incrementBalls();    // ball 1
        verify(counter.strikes() == 1 && counter.balls() == 1,
            "increment ball count for counter with a ball count of 0");
        counter.incrementBalls();    // ball 2
        verify(counter.strikes() == 1 && counter.balls() == 2,
            "increment ball count for counter with a ball count of 1");
        counter.incrementBalls();    // ball 3
        verify(counter.strikes() == 1 && counter.balls() == 3,
            "increment ball count for counter with a ball count of 2");
        counter.incrementBalls();    // ball 4
        verify(counter.strikes() == 0 && counter.balls() == 0,
            "increment ball count for counter with a ball count of 3");
    }

    /**
     * Verify the specified test condition.  Print message if the test fails.
     */
    private void verify (Boolean test, String message) {
        if (!test)
            System.out.println(
                "Verification failed: " + message);
    }
} // end of class BaseballCounterTest

/**
 * A simple test system for the class BaseballCounter.
 */
public class TestBaseballCounterClass {

    /**
     * Run a DateTest.
     */
    public static void main (String[] args) {
        (new BaseballCounterTest()).runTest();
    }
}
