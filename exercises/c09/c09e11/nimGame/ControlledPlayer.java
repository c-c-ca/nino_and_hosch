package nimGame;

/**
 * A player in the game simple nim that gets moves
 * from a controller.
 */
class ControlledPlayer implements Player {

    // Private components:

    private String name;                 // this Player's name
    private int numberToTake;            // the number of sticks to take
    private int numberTaken;             // the number of sticks taken
                                         // on this Player's last turn
    private PlayerObserver controller;   // the controller

    // Constructors:

    /**
     * Create a new ControlledPlayer with the specified name.
     * @ensure     this.name().equals(name) &&
     *             this.numberTaken() == 0
     */
    public ControlledPlayer (String name) {
        this.name = name;
        this.numberToTake = 0;
        this.numberTaken = 0;
        this.controller = null;
    }

    // Queries:

    /**
     * This ControlledPlayer's name.
     */
    public String name () {
        return name;
    }

    /**
     * Number of sticks removed on this ControlledPlayer's most recent
     * turn.  Returns 0 if this Player has not yet taken a
     * turn.
     * @ensure     this.numberTaken() >= 0
     */
    public int numberTaken () {
        return numberTaken;
    }

    // Commands:

    /**
     * Take a turn: remove sticks from the specified Pile.
     * maxOnATurn is the maximum number of sticks a Player
     * can remove on a turn.
     * If this.setNumberToTake(number) is invoked before
     * this ControlledPlayer removes sticks, and if the
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
        numberTaken = number;
    }

    /**
     * Set the number of sticks this ControlledPlayer should
     * taken on its next turn.
     * @require    number > 0
     */
    public void setNumberToTake (int number) {
        this.numberToTake = number;
    }

    /**
     * Set the PlayerObserver this ControlledPlayer is to
     * report to.  This ControlledPlayer will notify controller
     * (by invoking its update method) before making a play.
     */
    public void register (PlayerObserver controller) {
        this.controller = controller;
    }
}
