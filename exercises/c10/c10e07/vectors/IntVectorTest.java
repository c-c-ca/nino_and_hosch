package vectors;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * A test class for the classes IntVector and
 * ConstructedVector.
 */
public class IntVectorTest {

    // Test fixture:

    private IntVector v0;  // empty IntVector
    private IntVector v1;  // contains 1 integer
    private IntVector v3;  // contains 3 integers
    private IntVector u1;  // contains 1 integer
                           // different from v1
    private IntVector u3;  // contains 3 integers
                           // different from v3
    private IntVector w1;  // same as v1
    private IntVector w3;  // same as v3


    @Before
    public void setUp () {
        v0 = new IntVector();
        v1 = v0.prefix(3);
        v3 = v1.prefix(4).prefix(5);
        u1 = (new IntVector()).prefix(6);
        u3 = u1.prefix(7).prefix(8);
        w1 = (new IntVector()).prefix(3);
        w3 = w1.prefix(4).prefix(5);
    }

    @Test
    public void testInitialState () {
        assertEquals("()", v0.toString());
        assertEquals("(3)", v1.toString());
        assertEquals("(5, 4, 3)", v3.toString());
        assertEquals("(6)", u1.toString());
        assertEquals("(8, 7, 6)", u3.toString());
        assertEquals("(3)", w1.toString());
        assertEquals("(5, 4, 3)", w3.toString());
    }

    @Test
    public void testEquals () {
        assertTrue(v0.equals((new IntVector())));
        // different lengths
        assertFalse(v1.equals(v3));
        assertFalse(v3.equals(v1));
        // same lengths, different integers
        assertFalse(v1.equals(u1));
        assertFalse(v3.equals(u3));
        // different objects, same sequences
        assertTrue(v1.equals(w1));
        assertTrue(v3.equals(w3));
    }

    @Test
    public void testSum () {
        assertEquals(0,IntVector.sum(v0));
        assertEquals(3,IntVector.sum(v1));
        assertEquals(12,IntVector.sum(v3));
        assertEquals(6,IntVector.sum(u1));
        assertEquals(21,IntVector.sum(u3));
    }
}
