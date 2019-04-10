package lamps;

/**
 * A simple class to test the class ThreeWayLamp.
 */
class ThreeWayLampTest {

    private ThreeWayLamp lamp;  // the object to test

    /**
     * Create a ThreeWayLampTest.
     */
    public ThreeWayLampTest () {
        lamp = new ThreeWayLamp();
    }

    /**
     * Run the test.
     */
    public void runTest () {
        testInitialState();
        testChange();
    }

    /**
     * Test the ThreeWayLamp's initial state.
     */
    public void testInitialState () {
        System.out.println("testInitialState:");
        System.out.println("Initial setting: " + lamp.setting());
    }

    /**
     * Test the method change.
     */
    public void testChange () {
        System.out.println("testChange:");
        System.out.println("Starting setting: " + lamp.setting());
        lamp.change();
        System.out.println("After 1 change:   " + lamp.setting());
        lamp.change();
        System.out.println("After 2 changes:  " + lamp.setting());
        lamp.change();
        System.out.println("After 3 changes:  " + lamp.setting());
        lamp.change();
        System.out.println("After 4 changes:  " + lamp.setting());
    }

}
