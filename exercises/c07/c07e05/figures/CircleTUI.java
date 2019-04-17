package figures;

import java.util.*;

/**
 * A simple text-based interface for Circles.
 */
public class CircleTUI {

    // Named constants:

    private static final int NO_CHOICE = -1;
    private static final int RADIUS = 1;
    private static final int DIAMETER = 2;
    private static final int AREA = 3;
    private static final int CIRCUMFERENCE = 4;
    private static final int ALL = 5;
    private static final int NEW = 1;
    private static final int EXIT = 0;

    // Private components:

    private Circle circle;           // the model
    private Scanner in;              // standard input

    // Constructors:

    /**
     * Create a new CircleTUI instance.
     */
    public CircleTUI () {
        this.circle = null;
        this.in = new Scanner(System.in);
    }

    /**
     * Run the interface.
     */
    public void start () {
        int choice = NO_CHOICE;
        while (choice != EXIT) {
            displayStartMenu();
            choice = readIntWithPrompt("Enter choice: ");
            executeStartChoice(choice);
        }
    }

    private void runMain () {
        createCircle();
        int choice = NO_CHOICE;
        while (choice != EXIT) {
            displayMainMenu();
            choice = readIntWithPrompt("Enter choice: ");
            executeMainChoice(choice);
        }
    }

    /**
     * Create a new Circle with user-provided dimensions.
     */
    private void createCircle () {
        int radius = readDimension(
            "Circle radius (a non-negative integer): ");
        this.circle = new Circle(radius);
    }

    private void displayStartMenu () {
        System.out.println();
        System.out.println(
            "Enter the number denoting the action " +
            "to perform:");
        System.out.println(
            "Create new circle............" + NEW);
        System.out.println(
            "Exit........................." + EXIT);
    }

    private void displayMainMenu () {
        System.out.println();
        System.out.println(
            "Enter the number denoting the action " +
            "to perform:");
        System.out.println(
            "Display radius..............." + RADIUS);
        System.out.println(
            "Display diameter............." + DIAMETER);
        System.out.println(
            "Display area................." + AREA);
        System.out.println(
            "Display circumference........" + CIRCUMFERENCE);
        System.out.println(
            "Display all.................." + ALL);
        System.out.println(
            "Exit........................." + EXIT);
    }

    private void executeStartChoice (int choice) {
        System.out.println();
        if (choice == NEW)
            runMain();
        else if (choice == EXIT)
            System.out.println("Goodbye.");
        else
            System.out.println(choice + " is not valid.");
    }

    private void executeMainChoice (int choice) {
        if (choice != EXIT)
            System.out.println();
        if (choice == RADIUS)
            System.out.println(
                "Radius is " + circle.radius());
        else if (choice == DIAMETER)
            System.out.println(
                "Diameter is " + circle.diameter());
        else if (choice == AREA)
            System.out.println(
                "Area is " + circle.area());
        else if (choice == CIRCUMFERENCE)
            System.out.println(
                "Circumference is " + circle.circumference());
        else if (choice == ALL) {
            System.out.println(
                "Radius is " + circle.radius());
            System.out.println(
                "Diameter is " + circle.diameter());
            System.out.println(
                "Area is " + circle.area());
            System.out.println(
                "Circumference is " + circle.circumference());
        }
        else if (choice != EXIT)
            System.out.println(choice + " is not valid.");
    }

    private int readDimension (String prompt) {
        int dimension = -1;
        while (dimension < 0)
            dimension = readIntWithPrompt(prompt);
        return dimension;
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
