package counters;

import java.util.*;

/**
 * A simple text-based interface for Counters.
 */
public class CounterTUI {

    // Named constants:

    private static final int NO_CHOICE = -1;
    private static final int INCREMENT = 1;
    private static final int RESET = 2;
    private static final int EXIT = 0;

    // Private components:

    private Counter counter;         // the model
    private Scanner in;              // standard input

    // Constructors:

    /**
     * Create a new CounterTUI instance.
     */
    public CounterTUI () {
        this.counter = new Counter();
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
            "Increment...................." + INCREMENT);
        System.out.println(
            "Reset........................" + RESET);
        System.out.println(
            "Exit........................." + EXIT);
    }

    private void executeChoice (int choice) {
        System.out.println();
        if (choice == INCREMENT || choice == RESET) {
            if (choice == INCREMENT)
                counter.increment();
            else
                counter.reset();
            System.out.println(
                "The current count is " + counter.count());
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
