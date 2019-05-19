package nimGame;

public abstract class ScoredPlayer implements Player {

    // Private components:

    protected Player player;
    private int score;

    // Constructors:

    /**
     * Create a new ScoredPlayer.
     */
    protected ScoredPlayer (Player player) {
        this.player = player;
    }

    // Queries:

    /**
     * This ScoredPlayer's score.
     */
    public int score () {
        return score;
    }

    /**
     * This Player's name.
     */
    public String name () {
        return player.name();
    }

    /**
     * Number of sticks removed on this Player's most recent
     * turn.  Returns 0 if this Player has not yet taken a
     * turn.
     * @ensure     this.numberTaken() >= 0
     */
    public int numberTaken () {
        return player.numberTaken();
    }

    // Commands:

    /**
     * Set this ScoredPlayer's score to the specified
     * score.
     */
    public void setScore (int score) {
        this.score = score;
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
        player.takeTurn(pile,maxOnATurn);
    }
}
