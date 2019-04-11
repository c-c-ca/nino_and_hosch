package figures;

/**
 * Models a simple rectangle with integer dimensions.
 */
public class Rectangle {

    // Private components:

    private int length;      // the length for this rectangle
    private int width;       // the width for this rectangle

    // Constructor:

    /**
     * Create a new Rectangle with the specified length and width.
     * Length and width must be non-negative integers.
     */
    public Rectangle (int length, int width) {
        this.length = length;
        this.width = width;
    }

    // Queries:

    /**
     * The length of this Rectangle.
     */
    public int length () {
        return this.length;
    }

    /**
     * The width of this Rectangle.
     */
    public int width () {
        return this.width;
    }

    /**
     * The area of this rectangle.
     */
    public int area () {
        return this.length * this.width;
    }

    /**
     * The perimeter of this rectangle.
     */
    public int perimeter () {
        return this.length * 2 + this.width * 2;
    }

}
