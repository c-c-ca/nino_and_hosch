package counters;

/**
 * Models a simple counter that counts balls and strikes in a
 * baseball game.
 */
public class BaseballCounter {

    // Constructor:

    /**
     * Create a new BaseballCounter.  The number of balls and
     * strikes are initially set to 0.2
     */
    public BaseballCounter () {}

    // Queries:

    /**
     * The number of strikes.
     */
    public int strikes () { return 0; }

    /**
     * The number of balls.
     */
    public int balls () { return 0; }

    // Commands:

    /**
     * Increment the number of strikes by one.  Reset the
     * counter if the number of strikes counted is three.
     */
    public void incrementStrikes () {}

    /**
     * Increment the number of balls by one.  Reset the
     * counter if the number of balls counted is four.
     */
    public void incrementBalls () {}
}
