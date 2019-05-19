package plane;

import org.junit.*;
import static org.junit.Assert.*;

public class PointTest {

    // Test fixture:

    private Point p1;
    private Point p2;
    private Point p3;
    private NaturalOrder natural;
    private ReverseOrder reverse;

    @Before
    public void setUp () {
        p1 = new Point(0,0);
        p2 = new Point(0,1);
        p3 = new Point(1,0);
        natural = new NaturalOrder();
        reverse = new ReverseOrder();
    }

    @Test
    public void testCompareTo () {
        assertTrue(p1.compareTo(p2)<0);
        assertFalse(p2.compareTo(p1)<0);
        assertTrue(p2.compareTo(p3)<0);
        assertFalse(p3.compareTo(p2)<0);
        assertTrue(p1.compareTo(p3)<0);
        assertFalse(p3.compareTo(p1)<0);
    }

    @Test
    public void testCompare () {
        assertTrue(natural.compare(p1,p2)<0);
        assertFalse(natural.compare(p2,p1)<0);
        assertTrue(natural.compare(p2,p3)<0);
        assertTrue(natural.compare(p1,p3)<0);
        assertTrue(reverse.compare(p2,p1)<0);
        assertFalse(reverse.compare(p1,p2)<0);
        assertTrue(reverse.compare(p3,p2)<0);
        assertTrue(reverse.compare(p3,p1)<0);
    }
}
