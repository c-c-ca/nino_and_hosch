package nimGame;

/**
 * An automated player in the game simple nim.
 */
public class Player {

   // Private components:

   private String name;          // this Player's name
   private int numberTaken;      // sticks taken on this Player's most recent
                                 // turn; 0 if this Player has not taken a turn.
  // Constructors:

  /**
   * Create a new Player with the specified name.
   */
  public Player (String name) {
    this.name = name;
    this.numberTaken = 0;
  }

  // Queries:

  /**
   * The name of this Player.
   */
  public String name () {
    return name;
  }

  /**
   * The number of sticks this Player removed on this
   * Player's most recent turn: 1, 2, or 3. Returns 0
   * if this Player has not yet taken a turn.
   */
  public int numberTaken () {
    return numberTaken;
  }

  // Commands:

  /**
   * Remove 1, 2, or 3 sticks from the specified Pile.
   * The Pile must not be empty.
   */
   public void takeTurn (Pile pile) {
     int left;       // number in the pile
     int take;       // number to take
     left = pile.sticks();
     // determine number to take
     if (1 < left && left < 5)
        take = left - 1;
     else
        take = 1;
     pile.remove(take);
     numberTaken = take;
   }

}
