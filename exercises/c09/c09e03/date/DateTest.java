package date;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * A simple class to test the class Date.
 */
public class DateTest {

    // Private components:

    private Date year1763;             // year not divisible by 4
    private Date year1764;             // year divisible by 4, but not by 100
    private Date year1900;             // year divisible by 100, but not by 400
    private Date year2000;             // year divisible by 400

    private Date typicalDay;           // typical day
    private Date lastDayOf31DayMonth;  // last day of a 31-day month
    private Date lastDayOf30DayMonth;  // last day of a 30-day month
    private Date lastDayOfFebNoLeap;   // last day of a February in a non-leap year
    private Date lastDayOfFebLeap;     // last day of a February in a leap year
    private Date lastDayOfYear;        // last day of the year

    private Date jan1st1763;           // first day of January in 1763
    private Date feb1st1763;           // first day of February in 1763

    @Before
    public void setUp () {
        year1763 = new Date(1,1,1763);
        year1764 = new Date(1,1,1764);
        year1900 = new Date(1,1,1800);
        year2000 = new Date(1,1,2000);

        typicalDay = new Date(1,1,1763);
        lastDayOf31DayMonth = new Date(31,1,1763);
        lastDayOf30DayMonth = new Date(30,4,1763);
        lastDayOfFebNoLeap = new Date(28,2,1763);
        lastDayOfFebLeap = new Date(29,2,1764);
        lastDayOfYear = new Date(31,12,1763);

        jan1st1763 = new Date(1,1,1763);
        feb1st1763 = new Date(1,2,1763);
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

    /**
     * Test the isLegalDate method.
     */
    @Test
    public void testIsLegalDate () {
        // date before legal range
        assertFalse("date before 1763", Date.isLegalDate(31,12,1762));
        // first legal date, first day of the month, first day of the year
        assertTrue("first legal date", Date.isLegalDate(1,1,1763));
        // last day of month with 30 days
        assertTrue("last day of 30-day month", Date.isLegalDate(30,4,1763));
        // first day considered illegal in a month with 30 days
        assertFalse("first illegal day of 30-day month", Date.isLegalDate(31,4,1763));
        // last day of month with 31 days
        assertTrue("last day of 31-day month", Date.isLegalDate(31,1,1763));
        // first day considered illegal in a month with 31 days
        assertFalse("first illegal day of 31-day month", Date.isLegalDate(32,1,1763));
        // last day of February, no leap year
        assertTrue("last day of Feb, no leap", Date.isLegalDate(28,2,1763));
        // first day considered illegal in February, no leap year
        assertFalse("first illegal day of Feb, no leap", Date.isLegalDate(29,2,1763));
        // last day of February, leap year
        assertTrue("last day of Feb, leap", Date.isLegalDate(29,2,1764));
        // first day considered illegal in February, leap year
        assertFalse("first illegal day of Feb, leap", Date.isLegalDate(30,2,1764));
        // last day of the year
        assertTrue("last day of the year", Date.isLegalDate(31,12,1763));
    }

    /**
     * Test the nextDate method.
     */
    @Test
    public void testNextDate () {
        // next date after a typical day
        assertEquals("next date after a typical day",
            2, typicalDay.nextDate().day());
        assertEquals("next date after a typical day",
            1, typicalDay.nextDate().month());
        assertEquals("next date after a typical day",
            1763, typicalDay.nextDate().year());
        // next date after the last day in a 31-day month
        assertEquals("next date after last day in a 31 day month",
            1, lastDayOf31DayMonth.nextDate().day());
        assertEquals("next date after last day in a 31 day month",
            2, lastDayOf31DayMonth.nextDate().month());
        assertEquals("next date after last day in a 31 day month",
            1763, lastDayOf31DayMonth.nextDate().year());
        // next date after the last day in a 30-day month
        assertEquals("next date after last day in a 30 day month",
            1, lastDayOf30DayMonth.nextDate().day());
        assertEquals("next date after last day in a 30 day month",
            5, lastDayOf30DayMonth.nextDate().month());
        assertEquals("next date after last day in a 30 day month",
            1763, lastDayOf30DayMonth.nextDate().year());
        // next date after the last day in February, non-leap year
        assertEquals("next date after last day in Feb, no leap",
            1, lastDayOfFebNoLeap.nextDate().day());
        assertEquals("next date after last day in Feb, no leap",
            3, lastDayOfFebNoLeap.nextDate().month());
        assertEquals("next date after last day in Feb, no leap",
            1763, lastDayOfFebNoLeap.nextDate().year());
        // next date after the last day in February, leap year
        assertEquals("next date after last day in Feb, leap",
            1, lastDayOfFebLeap.nextDate().day());
        assertEquals("next date after last day in Feb, leap",
            3, lastDayOfFebLeap.nextDate().month());
        assertEquals("next date after last day in Feb, leap",
            1764, lastDayOfFebLeap.nextDate().year());
        // next date after the last day in year
        assertEquals("next date after last day in year",
            1, lastDayOfYear.nextDate().day());
        assertEquals("next date after last day in year",
            1, lastDayOfYear.nextDate().month());
        assertEquals("next date after last day in year",
            1764, lastDayOfYear.nextDate().year());
    }

    /**
     * Test the greaterThan method.
     */
    @Test
    public void testGreaterThan () {
        // Same Date
        assertFalse(year1763.greaterThan(year1763));
        // Different year, same day and month
        assertTrue(year1764.greaterThan(year1763));
        assertFalse(year1763.greaterThan(year1764));
        // Different month, same day and year
        assertTrue(feb1st1763.greaterThan(jan1st1763));
        assertFalse(jan1st1763.greaterThan(feb1st1763));


    }

}
