package lamps;

/**
 * Models a simple three-way lamp.
 */
public class ThreeWayLamp {

    // Private components:

    private int setting;      // the current lamp setting

    // Named constants:

    /**
     * The off lamp setting.
     */
    public static final int OFF = 0;
    /**
     * The low lamp setting.
     */
    public static final int LOW = 1;
    /**
     * The medium lamp setting.
     */
    public static final int MEDIUM = 2;
    /**
     * The high lamp setting.
     */
    public static final int HIGH = 3;

    // Constructor:

    /**
     * Create a new ThreeWayLamp, initially off.
     */
    public ThreeWayLamp () {
        this.setting = OFF;
    }

    // Queries:

    /**
     * The current lamp setting.
     * Returns ThreeWayLamp.OFF, ThreeWayLamp.LOW, ThreeWayLamp.MEDIUM,
     * or ThreeWayLamp.HIGH.
     */
    public int setting () {
        return this.setting;
    }

    // Commands:

    /**
     * Change to the next setting.
     */
    public void change () {
        this.setting = (this.setting + 1) % 4;
    }

}
