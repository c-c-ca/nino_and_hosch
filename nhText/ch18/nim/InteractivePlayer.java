package nim;

/**
 * A player in the game simple nim that gets moves from a client.
 */
public class InteractivePlayer extends AbstractPlayer {

  private int numberToTake;

  /**
   * Create a new InteractivePlayer with the specified name.
   * @ensure     this.name() == name
   */
  public InteractivePlayer (String name) {
    super(name);
    this.numberToTake = 0;
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
    int pileSize = pile.sticks();
    int number = 1;
    if (numberToTake > 0 && numberToTake <= maxOnATurn
          && numberToTake <= pileSize)
      number = numberToTake;
    pile.remove(number);
    setSticksTaken(number);
    setChanged();
    notifyObservers();
  }

  /**
   * Set the number of sticks this InteractivePlayer should take on its next turn.
   * @require    number > 0
   */
  public void setNumberToTake (int number) {
    this.numberToTake = number;
  }
  
}
