package figures;

/**
 * A simple tester for the class Rectangle.
 */
public class RectangleTester {

    // Private components;

    private Rectangle rectangle;

    /**
     * Create a new RectangleTester
     */
    public RectangleTester () {}

    /**
     * Run the test.
     */
    public void start () {
        // Test a 0 x 0 Rectangle
        System.out.println("Initialize a rectangle with dimensions length: 0, width: 0.");
        rectangle = new Rectangle(0,0);
        System.out.print("Length: ");
        System.out.println(rectangle.length());
        System.out.print("Width: ");
        System.out.println(rectangle.width());
        System.out.print("Area: ");
        System.out.println(rectangle.area());
        System.out.print("Perimeter: ");
        System.out.println(rectangle.perimeter());
        System.out.println();

        // Test a 1 x 1 Rectangle
        System.out.println("Initialize a rectangle with dimensions length: 1, width: 1.");
        rectangle = new Rectangle(1,1);
        System.out.print("Length: ");
        System.out.println(rectangle.length());
        System.out.print("Width: ");
        System.out.println(rectangle.width());
        System.out.print("Area: ");
        System.out.println(rectangle.area());
        System.out.print("Perimeter: ");
        System.out.println(rectangle.perimeter());
        System.out.println();

        // Test a 2 x 3 Rectangle
        System.out.println("Initialize a rectangle with dimensions length: 2, width: 3.");
        rectangle = new Rectangle(2,3);
        System.out.print("Length: ");
        System.out.println(rectangle.length());
        System.out.print("Width: ");
        System.out.println(rectangle.width());
        System.out.print("Area: ");
        System.out.println(rectangle.area());
        System.out.print("Perimeter: ");
        System.out.println(rectangle.perimeter());
        System.out.println();

        // Test a 4 x 4 Rectangle
        System.out.println("Initialize a rectangle with dimensions length: 4, width: 4.");
        rectangle = new Rectangle(4,4);
        System.out.print("Length: ");
        System.out.println(rectangle.length());
        System.out.print("Width: ");
        System.out.println(rectangle.width());
        System.out.print("Area: ");
        System.out.println(rectangle.area());
        System.out.print("Perimeter: ");
        System.out.println(rectangle.perimeter());
        System.out.println();
    }
}
