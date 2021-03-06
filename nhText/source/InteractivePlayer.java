package ch9.interactiveNim;

/**
 * A player in the game simple nim that gets moves from a client.
 */
public class InteractivePlayer implements Player {
  
  private String name;
  private int numberToTake;
  private int numberTaken;
  private PlayerObserver controller;

  /**
   * Create a new InteractivePlayer with the specified name.
   * @ensure     this.name().equals(name)
   */
  public InteractivePlayer (String name) {
    this.name = name;
    this.numberToTake = 0;
    this.numberTaken = 0;
    this.controller = null;
  }

   /**
    * This InteractivePlayer's name.
    */
  public String name () {
    return name;
  }

  /**
   * Number of sticks removed on this InteractivePlayer's most recent turn.
   * Returns 0 if this InteractivePlayer has not yet taken a turn.
   * @ensure     this.numberTaken() >= 0
   */
  public int numberTaken () {
    return numberTaken;
  }

  /**
   * Take a turn: remove sticks from the specified Pile. maxOnATurn is
   * the maximum number of sticks a Player can remove on a turn.
   * If this.setNumberToTake(number) is invoked before this InteractivePlayer
   * removes sticks, and if the argument number provided in the most recent
   * invocation is not greater than maxOnATurn nor greater than pile.sticks(),
   * then number sticks will be removed. Otherwise, one stick will be removed.
   * @require    pile.sticks() > 0 && maxOnATurn > 0
   * @ensure     1 <= this.numberTaken() && this.numberTaken() <= maxOnATurn &&
   *             pile.sticks() == old.pile.sticks() - this.numberTaken()
   */
  public void takeTurn (Pile pile, int maxOnATurn) {
    if (controller != null)
      controller.update(this);    // numberToTake set here
    int pileSize = pile.sticks();
    int number = 1;
    if (numberToTake > 0 && numberToTake <= maxOnATurn
          && numberToTake <= pileSize)
      number = numberToTake;
    pile.remove(number);
    numberTaken = number;
  }

  /**
   * Set the number of sticks this InteractivePlayer should take on its next turn.
   * @require    number > 0
   */
  public void setNumberToTake (int number) {
    this.numberToTake = number;
  }

  /**
   * Set the PlayerObserver this InteractivePlayer is to report to.
   * This InteractivePlayer will notify control (by invoking its update method)
   * before taking its turn.
   */
  public void register (PlayerObserver control) {
    this.controller = control;
  }

  /**
   * String representation of this InteractivePlayer.
   */
  public String toString () {
    return "InteractivePlayer " + name + ": last took " + numberTaken + " sticks.";
  }
  
}
