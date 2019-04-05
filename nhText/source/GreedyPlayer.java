package ch9.interactiveNim;

/**
 * A timid player in the game simple nim. A greedy player always removes
 * as many sticks as possible.
 */
public class GreedyPlayer implements Player {
  
  private String name;       // this Player's name
  private int numberTaken;   // number of sticks removed on this Player's most
                             // recent turn. Initially 0.
  
  /**
   * Create a new GreedyPlayer with the specified name.
   * @ensure     this.name().equals(name)
   */
  public GreedyPlayer (String name) {
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
   * maximum number of sticks a Player can remove on a turn. A GreedyPlayer will
   * remove as many sticks as possible.
   * @require    pile.sticks() > 0 && maxOnATurn > 0
   * @ensure     this.numberTaken() == min(maxOnATurn, pile.sticks()) &&
                 pile.sticks() == old.pile.sticks() - this.numberTaken()
   */
  public void takeTurn (Pile pile, int maxOnATurn) {
    int number;
    if (pile.sticks() < maxOnATurn)
      number = pile.sticks();
    else
      number = maxOnATurn;
    pile.remove(number);
    numberTaken = number;
  }

  /**
   * String representation of this GreedyPlayer.
   */
  public String toString () {
    return "GreedyPlayer " + name + ": last took " + numberTaken + " sticks.";
  }
}
