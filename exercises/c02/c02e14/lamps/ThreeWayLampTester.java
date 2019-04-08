package lamps;

/**
 * A simple tester for the class ThreeWayLamp.
 */
public class ThreeWayLampTester {

    private ThreeWayLamp lamp;

    /**
     * Create a new ThreeWayLampTester
     */
    public ThreeWayLampTester () {
        this.lamp = new ThreeWayLamp();
    }

    /**
     * Run the test.
     */
    public void start () {
        System.out.println("Initial setting:");
        System.out.println(lamp.setting());
        lamp.change();
        System.out.println("Change setting.");
        System.out.println("Current setting:");
        System.out.println(lamp.setting());
        lamp.change();
        System.out.println("Change setting.");
        System.out.println("Current setting:");
        System.out.println(lamp.setting());
        lamp.change();
        System.out.println("Change setting.");
        System.out.println("Current setting:");
        System.out.println(lamp.setting());
        lamp.change();
        System.out.println("Change setting.");
        System.out.println("Current setting:");
        System.out.println(lamp.setting());
        lamp.change();
    }
}
