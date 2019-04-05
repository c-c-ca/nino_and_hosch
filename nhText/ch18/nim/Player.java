package nim;

/**
 * A player in the game simple nim.
 */
public interface Player {
  
  /**
   * This Player's name.
   */
  public String name ();
  
  /**
   * Number of sticks removed on this Player's most
   * recent turn. Returns 0 if this Player has not yet
   * taken a turn.
   *
   * @ensure     this.numberTaken() >= 0
   */
  public int numberTaken ();
  
  /**
   * Take a turn: remove sticks from the specified
   * Pile. maxOnATurn is the maximum number of sticks
   * a Player can remove on a turn. A Player will
   * remove at least one stick.
   *
   * @require    pile.sticks() > 0 && maxOnATurn > 0
   * @ensure     1 <= this.numberTaken() &&
   *             this.numberTaken() <= maxOnATurn &&
   *             pile.sticks() == old.pile.sticks() - this.numberTaken()
   */
  public void takeTurn (Pile pile, int maxOnATurn);
  
}

