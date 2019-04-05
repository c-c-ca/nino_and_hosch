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
     pile.remove(1);
     numberTaken = 1;
   }
   
