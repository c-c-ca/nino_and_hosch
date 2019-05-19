package store;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test the class Employee.
 */
public class EmployeeTest {

    // part-time employees with the specified hours and rates
    private Employee noHoursPT;      // hour(s): 0
    private Employee regularPT;      // hour(s): 30
    private Employee maxRegularPT;   // hour(s): 40
    private Employee overtimePT;     // hour(s): 50

    // full-time employees with the specified hours and rates
    private Employee noHoursFT;      // hour(s): 0
    private Employee regularFT;      // hour(s): 30
    private Employee maxRegularFT;   // hour(s): 40
    private Employee overtimeFT;     // hour(s): 50

    @Before
    public void setUp () {
        noHoursPT = new PartTimeEmployee("",0,7.25);
        regularPT = new PartTimeEmployee("",30,7.25);
        maxRegularPT = new PartTimeEmployee("",40,7.25);
        overtimePT = new PartTimeEmployee("",50,7.25);
        noHoursFT = new FullTimeEmployee("",0,7.25);
        regularFT = new FullTimeEmployee("",30,7.25);
        maxRegularFT = new FullTimeEmployee("",40,7.25);
        overtimeFT = new FullTimeEmployee("",50,7.25);
    }

    /**
     * Test the PartTimeEmployee class.
     */
    @Test
    public void testPartTimeEmployee () {
        assertEquals(0.0, noHoursPT.pay(), 1e-4);
        assertEquals(217.5, regularPT.pay(), 1e-4);
        assertEquals(290.0, maxRegularPT.pay(), 1e-4);
        assertEquals(362.5, overtimePT.pay(), 1e-4);
    }

    /**
     * Test the FullTimeEmployee class.
     */
    @Test
    public void testFullTimeEmployee () {
        assertEquals(0.0, noHoursFT.pay(), 1e-4);
        assertEquals(217.5, regularFT.pay(), 1e-4);
        assertEquals(290.0, maxRegularFT.pay(), 1e-4);
        assertEquals(398.75, overtimeFT.pay(), 1e-4);
    }

}
