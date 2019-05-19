package nimGame;

/**
 * Models an object that needs to be informed
 * when an InteractivePlayer is about to make
 * a play.
 */
interface PlayerObserver {

    /**
     * The specified InteractivePlayer is about
     * to make a play.
     */
    public void update (InteractivePlayer player);
}
