package counters;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test the class ModulusCounter
 */
public class ModulusCounterTest {

    // modulus counters with the specified maximum values
    private ModulusCounter min;      // a ModulusCounter with a
                                     // maximum value of 0
    private ModulusCounter typical;  // a ModulusCounter with a
                                     // maximum value of 3

    @Before
    public void setUp () {
        min = new ModulusCounter(0);
        typical = new ModulusCounter(3);
    }

    @Test
    public void testInitialState () {
        assertEquals("min", 0, min.count());
        assertEquals("typical", 0, typical.count());
    }

    /**
     * Test the increment method.
     */
    @Test
    public void testIncrement () {
        // test a counter created with the minimum max value
        min.increment();
        assertEquals("increment min 1 step", 0, min.count());
        min.increment(); min.increment();
        assertEquals("increment min 3 steps", 0, min.count());
        // test a counter created with a typical max value
        typical.increment();
        assertEquals("increment typical 1 step", 1, typical.count());
        typical.increment();
        assertEquals("increment typical 2 steps", 2, typical.count());
        typical.increment();
        assertEquals("increment typical 3 steps", 3, typical.count());
        typical.increment();
        assertEquals("increment typical 4 steps", 0, typical.count());
    }
}
