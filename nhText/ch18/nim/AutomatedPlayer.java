package nim;

/**
 * A timid player in the game simple nim. A timid player always removes 1 stick.
 */
public class AutomatedPlayer extends AbstractPlayer {
  
  /**
   * Create a new AutomatedPlayer with the specified name.
   * @ensure     this.name() == name
   */
  public AutomatedPlayer (String name) {
    super(name);
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
    setSticksTaken(1);
    setChanged();
    notifyObservers();
  }

}
