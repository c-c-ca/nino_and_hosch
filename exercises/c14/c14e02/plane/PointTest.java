package plane;

import org.junit.*;
import static org.junit.Assert.*;

public class PointTest {

    // Test fixture:

    private Point p1;
    private Point p2;
    private Point p3;

    @Before
    public void setUp () {
        p1 = new Point(0,0);
        p2 = new Point(0,1);
        p3 = new Point(1,0);
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
}
