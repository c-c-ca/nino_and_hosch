package trafficSimulation;

/**
 * A simple class to test the class TrafficSignal.
 */
public class TrafficSignalTest {

    // Private components:

    private TrafficSignal signal;  // the object to test

    // Constructors:

    /**
     * Create a TrafficSignalTest.
     */
    public TrafficSignalTest () {
        // create a signal to test.
        signal = new TrafficSignal();
    }

    /**
     * Run the test.
     */
    public void runTest () {
        testInitialState();
        testChange();
    }

    /**
     * Test the TrafficSignal's initial state.
     */
    private void testInitialState () {
        System.out.println("testInitialState:");
        System.out.println(
            "Initial light: " + signal.light());
    }

    /**
     * Test the method change.
     */
    private void testChange () {
        System.out.println("testChange:");
        System.out.println(
            "Starting light: " + signal.light());
        signal.change();
        System.out.println(
            "After 1 change: " + signal.light());
        signal.change();
        System.out.println(
            "After 2 changes: " + signal.light());
        signal.change();
        System.out.println(
            "After 3 changes: " + signal.light());
    }
}
