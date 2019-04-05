package ch7.figures;
import java.util.*;

/**
 * A simple text-based interface for Rectangles.
 */
public class RectangleTUI {
  
 // user menu choices:
  private static final int NO_CHOICE = 0;
  private static final int LENGTH = 1;
  private static final int WIDTH = 2;
  private static final int AREA = 3;
  private static final int PERIMETER = 4;
  private static final int NEW = 5;
  private static final int EXIT = 6;  
  
  private Rectangle rectangle;     // the model
  private Scanner in;      // standard input
  
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
    createRectangle();
    int choice = NO_CHOICE;
    while (choice != EXIT) {
      displayMenu();
      choice = readIntWithPrompt("Enter choice: ");
      executeChoice(choice);
    }
  }

  /**
   * Get dimensions from the user and create a Rectangle.
   */
  private void createRectangle () {
    int length = readDimension("Rectangle length (a non-negative integer): ");
    int width = readDimension("Rectangle width (a non-negative integer): ");
    // assert: length >=0 && width >= 0
    this.rectangle = new Rectangle(length,width);
  }

  /**
   * Get a legal dimension from the user.
   */
  private int readDimension (String prompt) {
    // initialize to insure at least one execution of
    // the loops:
    int dimension = -1;
    while (dimension < 0)
      dimension = readIntWithPrompt(prompt);
    return dimension;
  }
  
  /**
   * Display menu of options to user.
   */
  private void displayMenu () {
    System.out.println();
    System.out.println("Enter the number denoting the action to perform:");
    System.out.println("Display length.............." + LENGTH);
    System.out.println("Display width..............." + WIDTH);
    System.out.println( "Display area................" + AREA);
    System.out.println("Display perimeter..........." + PERIMETER);
    System.out.println("Create new rectangle........" + NEW);
    System.out.println( "Exit........................" + EXIT);
  }

  /**
   * Execute user's menu choice.
   */
  private void executeChoice (int choice) {
    System.out.println();
    if (choice == LENGTH)
      System.out.println("Length is " + rectangle.length());
    else if (choice == WIDTH)
      System.out.println("Width is " + rectangle.width());
    else if (choice == AREA)
      System.out.println("Area is " + rectangle.area());
    else if (choice == PERIMETER)
      System.out.println("Perimeter is " + rectangle.perimeter());
    else if (choice == NEW)
      createRectangle();
    else if (choice == EXIT)
      System.out.println("Goodbye.");
    else
      System.out.println(choice + " is not valid.");
  }

  /**
   * Prompt user with specified String, and read an int.
   * Method fails if user does not enter an int.
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

