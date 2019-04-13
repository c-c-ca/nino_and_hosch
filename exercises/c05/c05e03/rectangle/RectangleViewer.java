package rectangle;

/**
 * A trivial object to display a Rectangle.
 */
public class RectangleViewer {

  /**
   * Create a viewer.
   */
  public RectangleViewer () {
  }

  /**
   * Write the properties of the specified Rectangle to standard output.
   */
  public void displayRectangle (Rectangle rectangle) {
     int outputValue;
     outputValue = rectangle.length();
     System.out.println("length: " + outputValue);
     outputValue = rectangle.width();
     System.out.println("width: " + outputValue);
     outputValue = rectangle.area();
     System.out.println("area: " + outputValue);
     outputValue = rectangle.perimeter();
     System.out.println("perimeter: " + outputValue);
  }

}
