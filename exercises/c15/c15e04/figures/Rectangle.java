package figures;

/**
 * Models a simple rectangle with integer dimensions.
 */
public class Rectangle {

    private int length;
    private int width;

    /**
     * Create a new Rectangle with the specified length and width.
     * @require    length >= 0 && width >= 0
     * @ensure     this.length() == length &&
     *             this.width() == width
     */
    public Rectangle (int length, int width) {
        assert length >= 0 && width >= 0 :
            "precondition: length (" + length + ") >= 0 && " +
            "width (" + width + ") >= 0";
        this.length = length;
        this.width = width;
    }

    /**
     * The length of this Rectangle.
     * @ensure     result >= 0
     */
    public int length () {
        return length;
    }

    /**
     * The width of this Rectangle.
     * @ensure     result >= 0
     */
    public int width () {
        return width;
    }

    /**
     * The area of this rectangle.
     * @ensure     result >= 0
     */
    public int area () {
        return length * width;
    }

    /**
     * The perimeter of this Rectangle.
     * @ensure     result >= 0
     */
    public int perimeter () {
        return 2 * length + 2 * width;
    }

}
