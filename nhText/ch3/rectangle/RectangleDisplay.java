package rectangle;

/**
 * A simple system to display a Rectangle's
 * properties.
 */
public class RectangleDisplay {
  
  /**
   * Run the program.
   */
  public static void main (String[] argv) {
    Rectangle theModel;
    RectangleViewer theUserInterface;
    theModel = new Rectangle(100,50);
    theUserInterface = new RectangleViewer();
    theUserInterface.displayRectangle(theModel);
  }
}
