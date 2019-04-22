package store;

/**
 * Models an employee in a retail store.
 */
public class Employee {

    // Private components:

    private int hours;           // hours worked in the
                                 // pay period
    private PayCalculator calc;  // computes pay

    // Constructors:

    /**
     * Create a new Employee.
     */
    public Employee (int hours) {
        this.hours = hours;
        this.calc = null;
    }

    // Commands:

    /**
     * Set the PayCalculator for this Employee.
     */
    public void setPayCalculator (PayCalculator calc) {
        this.calc = calc;
    }

    // Queries:

    /**
     * The number of hours this Employee has worked in
     * the current pay period.
     */
    public int hours () {
        return hours;
    }

    /**
     * This Employee's pay for the current period in
     * dollars.
     */
    public double pay () {
        return calc.calculatePayment(hours);
    }
}
