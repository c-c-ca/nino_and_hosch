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

    // Queries:

    public boolean contains (Location point) {
        return (location.x() <= point.x() && point.x() < location.x() + width)  &&
               (location.y() <= point.y() && point.y() < location.y() + height);
    }
}
