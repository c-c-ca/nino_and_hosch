package nimGame;

/**
 * Models an object that needs to be informed
 * when an UserStrategy is about to make
 * a play.
 */
interface PlayStrategyObserver {

    /**
     * The specified UserStrategy is about
     * to make a play.
     */
    public void update (UserStrategy strategy);
}
