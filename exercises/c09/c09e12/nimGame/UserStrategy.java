package nimGame;

import java.util.*;

/**
 * Allows the user to control a Player in the game simple nim.
 */
class UserStrategy implements PlayStrategy {

    // Private components:

    private int numberToTake;
    private PlayStrategyObserver controller;

    // Constructors:

    public UserStrategy (Game game, Scanner in) {
        this.controller = new PlayStrategyController(game,in,this);
    }

    /**
     * The number of sticks to be removed from the specified
     * Pile.  maxOnATurn is the maximum number of sticks
     * a Player can remove on a turn.  At least one stick
     * will be removed.
     * @require    pile.sticks() > 0
     *             maxOnATurn > 0
     * @ensure     this.numberToTake() >= 1 &&
     *             this.numberToTake() <= maxOnATurn &&
     *             this.numberToTake() <= pile.sticks()
     */
    public int numberToTake (Pile pile,
        int maxOnATurn) {
        int max;
        if (pile.sticks() < maxOnATurn)
            max = pile.sticks();
        else
            max = maxOnATurn;
        controller.update(this);
        return numberToTake;
    }

    /**
     * Set the number of sticks this InteractivePlayer should
     * taken on its next turn.
     * @require    number > 0
     */
    public void setNumberToTake (int number) {
        this.numberToTake = number;
    }

    /**
     * Set the PlayerObserver this InteractivePlayer is to
     * report to.  This InteractivePlayer will notify controller
     * (by invoking its update method) before making a play.
     */
    public void register (PlayStrategyObserver controller) {
        this.controller = controller;
    }
}
