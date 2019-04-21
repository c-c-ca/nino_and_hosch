package trafficSimulation;

import java.util.*;

/**
 * A simple text-based interface for an Intersection.
 */
public class IntersectionTUI {

    // Named constants:

    private static final int NO_CHOICE = -1;
    private static final int CHANGE = 1;
    private static final int EXIT = 2;

    private static final String GREEN = "Green";
    private static final String YELLOW = "Yellow";
    private static final String RED = "Red";

    // Private components:

    private Intersection intersection;
    private Scanner in;

    /**
     * Create a new IntersectionTUI instance.
     */
    public IntersectionTUI () {
        intersection = new Intersection();
        in = new Scanner(System.in);
    }

    /**
     * Start the interface.
     */
    public void start () {
        int choice = NO_CHOICE;
        displayIntersection();
        while (choice != EXIT) {
            displayMenu();
            choice = readIntWithPrompt("Enter choice: ");
            executeChoice(choice);
        }
    }

    /**
     * Display the lights in the Intersection.
     */
    private void displayIntersection () {
        displaySignal("North-South", intersection.northSouth());
        displaySignal("East-West", intersection.eastWest());
    }

    /**
     * Display the color with the signalName.
     */
    private void displaySignal (String signalName, int light) {
        String lightStr;
        lightStr = getLightStr(light);
        System.out.println(signalName + " Signal: " + lightStr);
    }

    /**
     * Return the String associated with the specified light.
     */
    private String getLightStr (int light) {
        if (light == TrafficSignal.GREEN)
            return GREEN;
        else if (light == TrafficSignal.YELLOW)
            return YELLOW;
        else
            return RED;
    }

    /**
     * Display the main menu
     */
    private void displayMenu () {
        System.out.println();
        System.out.println(
            "Enter the number of the action to perform: ");
        System.out.println(
            "Change lights.........." + CHANGE);
        System.out.println(
            "Exit..................." + EXIT);
    }

    /**
     * Execute choice from main menu.
     */
    private void executeChoice (int choice) {
        System.out.println();
        if (choice == CHANGE) {
            intersection.change();
            displayIntersection();
        } else if (choice == EXIT)
            System.out.println("Good-bye.");
        else
            System.out.println(choice + " is not valid.");
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
