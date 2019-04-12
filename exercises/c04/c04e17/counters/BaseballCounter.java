package counters;

/**
 * Models a simple counter that counts balls and strikes in a
 * baseball game.
 */
public class BaseballCounter {

    // Private components:

    private PairedCounter strikeCounter;  // counts the number of strikes
    private PairedCounter ballCounter;    // counts the number of balls

    // Constructor:

    /**
     * Create a new BaseballCounter.
     * @ensure    this.strikes() == 0 && this.balls() == 0
     */
    public BaseballCounter () {
        strikeCounter = new PairedCounter(2);
        ballCounter = new PairedCounter(3);
        strikeCounter.setPartner(ballCounter);
        ballCounter.setPartner(strikeCounter);
    }

    // Queries:

    /**
     * The number of strikes.
     */
    public int strikes () {
        return strikeCounter.count();
    }

    /**
     * The number of balls.
     */
    public int balls () {
        return ballCounter.count();
    }

    // Commands:

    /**
     * Increment the number of strikes by one.  Reset the
     * counter if the number of strikes counted is three.
     */
    public void incrementStrikes () {
        strikeCounter.increment();
    }

    /**
     * Increment the number of balls by one.  Reset the
     * counter if the number of balls counted is four.
     */
    public void incrementBalls () {
        ballCounter.increment();
    }
    
}
