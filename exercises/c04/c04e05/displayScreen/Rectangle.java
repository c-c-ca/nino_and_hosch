package displayScreen;

/**
 * Models a rectangle on the screen.
 */
public class Rectangle {

    // Private components:

    private Location location;  // location of the upper left
                                // corner of this Rectangle
    private int height;         // vertical dimension
    private int width;          // horizontal dimension

    // Constructors:

    /**
     * Create a new Rectangle.  height and width are the
     * vertical and horizontal dimensions, respectively.
     * location is the upper left corner of this Rectangle.
     *
     * @require  height >= 0 && width >= 0
     */
    public Rectangle (Location location, int height, int width) {
        this.location = location;
        this.height = height;
        this.width = width;
    }

    // Queries:

    /**
     * The specified Location is inside (or on the perimeter of)
     * the Rectangle.
     *
     */
    public boolean contains (Location point) {
        return (location.x() <= point.x() && point.x() < location.x() + width)  &&
               (location.y() <= point.y() && point.y() < location.y() + height);
    }
}
