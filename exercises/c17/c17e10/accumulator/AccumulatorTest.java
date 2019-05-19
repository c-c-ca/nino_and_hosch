package accumulator;

import org.junit.*;
import static org.junit.Assert.*;

public class AccumulatorTest {

    // Test fixture:

    private Accumulator accumulator;

    @Before
    public void setUp () {
        accumulator = new Accumulator();
    }

    @Test
    public void testInitialState () {
        assertEquals(0,accumulator.sum());
        assertEquals(0,accumulator.summand());
    }

    /**
     * Test the add method.
     */
    @Test
    public void testAdd () {
        accumulator.setSummand(1);
        assertEquals(1,accumulator.summand());
        accumulator.add();
        assertEquals(1,accumulator.sum());

        accumulator.add();
        assertEquals(2,accumulator.sum());

        accumulator.setSummand(2);
        assertEquals(2,accumulator.summand());

        accumulator.add();
        assertEquals(4,accumulator.sum());

        accumulator.reset();
        assertEquals(0,accumulator.sum());
        assertEquals(0,accumulator.summand());
    }
}
