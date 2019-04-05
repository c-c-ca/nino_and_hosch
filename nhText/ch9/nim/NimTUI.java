package ch9.nim;
import java.util.*;

/**
 * A simple text-based user interface for the game of
 * simple nim, played computer vs. computer.
 */
public class NimTUI {
  
  // Main menu options:
  private static final int NO_CHOICE = 0;
  private static final int PLAY_GAME = 1;
  private static final int EXIT = 2;
  
  private Player player1;      // the Players
  private Player player2;
  private Game game;
  private Scanner in;
  
  /**
   * Create a new user interface.
   */
  public NimTUI () {
    this.player1 = new TimidPlayer("Player1");
    this.player2 = new GreedyPlayer("Player2");
    this.game = null;
    this.in = new Scanner(System.in);
  }
  
  /**
   * Start the interface.
   */
  public void start () {
    int choice = NO_CHOICE;
    while (choice != EXIT) {
      displayMainMenu();
      choice = readIntWithPrompt("Enter choice: ");
      executeChoice(choice);
    }
  }
  
  /**
   * Play a game with the specified number of sticks.
   */
  private void playGame (int numberOfSticks) {
    game = new Game (player1, player2, numberOfSticks);
    while (!game.gameOver()) {
      game.play();
      reportPlay(game.previousPlayer());
      nhUtilities.utilities.Control.sleep(1);
    }
    reportWinner(game.winner());
  }
  
  /**
   * Display the main menu.
   */
  private void displayMainMenu () {
    System.out.println();
    System.out.println("Enter the number denoting the action to perform: ");
    System.out.println("Run game..............." + PLAY_GAME);
    System.out.println("Exit..................." + EXIT);
  }
  
  /**
   * Execute choice from main menu.
   */
  private void executeChoice (int choice) {
    System.out.println();
    if (choice == PLAY_GAME) {
      int numberOfSticks = readNumberOfSticks();
      playGame(numberOfSticks);
    } else if (choice == EXIT)
      System.out.println("Good-bye.");
  }
  
  /**
   * Report the play of the specified Player.
   */
  private void reportPlay (Player player) {
    System.out.println("Player " + player.name() + " takes " + player.numberTaken() +
                       " stick(s), leaving " + game.sticksLeft() + ".");
  }
  
  /**
   * Read and return the number of sticks to play with.
   *
   * @ensure    this.readNumberOfSticks() > 0
   */
  private int readNumberOfSticks () {
    int number = -1;
    while (number <= 0) {
      number = readIntWithPrompt("Enter number of sticks (a positive integer): ");
    }
    return number;
  }
  
  /**
   * Report that the specified Player won.
   */
  private void reportWinner (Player player) {
    System.out.println();
    System.out.println("Player " + player.name() + " wins.");
    System.out.println();
  }
  
  /**
   * Read and return an int in response to the specified
   * prompt.
   */
  private int readIntWithPrompt (String prompt) {
    System.out.print(prompt); System.out.flush();
    while (!in.hasNextInt()) {
      in.nextLine();
      System.out.print(prompt); System.out.flush();
    }
    int input = in.nextInt();
    in.nextLine();
    return input;
  }
  
}
