/**
 * Models a simple rectangle with integer dimensions.
 */
public class Rectangle {

    private int length;
    private int width;

    /**
     * Create a new Rectangle, with length and width
     * initialized to 1.
     */
    public Rectangle () {
        length = 1;
        width = 1;;
    }

    /**
     * The length of this Rectangle.
     */
    public int length () {
        return length;
    }

    /**
     * The width of this Rectangle.
     */
    public int width () {
        return width;
    }

    /**
     * The area of this rectangle/
     */
    public int area () {
        return length * width;
    }

    /**
     * Change the length of this Rectangle to the specified
     * value. newLength must be non-negative.
     */
    public void setLength (int newLength) {
        assert newLength >= 0;
        length = newLength;
    }

    /**
     * Change the width of this Rectangle to the specified
     * value. newWidth must be non-negative.
     */
    public void setWidth (int newWidth) {
        assert newWidth >= 0;
        width = newWidth;
    }

    /**
     * This Rectangle has the same length and width as the specified
     * Rectangle.
     */
    public boolean hasEqualDimensions (Rectangle other) {
        return this.length == other.length && this.width == other.width;
    }

    /**
     * Representation of this Rectangle as a String.
     */
    public String toString () {
        return "Rectangle: length: " + length + "; width: " + width;
    }

}
