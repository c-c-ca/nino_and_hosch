package figures;

import java.util.*;

/**
 * A simple text-based interface for Rectangles.
 */
public class RectangleTUI {

    // Named constants:

    private static final int NO_CHOICE = -1;
    private static final int LENGTH = 1;
    private static final int WIDTH = 2;
    private static final int AREA = 3;
    private static final int PERIMETER = 4;
    private static final int ALL = 5;
    private static final int NEW = 1;
    private static final int EXIT = 0;

    // Private components:

    private Rectangle rectangle;     // the model
    private Scanner in;              // standard input

    // Constructors:

    /**
     * Create a new RectangleTUI instance.
     */
    public RectangleTUI () {
        this.rectangle = null;
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
        createRectangle();
        int choice = NO_CHOICE;
        while (choice != EXIT) {
            displayMainMenu();
            choice = readIntWithPrompt("Enter choice: ");
            executeMainChoice(choice);
        }
    }

    /**
     * Create a new Rectangle with user-provided dimensions.
     */
    private void createRectangle () {
        int length = readDimension(
            "Rectangle length (a non-negative integer): ");
        int width = readDimension(
            "Rectangle width (a non-negative integer): ");
        this.rectangle = new Rectangle(length,width);
    }

    private void displayStartMenu () {
        System.out.println();
        System.out.println(
            "Enter the number denoting the action " +
            "to perform:");
        System.out.println(
            "Create new rectangle........." + NEW);
        System.out.println(
            "Exit........................." + EXIT);
    }

    private void displayMainMenu () {
        System.out.println();
        System.out.println(
            "Enter the number denoting the action " +
            "to perform:");
        System.out.println(
            "Display length..............." + LENGTH);
        System.out.println(
            "Display width................" + WIDTH);
        System.out.println(
            "Display area................." + AREA);
        System.out.println(
            "Display perimeter............" + PERIMETER);
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
        if (choice == LENGTH)
            System.out.println(
                "Length is " + rectangle.length());
        else if (choice == WIDTH)
            System.out.println(
                "Width is " + rectangle.width());
        else if (choice == AREA)
            System.out.println(
                "Area is " + rectangle.area());
        else if (choice == PERIMETER)
            System.out.println(
                "Perimeter is " + rectangle.perimeter());
        else if (choice == ALL) {
            System.out.println(
                "Length is " + rectangle.length());
            System.out.println(
                "Width is " + rectangle.width());
            System.out.println(
                "Area is " + rectangle.area());
            System.out.println(
                "Perimeter is " + rectangle.perimeter());
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
