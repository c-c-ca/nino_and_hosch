package sets;

import org.junit.*;
import static org.junit.Assert.*;

public class IntSetTest {

    private static final int MAX_ELEMENT = 3;

    // Test fixture:

    private IntSet set;

    @Before
    public void setUp () {
        set = new IntSet(MAX_ELEMENT);
    }

    @Test
    public void testInitialState () {
        assertEquals(MAX_ELEMENT,set.maxElement());
        assertFalse(set.isIn(0));
        assertFalse(set.isIn(MAX_ELEMENT+1));
    }

    /**
     * Test the add method.
     */
    @Test
    public void testAdd () {
        set.add(1);
        assertFalse(set.isIn(0));
        assertTrue(set.isIn(1));
    }

    /**
     * Test the remove method.
     */
    @Test
    public void testRemove () {
        set.add(1);
        assertTrue(set.isIn(1));
        set.remove(1);
        assertFalse(set.isIn(1));
    }
}
