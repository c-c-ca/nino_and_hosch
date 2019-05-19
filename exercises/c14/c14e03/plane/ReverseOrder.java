package plane;

import java.util.Comparator;

public class ReverseOrder
    implements Comparator<Point> {

    /**
     * Order Points in the opposite direction of
     * their natural order.
     */
     public int compare (Point first, Point second) {
         return second.compareTo(first);
     }
}
