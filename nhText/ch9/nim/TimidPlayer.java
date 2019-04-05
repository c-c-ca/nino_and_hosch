package ch9.nim;

/**
 * A timid player in the game simple nim. A timid player always removes 1 stick.
 */
public class TimidPlayer implements Player {
  
  private String name;       // this Player's name
  private int numberTaken;   // number of sticks removed on this Player's most
                             // recent turn. Initially 0.
  
  /**
   * Create a new TimidPlayer with the specified name.
   * @ensure     this.name().equals(name)
   */
  public TimidPlayer (String name) {
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
   * maximum number of sticks a Player can remove on a turn. A TimidPlayer will
   * remove one stick.
   * @require    pile.sticks() > 0 && maxOnATurn > 0
   * @ensure     this.numberTaken() == 1 &&
                 pile.sticks() == old.pile.sticks() - this.numberTaken()
   */
  public void takeTurn (Pile pile, int maxOnATurn) {
    pile.remove(1);
    numberTaken = 1;
  }

  /**
   * String representation of this TimidPlayer.
   */
  public String toString () {
    return "TimidPlayer " + name + ": last took " + numberTaken + " sticks.";
  }
}
