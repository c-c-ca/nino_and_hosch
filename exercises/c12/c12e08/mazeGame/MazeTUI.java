package mazeGame;

import java.util.*;

/**
 * A text-based interface for a maze-crawling game.
 */
 class MazeTUI {

     // Main menu options:
     private static final int NO_CHOICE = -1;
     private static final int PLAY_GAME = 1;
     private static final int EXIT = 0;

     // In-game menu options:
     private static final int NORTH = 1;
     private static final int SOUTH = 2;
     private static final int EAST = 3;
     private static final int WEST = 4;

     private Maze maze;
     private Explorer explorer;
     private Scanner in;

     // Constructors:

     /**
      * Create a new user interface.
      */
     public MazeTUI () {
         this.explorer = null;
         this.maze = null;
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
             executeMainChoice(choice);
         }
     }

     /**
      * Explore the maze.
      */
     private void exploreMaze () {
         int choice = NO_CHOICE;
         while (choice != EXIT && !maze.finishedExploring()) {
             reportLocation();
             displayGameMenu();
             choice = readIntWithPrompt("Enter choice: ");
             executeGameChoice(choice);
         }
         reportSuccess();
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
             "Exit..................." + EXIT);
     }

     /**
      * Execute choice from main menu.
      */
     private void executeMainChoice (int choice) {
         System.out.println();
         if (choice == PLAY_GAME) {
             explorer = new Explorer();
             maze = new Maze(explorer);
             exploreMaze();
         } else if (choice == EXIT)
             System.out.println("Good-bye.");
         else
             System.out.println(choice + " is not valid.");
     }

     /**
      * Display the in-game menu.
      */
     private void displayGameMenu () {
         System.out.println();
         System.out.println(
             "Enter the number of the action to perform: ");
         System.out.println(
             "Move north............." + NORTH);
         System.out.println(
             "Move south............." + SOUTH);
         System.out.println(
             "Move east.............." + EAST);
         System.out.println(
             "Move west.............." + WEST);
         System.out.println(
             "Exit game.............." + EXIT);
     }

     /**
      * Execute choice from game menu.
      */
     private void executeGameChoice (int choice) {
         System.out.println();
         if (choice == NORTH || choice == SOUTH ||
             choice == EAST || choice == WEST) {
             explorer.setDirection(choice);
             maze.explore();
         } else if (choice == EXIT)
             System.out.println("Game over.");
         else
             System.out.println(choice + " is not valid.");
     }

     /**
      * Report the current location of the explorer.
      */
     private void reportLocation () {
         System.out.println();
         System.out.println(
            "Current location: " + explorer.location());
     }

     /**
      * Report the success of the previous game to the user.
      */
     private void reportSuccess () {
        if (maze.finishedExploring())
            System.out.println(
                "Congratulations! You found the treasure room!");
        else
            System.out.println(
                "Sorry, better luck next time.");
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
