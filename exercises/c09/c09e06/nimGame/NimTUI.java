package nimGame;

import java.util.*;

/**
 * A simple text-based user interface for the game of
 * simple nim, played computer vs. computer.
 */
class NimTUI {

    // Main menu options:
    private static final int NO_CHOICE = 0;
    private static final int PLAY_GAME = 1;
    private static final int EXIT = 2;

    // Player selection options:
    private static final int TIMID = 1;
    private static final int GREEDY = 2;
    private static final int CLEVER = 3;
    private static final int INTERACTIVE = 4;

    private Player player1;       // the players
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
    private void playGame (int numberOfSticks,
                           String whoPlaysFirst) {
        System.out.println();
        if (whoPlaysFirst.equals(player1.name()))
            game = new Game (player1, player2,
                numberOfSticks);
        else
            game = new Game (player2, player1,
                numberOfSticks);
        initializePlayerController(player1);
        initializePlayerController(player2);
        while (!game.gameOver()) {
            game.play();
            reportPlay(game.previousPlayer());
        }
        reportWinner(game.winner());
    }

    /**
     * Display the main menu.
     */
    private void displayMainMenu () {
        System.out.println();
        System.out.println(
            "Enter the number of the action to perform: ");
        System.out.println(
            "Run game..............." + PLAY_GAME);
        System.out.println(
            "Exit..................." + EXIT);
    }

    /**
     * Display the player selection menu.
     */
    private void displayPlayerMenu () {
        System.out.println();
        System.out.println("Player Selection Menu:");
        System.out.println(
            "Timid player..........." + TIMID);
        System.out.println(
            "Greedy player.........." + GREEDY);
        System.out.println(
            "Clever player.........." + CLEVER);
        System.out.println(
            "Interactive player....." + INTERACTIVE);
    }

    /**
     * Execute choice from main menu.
     */
    private void executeChoice (int choice) {
        System.out.println();
        if (choice == PLAY_GAME) {
            displayPlayerMenu();
            player1 = selectPlayer(1);
            player2 = selectPlayer(2);
            System.out.println();
            int numberOfSticks = readNumberOfSticks();
            String whoPlaysFirst = readWhoPlaysFirst();
            playGame(numberOfSticks,whoPlaysFirst);
        } else if (choice == EXIT)
            System.out.println("Good-bye.");
        else
            System.out.println(choice + " is not valid.");
    }

    /**
     * Select player for the next game.
     */
    private Player selectPlayer (int which) {
        System.out.println();
        int choice = readPlayerChoice(which);
        String name = readPlayerName();
        if (choice == TIMID)
            return new TimidPlayer(name);
        else if (choice == GREEDY)
            return new GreedyPlayer(name);
        else if (choice == CLEVER)
            return new CleverPlayer(name);
        else
            return new InteractivePlayer(name);
    }

    /**
     * Initialize PlayerController if the specified Player
     * is an InteractivePlayer.
     */
    private void initializePlayerController (Player player) {
        if (player1 instanceof InteractivePlayer)
            new PlayerController(
                (InteractivePlayer)player,game,in);
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
     * Report the play of the specified Player.
     */
    private void reportPlay (Player player) {
        System.out.println("Player " + player.name() +
              " takes " + player.numberTaken() +
              " stick(s), leaving " + game.sticksLeft()
              + ".");
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
     * Read and return player choice.
     */
    private int readPlayerChoice (int which) {
        int choice = NO_CHOICE;
        while (!(choice == TIMID || choice == GREEDY ||
               choice == CLEVER || choice == INTERACTIVE)) {
            choice = readIntWithPrompt(
                "Enter choice for Player " + which + ": ");
        }
        return choice;
    }

    /**
     * Read and return player name.
     */
     private String readPlayerName () {
         String name = "";
         while (name == "") {
             System.out.print("Enter player name: ");
             System.out.flush();
             name = in.next();
             in.nextLine();
         }
         return name;
     }

     /**
      * Read the name of the Player who plays first.
      * @ensure     result.equals(player1.name()) ||
      *             result.equals(player2.name())
      */
     private String readWhoPlaysFirst () {
         String name, player1Name, player2Name;
         name = "";
         player1Name = player1.name();
         player2Name = player2.name();
         while (!(name.equals(player1Name.toLowerCase()) ||
                  name.equals(player2Name.toLowerCase()) )) {
            System.out.print(
                "Who plays first? (" + player1Name +
                " or " + player2Name + "): ");
                System.out.flush();
            name = in.next();
            name = name.toLowerCase();
            in.nextLine();
         }
         if (name.equals(player1Name.toLowerCase()))
             return player1Name;
         else
             return player2Name;
     }
}
