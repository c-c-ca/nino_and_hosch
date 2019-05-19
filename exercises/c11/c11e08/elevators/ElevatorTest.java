package elevators;

import org.junit.*;
import static org.junit.Assert.*;

public class ElevatorTest {

    // Test fixture:

    private Elevator min;      // elevator with 2 floors
    private Elevator typical;  // elevator with 3 floors

    @Before
    public void setUp () {
        min = new Elevator(2);
        typical = new Elevator(3);
    }

    @Test
    public void testInitialState () {
        assertEquals(1,min.floor());
        assertTrue(min.goingUp());
        assertEquals(1,typical.floor());
        assertTrue(typical.goingUp());
    }

    /**
     * Test an elevator with only 2 floors
     * (minimum reasonable number).
     */
    @Test
    public void testMin () {
        min.move();
        assertEquals(2,min.floor());
        assertFalse(min.goingUp());
        min.move();
        assertEquals(1,min.floor());
        assertTrue(min.goingUp());
        min.move();
        assertEquals(2,min.floor());
        assertFalse(min.goingUp());
    }

    /**
     * Test a typical elevator.
     */
    @Test
    public void testTypical () {
        typical.move();
        assertEquals(2,typical.floor());
        assertTrue(typical.goingUp());
        typical.move();
        assertEquals(3,typical.floor());
        assertFalse(typical.goingUp());
        typical.move();
        assertEquals(2,typical.floor());
        assertFalse(typical.goingUp());
        typical.move();
        assertEquals(1,typical.floor());
        assertTrue(typical.goingUp());
    }
}
