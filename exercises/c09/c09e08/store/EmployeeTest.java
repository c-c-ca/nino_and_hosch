package store;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test the class Employee.
 */
public class EmployeeTest {

    // employees with the specified hours and rates
    private Employee noHours;              // hour(s): 0
    private Employee typical;              // hour(s): 30

    @Before
    public void setUp () {
        noHours = new Employee(0);
        typical = new Employee(30);
    }

    private void setAllToRegularPay () {
        noHours.setPayCalculator(new PayRegular());
        typical.setPayCalculator(new PayRegular());
    }

    /**
     * Test the PayRegular PayCalculator.
     */
    @Test
    public void testPayRegular () {
        setAllToRegularPay();
        assertEquals(0.0, noHours.pay(), 1e-4);
        assertEquals(217.5, typical.pay(), 1e-4);
    }

    private void setAllToOvertimePay () {
        noHours.setPayCalculator(new PayOvertime());
        typical.setPayCalculator(new PayOvertime());
    }

    /**
     * Test the PayOverTime PayCalculator.
     */
    @Test
    public void testPayOvertime () {
        setAllToOvertimePay();
        assertEquals(0.0, noHours.pay(), 1e-4);
        assertEquals(326.25, typical.pay(), 1e-4);
    }

}
