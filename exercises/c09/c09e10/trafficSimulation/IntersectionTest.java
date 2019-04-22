package trafficSimulation;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * A simple class to test the class Intersection.
 */
public class IntersectionTest {

    // Test fixture:

    private Intersection intersection;

    @Before
    public void setUp () {
        intersection = new Intersection();
    }

    @Test
    public void testInitialState () {
        assertEquals(TrafficSignal.GREEN,intersection.northSouth());
        assertEquals(TrafficSignal.RED,intersection.eastWest());
    }

    @Test
    public void testChange () {
        intersection.change();
        assertEquals(TrafficSignal.YELLOW,intersection.northSouth());
        assertEquals(TrafficSignal.RED,intersection.eastWest());

        intersection.change();
        assertEquals(TrafficSignal.RED,intersection.northSouth());
        assertEquals(TrafficSignal.GREEN,intersection.eastWest());

        intersection.change();
        assertEquals(TrafficSignal.RED,intersection.northSouth());
        assertEquals(TrafficSignal.YELLOW,intersection.eastWest());
        // cycle back to initial setting
        intersection.change();
        assertEquals(TrafficSignal.GREEN,intersection.northSouth());
        assertEquals(TrafficSignal.RED,intersection.eastWest());
    }
}
