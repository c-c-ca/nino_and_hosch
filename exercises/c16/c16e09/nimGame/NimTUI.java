package nimGame;

import java.util.*;

/**
 * A simple text-based user interface for the game of
 * simple nim, played computer vs. computer.
 */
class NimTUI {

    // Main menun options:
    private static final int NO_CHOICE = 0;
    private static final int PLAY_GAME = 1;
    private static final int RESTORE = 2;
    private static final int EXIT = 3;
    private static final String FILE_NAME = "game.dat";

    private Player player1;    // the players
    private Player player2;
    private Game game;
    private Scanner in;

    // Constructors:

    /**
     * Create a new user interface.
     */
    public NimTUI () {
        this.player1 = null;
        this.player2 = null;
        this.game = null;
        this.in = new Scanner(System.in);
    }

    // Commands:

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
    private void playGame (String player1Name, String player2Name,
                           int numberOfSticks) {
        boolean exitGame = false;
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        game = new Game (player1, player2, numberOfSticks);
        while (!game.gameOver() && !exitGame) {
            getNextMove(game.nextPlayer());
            game.play();
            reportPlay(game.previousPlayer());
            nhUtilities.utilities.Control.sleep(1);
            if (!game.gameOver())
                exitGame = checkForExit();
                game.saveGame(FILE_NAME);
        }
        if (exitGame)
            game.saveGame(FILE_NAME);
        else
            reportWinner(game.winner());
    }

    /**
     * Display the main menu
     */
    private void displayMainMenu () {
        System.out.println();
        System.out.println(
            "Enter the number of the action to perform: ");
        System.out.println(
            "Run game..............." + PLAY_GAME);
        System.out.println(
            "Restore previous game.." + RESTORE);
        System.out.println(
            "Exit..................." + EXIT);
    }

    private boolean checkForExit () {
        String prompt =
            "Do you wish to save and exit (yes or no)? ";
        return readYesOrNo(prompt).equals("yes");
    }

    /**
     * Execute choice from main menu.
     */
    private void executeChoice (int choice) {
        System.out.println();
        if (choice == PLAY_GAME) {
            String player1Name = readPlayerName(1);
            String player2Name = readPlayerName(2);
            int numberOfSticks = readNumberOfSticks();
            System.out.println();
            playGame(player1Name, player2Name, numberOfSticks);
        } else if (choice == EXIT)
            System.out.println("Good-bye.");
        else
            System.out.println(choice + " is not valid.");
    }

    /**
     * Get the next move for the specified Player.
     */
    private void getNextMove (Player player) {
        int number = readNumberToTake(player);
        player.setNumberToTake(number);
    }

    /**
     * Read and return the number of sticks to play with.
     * @ensure     this.readNumberOfSticks() > 0
     */
    private int readNumberOfSticks () {
        int number = -1;
        while (number <= 0) {
            number = readIntWithPrompt(
                  "Enter number of sticks " +
                  "(a positive integer): ");
        }
        return number;
    }

    /**
     * Read and return the name for a Player for the
     * specified player number.
     */
    private String readPlayerName (int number) {
        System.out.print("Enter a name for Player " +
                         number + ": ");
        System.out.flush();
        String input = in.next();
        in.nextLine();
        return input;
    }

    /**
     * Read the number of sticks to take on the
     * next turn.
     */
    private int readNumberToTake (Player player) {
        int number, maxToTake;
        String maxToTakeStr;
        number = -1;
        maxToTake = Math.min(game.sticksLeft(),3);
        maxToTakeStr = maxToTake > 1 ? "-" + maxToTake : "";
        while (number < 0 || number > maxToTake)
            number = readIntWithPrompt(
                "Player " + player.name() + " enter number " +
                "of sticks (1" + maxToTakeStr + "): ");
        return number;
    }

    /**
     * Report that the specified Player won.
     */
    private void reportWinner (Player player) {
        System.out.println();
        System.out.println("Player " + player.name() +
              " wins.");
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

    /**
     * Report the play of the specified Player.
     */
    private void reportPlay (Player player) {
        System.out.println("Player " + player.name() +
              " takes " + player.numberTaken() +
              " stick(s), leaving " + game.sticksLeft()
              + ".");
    }

    private String readYesOrNo (String prompt) {
        String input = "";
        while (!(input.equals("yes") || input.equals("no"))) {
            System.out.print(prompt); System.out.flush();
            input = in.next();
            in.nextLine();
        }
        return input;
    }
}
