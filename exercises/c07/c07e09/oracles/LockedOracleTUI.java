package oracles;

import java.util.*;

/**
 * A simple text-based interface for a LockedOracle.
 */
class LockedOracleTUI {

    // Named constants:

    private static final int NO_CHOICE = -1;
    private static final int FORTUNE = 1;
    private static final int EXIT = 0;

    // Private components:

    private LockedOracle oracle;
    private Scanner in;

    // Constructors:

    /**
     * Create a new interface for the specified LockedOracle.
     */
    public LockedOracleTUI (LockedOracle oracle) {
        this.oracle = oracle;
        this.in = new Scanner(System.in);
    }

    // Commands:

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

    // Auxiliary methods:

    private void displayMenu () {
        System.out.println();
        System.out.println(
            "Enter the number denoting the action " +
            "to perform:");
        System.out.println(
            "Get fortune.................." + FORTUNE);
        System.out.println(
            "Exit........................." + EXIT);
    }

    private void executeChoice (int choice) {
        System.out.println();
        if (choice == FORTUNE)
            getFortune();
        else if (choice == EXIT)
            System.out.println("Goodbye.");
        else
            System.out.println(choice + " is not valid.");
    }

    private void getFortune () {
        String fortune;
        int key = readKey("Enter key (0-999): ");
        oracle.augurFortune(key);
        fortune = oracle.fortune();
        System.out.println(fortune);
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

    /**
     * Read and return a legal key.
     * @ensure     0 <= this.readKey() &&
     *             this.readKey() <= 999
     */
    private int readKey (String prompt) {
        int key = -1;
        boolean haveGoodKey = false;
        while (!haveGoodKey) {
            System.out.print(prompt); System.out.flush();
            if (in.hasNextInt()) {
                key = in.nextInt();
                haveGoodKey = (0 <= key && key <= 999);
            }
            in.nextLine();
        }
        return key;
    }
}
