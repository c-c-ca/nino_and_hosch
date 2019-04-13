package date;

/**
 * A simple class to test the class Date.
 */
class DateTest {

    // Private components:

    private Date date;  // the object to test

    // Constructors:

    /**
     * Create a new DateTest.
     */
    public DateTest () {
        date = null;
    }

    /**
     * Run the test.
     */
    public void runTest () {
        testIsLeapYear();
    }

    /**
     * Test the isLeapYear method.
     */
    private void testIsLeapYear () {
        date = new Date(1,1,1763);
        verify(!date.isLeapYear(), "isLeapYear: year not divisible by 4");

        date = new Date(1,1,1776);
        verify(date.isLeapYear(), "isLeapYear: year divisible by 4, not 100");

        date = new Date(1,1,1800);
        verify(!date.isLeapYear(), "isLeapYear: year divisible by 100, not 400");

        date = new Date(1,1,2000);
        verify(date.isLeapYear(), "isLeapYear: year divisible by 400");
    }

    /**
     * Verify the specified test condition.  Print message if the test fails.
     */
    private void verify (Boolean test, String message) {
        if (!test)
            System.out.println(
                "Verification failed: " + message);
    }
} // end of class DateTest

/**
 * A simple test system for the class DateTest.
 */
public class TestDateClass {

    /**
     * Run a DateTest.
     */
    public static void main (String[] args) {
        (new DateTest()).runTest();
    }
}
