package nimGame;

/**
 * A player in the game simple nim.
 */
class Player {

    // Private components:

    private String name;
    private int numberTaken;
    private PlayStrategy strategy;

    // Constructors:

    /**
     * Create a Player with the specified name and strategy.
     */
    public Player (String name, PlayStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
        this.numberTaken = 0;
    }

    // Queries:

    /**
     * This Player's name.
     */
    public String name () {
        return name;
    }

    /**
     * Number of sticks removed on this Player's most recent
     * turn.  Returns 0 if this Player has not yet taken a
     * turn.
     * @ensure     this.numberTaken() >= 0
     */
    public int numberTaken () {
        return this.numberTaken;
    }

    // Commands:

    /**
     * Set this Player's PlayStrategy to the one specified.
     */
    public void setStrategy (PlayStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Take a turn: remove sticks from the specified Pile.
     * maxOnATurn is the maximum number of sticks a Player
     * can remove on a turn.  A Player will remove at least
     * one stick.
     * @require    pile.sticks() > 0 && maxOnATurn > 0
     * @ensure     1 <= this.numberTaken() &&
     *             this.numberTaken() <= maxOnATurn &&
     *             pile.sticks() ==
     *                old.pile.sticks() - this.numberTaken()
     */
    public void takeTurn (Pile pile, int maxOnATurn) {
        int number = strategy.numberToTake(pile, maxOnATurn);
        pile.remove(number);
        numberTaken = number;
    }
}
