package nimGame;

/**
 * A player in the game simple nim that gets moves
 * from a client.
 */
class InteractivePlayer extends AbstractPlayer {

    // Private components:

    private int numberToTake;            // the number of sticks to take
                                         // on this Player's next turn
    private PlayerObserver controller;   // the controller

    // Constructors:

    /**
     * Create a new InteractivePlayer with the specified name.
     * @ensure     this.name().equals(name) &&
     *             this.numberTaken() == 0
     */
    public InteractivePlayer (String name) {
        super(name);
        this.numberToTake = 0;
        this.controller = null;
    }

    // Commands:

    /**
     * Take a turn: remove sticks from the specified Pile.
     * maxOnATurn is the maximum number of sticks a Player
     * can remove on a turn.
     * If this.setNumberToTake(number) is invoked before
     * this InteractivePlayer removes sticks, and if the
     * argument number provided in the most recent invocation
     * is not greater than maxOnATurn nor greater than
     * pile.sticks(), then number sticks will be removed.
     * Otherwise, one will be removed.
     * @require    pile.sticks() > 0 && maxOnATurn > 0
     * @ensure     1 <= this.numberTaken() &&
     *             this.numberTaken() <= maxOnATurn &&
     *             pile.sticks() ==
     *                old.pile.sticks() - this.numberTaken()
     */
    public void takeTurn (Pile pile, int maxOnATurn) {
        if (controller != null)
            controller.update(this);
        int pileSize = pile.sticks();
        int number = 1;
        if (numberToTake > 0 && numberToTake <= maxOnATurn
              && numberToTake <= pileSize)
           number = numberToTake;
        pile.remove(number);
        setNumberTaken(number);
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
    public void register (PlayerObserver controller) {
        this.controller = controller;
    }
}
