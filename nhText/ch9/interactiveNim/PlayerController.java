package ch9.interactiveNim;
import java.util.*;

/**
 * A simple text based controller for an InteractivePlayer in nim.
 */
public class PlayerController implements PlayerObserver {
  
  private Game game;
  private Scanner in;
 
  /**
   * Create a new controller for the spaecified Player, in the specified Game,
   * using hte specified BasicFileReader for input.
   */
  public PlayerController (InteractivePlayer player, Game game, Scanner in) {
    this.game = game;
    this.in = in;
    player.register(this);
  }
 
  /**
   * The InteractivePlayer is about to make a move. Get the number of sticks to take
   * from the user and tell the InteractivePlayer.
   */
  public void update (InteractivePlayer player) {
    int numberToTake = readNumberToTake();
    player.setNumberToTake(numberToTake);
  }

  /**
   * Get a legal move from the user and return the number of sticks the user
   * wants to remove.
   */
  private int readNumberToTake () {
    int number = 0;
    int max = game.maxOnThisTurn();
    while (!(0 < number && number <= max)) {
      System.out.print("Enter number to take (a positive integer, at most " +
                       max + "): ");
      System.out.flush();
      if (in.hasNextInt())
        number = in.nextInt();
      in.nextLine();
    }
    return number;
  }
  
}

