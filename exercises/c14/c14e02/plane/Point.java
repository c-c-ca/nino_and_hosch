package plane;

/**
 * Models a point on a plane with integer coefficients.
 */
public class Point
    implements Comparable<Point> {

    // Private components:

    private int x;
    private int y;

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

    public int compareTo (Point other) {
        int x1, y1, x2, y2;
        x1 = this.getX();
        y1 = this.getY();
        x2 = other.getX();
        y2 = other.getY();

        if (x1 == x2 && y1 == y2)
            return 0;
        else if ((x1 < x2) || (x1 == x2 && y1 < y2))
            return -1;
        else
            return 1;
    }
}
