package ch9.nim;

/**
 * A pile of sticks for playing simple nim.
 */
class Pile {
  
  private int sticks;  // number of stick in this Pile

  /**
   * Create a new Pile, with the specified number of sticks.
   * @require    sticks >= 0
   */
  public Pile (int sticks) {
    this.sticks = sticks;
  }
  
  /**
   * The number of sticks remaining in this Pile.
   * @ensure     this.sticks() >= 0
   */
  public int sticks () {
    return sticks;
  }

  /**
   * Reduce the number of sticks by the specified amount.
   * @require    number >= 0 && number <= this.sticks()
   * @ensure     this.sticks() == old.sticks() - number
   */
  public void remove (int number) {
    assert number <= sticks :
      "precondition: number <= this.sticks()";
      sticks = sticks - number;
  }

  /**
   * String representation of this Pile.
   */
  public String toString () {
    return "Pile: " + sticks + " sticks.";
  }
}
