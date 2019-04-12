package displayScreen;

/**
 * Models a location on the screen.
 */
public class Location {

    // Private components:

    private int x;  // the x-coordinate
    private int y;  // the y-coordinate

    // Constructors:

    /**
     * Create a new Location.
     *
     * @require  x >= 0 && y >= 0
     */
    public Location (int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Queries:

    /**
     * The distance of the location (in pixels) from the
     * left of the screen.
     */
    public int x () {
        return x;
    }

    /**
     * The distance of the location (in pixels) from the
     * top of the screen.
     */
    public int y () {
        return y;
    }
}
