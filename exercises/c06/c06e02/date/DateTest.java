package date;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * A simple class to test the class Date.
 */
public class DateTest {

    // Private components:

    private Date year1763;  // year not divisible by 4
    private Date year1764;  // year divisible by 4, but not by 100
    private Date year1900;  // year divisible by 100, but not by 400
    private Date year2000;  // year divisible by 400

    @Before
    public void setUp () {
        year1763 = new Date(1,1,1763);
        year1764 = new Date(1,1,1764);
        year1900 = new Date(1,1,1900);
        year2000 = new Date(1,1,2000);
    }

    /**
     * Test the method isLeapYear.
     */
    @Test
    public void testIsLeapYear () {
        assertFalse(year1763.isLeapYear());
        assertTrue(year1764.isLeapYear());
        assertFalse(year1900.isLeapYear());
        assertTrue(year2000.isLeapYear());
    }


}
