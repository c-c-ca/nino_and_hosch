package nimGame;

/**
 * An automated player in the game simple nim.
 */
class Player {

    // Private components:

    private String name;      // this Player's name
    private int numberTaken;  // the number of sticks taken
                              // on this Player's last turn

    // Constructors:

    /**
     * Create a new Player with the specified name.
     * @ensure     this.name().equals(name)
     */
    public Player (String name) {
        this.name = name;
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
        return numberTaken;
    }

    // Commands:

    /**
     * Take a turn: remove sticks from the specified Pile
     * according to the perfect winning strategy as suggested
     * in Chapter 8, Exercise 4.
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
        int number = Math.max((
            pile.sticks() - 1) % (maxOnATurn + 1),1);
        pile.remove(number);
        numberTaken = number;
    }
}
