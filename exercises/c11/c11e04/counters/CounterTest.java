package counters;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * A simple class to test the classes that implement
 * the abstract class Counter.
 */
public class CounterTest {

    // Test fixture:

    private Counter step;
    private Counter cell;

    @Before
    public void setUp () {
        step = Counter.createStandardCounter();
        cell = Counter.createCellDivisionCounter();
    }

    @Test
    public void testInitialState () {
        assertEquals(0,step.count());
        assertEquals(1,cell.count());
    }

    @Test
    public void testIncrement () {
        // StepCounter
        step.increment();
        assertEquals(1,step.count());
        step.increment();
        assertEquals(2,step.count());
        step.increment();
        assertEquals(3,step.count());
        // CellDivisionCounter
        cell.increment();
        assertEquals(2,cell.count());
        cell.increment();
        assertEquals(4,cell.count());
        cell.increment();
        assertEquals(8,cell.count());
    }


    @Test
    public void testDecrement () {
        // StepCounter
        step.increment();
        step.increment();
        step.increment();
        assertEquals(3,step.count());
        step.decrement();
        assertEquals(2,step.count());
        // CellDivisionCounter
        cell.increment();
        cell.increment();
        cell.increment();
        assertEquals(8,cell.count());
        cell.decrement();
        assertEquals(7,cell.count());
        cell.increment();
        assertEquals(14,cell.count());
    }
}
