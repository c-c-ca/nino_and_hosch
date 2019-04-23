package nimGame;

/**
 * Models the clever strategy in the game simple nim.
 */
class CleverStrategy implements PlayStrategy {

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
        int number = Math.max((
                pile.sticks() - 1) % (maxOnATurn + 1),1);
        return number;
    }
}
