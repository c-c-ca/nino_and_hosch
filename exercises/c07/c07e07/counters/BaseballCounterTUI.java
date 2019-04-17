package counters;

import java.util.*;

/**
 * A simple text-based interface for BaseballCounters.
 */
public class BaseballCounterTUI {

    // Named constants:

    private static final int NO_CHOICE = -1;
    private static final int STRIKE = 1;
    private static final int BALL = 2;
    private static final int RESET = 3;
    private static final int EXIT = 0;

    // Private components:

    private BaseballCounter counter;   // the model
    private Scanner in;                // standard input

    // Constructors:

    /**
     * Create a new BaseballCounterTUI instance.
     */
    public BaseballCounterTUI () {
        this.counter = new BaseballCounter();
        this.in = new Scanner(System.in);
    }

    /**
     * Run the interface.
     */
    public void start () {
        int choice = NO_CHOICE;
        while (choice != EXIT) {
            displayMenu();
            choice = readIntWithPrompt("Enter choice: ");
            executeChoice(choice);
        }
    }

    private void displayMenu () {
        System.out.println();
        System.out.println(
            "Enter the number denoting the action " +
            "to perform:");
        System.out.println(
            "Increment strikes............" + STRIKE);
        System.out.println(
            "Increment balls.............." + BALL);
        System.out.println(
            "Reset........................" + RESET);
        System.out.println(
            "Exit........................." + EXIT);
    }

    private void executeChoice (int choice) {
        System.out.println();
        if (choice == STRIKE || choice == BALL ||
            choice == RESET) {
            if (choice == STRIKE)
                counter.incrementStrikes();
            else if (choice == BALL)
                counter.incrementBalls();
            else
                counter.reset();
            System.out.println(
                "Strike: " + counter.strikes() + " " +
                "Ball: " + counter.balls());
        } else if (choice == EXIT)
            System.out.println("Goodbye.");
        else
            System.out.println(choice + " is not valid.");
    }

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
