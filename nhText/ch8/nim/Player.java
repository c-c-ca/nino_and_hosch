package ch8.nim;

/**
 * An automated player in the game simple nim.
 */
public class Player {

  private String name;       // Player's name.
  private int numberTaken;   // number of sticks removed on this Player's most
                             // recent turn. Initially 0.
  
  /**
   * Create a new Player with the specified name.
   * @ensure     this.name().equals(name) && this.numberTaken() == 0
   */
  public Player (String name) {
    this.name = name;
    this.numberTaken = 0;
  }

  /**
   *  This Player's name.
   */
  public String name () {
    return name;
  }

  /**
   * Number of sticks removed on this Player's most recent turn.
   * Returns 0 if this Player has not yet taken a turn.
   * @ensure     this.numberTaken() >= 0
   */
  public int numberTaken () {
    return numberTaken;
  }

  /**
   * Take a turn: remove sticks from the specified Pile. maxOnATurn is the
   * maximum number of sticks a Player can remove on a turn. A Player will
   * remove at least one stick.
   * @require    pile.sticks() > 0 && maxOnATurn > 0
   * @ensure     1 <= this.numberTaken() && this.numberTaken() <= maxOnATurn &&
                 pile.sticks() == old.pile.sticks() - this.numberTaken()
   */
  public void takeTurn (Pile pile, int maxOnATurn) {
    pile.remove(1);
    numberTaken = 1;
  }
}
