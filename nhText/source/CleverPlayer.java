package ch9.interactiveNim;

/**
 * A timid player in the game simple nim. A clever player uses an optimal
 * strategy.
 */
public class CleverPlayer implements Player {
  
  private String name;       // this Player's name
  private int numberTaken;   // number of sticks removed on this Player's most
                             // recent turn. Initially 0.
  
  /**
   * Create a new CleverPlayer with the specified name.
   * @ensure     this.name().equals(name)
   */
  public CleverPlayer (String name) {
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
   * maximum number of sticks a Player can remove on a turn. A CleverPlayer
   * uses an optimal strategy.
   * @require    pile.sticks() > 0 && maxOnATurn > 0
   * @ensure     1 <= this.numberTaken() &&
   *             this.numberTaken() <= maxOnATurn &&
                 pile.sticks() == old.pile.sticks() - this.numberTaken()
   */
  public void takeTurn (Pile pile, int maxOnATurn) {
    int number = (pile.sticks()-1) % (maxOnATurn+1);
    if (number == 0)
      number = 1;
    pile.remove(number);
    numberTaken = number;
  }

  /**
   * String representation of this CleverPlayer.
   */
  public String toString () {
    return "CleverPlayer " + name + ": last took " + numberTaken + " sticks.";
  }
}
