package counters;

/**
 * Models a simple counter that counts balls and strikes in a
 * baseball game.
 */
public class BaseballCounter {

    // Private components:

    private int strikes;  // number of strikes counted
    private int balls;    // number of balls counted

    // Constructor:

    /**
     * Create a new BaseballCounter.
     * @ensure    this.strikes() == 0 && this.balls() == 0
     */
    public BaseballCounter () {
        this.strikes = 0;
        this.balls = 0;
    }

    // Queries:

    /**
     * The number of strikes.
     */
    public int strikes () {
        return strikes;
    }

    /**
     * The number of balls.
     */
    public int balls () {
        return balls;
    }

    // Commands:

    /**
     * Increment the number of strikes by one.  Reset the
     * counter if the number of strikes counted is three.
     */
    public void incrementStrikes () {
        strikes += 1;
        if (strikes == 3)
            reset();
    }

    /**
     * Increment the number of balls by one.  Reset the
     * counter if the number of balls counted is four.
     */
    public void incrementBalls () {
        balls += 1;
        if (balls == 4)
            reset();
    }

    /**
     * Reset this BaseballCounter.
     * @ensure    this.strikes() == 0 && this.balls() == 0
     */
    private void reset () {
        strikes = 0;
        balls = 0;
    }
}
