package plane;

import java.util.Comparator;

public class NaturalOrder
    implements Comparator<Point> {

    /**
     * Order Points according to their natural order.
     */
     public int compare (Point first, Point second) {
         return first.compareTo(second);
     }
}
