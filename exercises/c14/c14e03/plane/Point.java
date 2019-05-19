package plane;

/**
 * Models a point on a plane with integer coefficients.
 */
public class Point
    implements Comparable<Point> {

    // Private components:

    private final int x;
    private final int y;

    // Constructors:

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Queries:

    /**
     * This Point's x coordinate.
     */
    public int getX () {
        return x;
    }

    /**
     * This Point's y coordinate.
     */
    public int getY () {
        return y;
    }

    public boolean equals (Object other) {
        if (other instanceof Point)
            return this.getX() == ((Point)other).getX() &&
                this.getY() == ((Point)other).getY();
        else
            return false;
    }

    public int compareTo (Point other) {
        if (this.getX() == other.getX())
            return this.getY() - other.getY();
        else
            return this.getX() - other.getX();
    }
}
