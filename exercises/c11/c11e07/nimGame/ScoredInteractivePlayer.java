package nimGame;

public class ScoredInteractivePlayer extends ScoredPlayer
    implements InteractivePlayer {

    // Constructors:

    public ScoredInteractivePlayer (String name) {
        super(new StandardInteractivePlayer(name));
    }

    /**
     * Set the number of sticks this InteractivePlayer should
     * taken on its next turn.
     * @require    number > 0
     */
    public void setNumberToTake (int number) {
        ((InteractivePlayer)player).setNumberToTake(number);
    }

    /**
     * Set the PlayerObserver this InteractivePlayer is to
     * report to.  This InteractivePlayer will notify controller
     * (by invoking its update method) before making a play.
     */
    public void register (PlayerObserver controller) {
        ((InteractivePlayer)player).register(controller);
    }

}
