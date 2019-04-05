package nim;

import java.util.*;

/**
 * A base class for constructing a player in the game simple nim.
 */
public abstract class AbstractPlayer extends Observable implements Player {
  
  private String name;       // this Player's name
  private int numberTaken;   // number of sticks removed on this Player's most
                             // recent turn. Initially 0.
  
  /**
   * Create a new AbstractPlayer with the specified name.
   * @ensure     this.name() == name
   */
  public AbstractPlayer (String name) {
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
   * String representation of this TimidPlayer.
   */
  public String toString () {
    return "TimidPlayer " + name + ": last took " + numberTaken + " sticks.";
  }

  protected void setSticksTaken (int number) {
    this.numberTaken = number;
  }
}

