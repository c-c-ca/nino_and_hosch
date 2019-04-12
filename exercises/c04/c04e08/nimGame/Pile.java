package nimGame;

/**
 * A pile of sticks for playing simple nim.
 */
public class Pile {

  // Private components:

  private int sticksLeft;  // sticks left in the Pile

  // Constructors:

  /**
   * Create a new Pile, with the specified number of sticks.
   * sticks must be non-negative.
   */
  public Pile (int sticks) {
      sticksLeft = sticks;
  }

  // Queries:

  /**
   * The number of sticks remaining in this Pile.
   */
  public int sticks () {
    return sticksLeft;
  }

  // Commands:

  /**
   * Reduce the number of sticks by the specified amount.
   * number must be non-negative and not greater than the number of
   * sticks remaining.
   */
  public void remove (int number) {
      sticksLeft = sticksLeft - number;
  }

}
