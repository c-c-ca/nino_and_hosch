package store;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test the class Employee.
 */
public class EmployeeTest {

    // employees with the specified hours and rates
    private Employee noHoursNoRate;        // hour(s): 0,  hourly rate: 0
    private Employee noHours;              // hour(s): 0,  hourly rate: 7.25
    private Employee noRate;               // hour(s): 30, hourly rate: 0
    private Employee typicalRegularPay;    // hour(s): 30, hourly rate: 7.25
    private Employee maxRegularPay;        // hour(s): 40, hourly rate: 7.25
    private Employee minOvertime;          // hour(s): 41, hourly rate: 7.25
    private Employee typicalOvertime;      // hour(s): 50, hourly rate: 7.25

    @Before
    public void setUp () {
        noHoursNoRate = new Employee(0,0.0);
        noHours = new Employee(0,7.25);
        noRate = new Employee(30,0.0);
        typicalRegularPay = new Employee(30,7.25);
        maxRegularPay = new Employee(40,7.25);
        minOvertime = new Employee(41,7.25);
        typicalOvertime = new Employee(50,7.25);
    }

    /**
     * Test the pay method.
     */
    @Test
    public void testPay () {
        assertEquals(0.0, noHoursNoRate.pay(), 1e-4);
        assertEquals(0.0, noHours.pay(), 1e-4);
        assertEquals(0.0, noRate.pay(), 1e-4);
        assertEquals(217.5, typicalRegularPay.pay(), 1e-4);
        assertEquals(290.0, maxRegularPay.pay(), 1e-4);
        assertEquals(300.875, minOvertime.pay(), 1e-4);
        assertEquals(398.75, typicalOvertime.pay(), 1e-4);
    }
    
}
