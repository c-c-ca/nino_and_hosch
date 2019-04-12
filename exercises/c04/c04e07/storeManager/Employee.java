package storeManager;

/**
 * Models an employee in a retail store.
 */
public class Employee {

    // Private components:

    private int hours;    // hours worked in the week
    private double rate;  // hourly pay rate (dollars)

    // Constructors:

    /**
     * Create a new Employee.
     */
    public Employee () {}

    // Queries:

    /**
     * The Employee's pay for the week.
     */
    public double pay () {
        double pay;
        int overtime;
        double overtimeRate;
        if (hours > 40) {
            overtime = hours - 40;
            hours = 40;
        } else
            overtime = 0;
        overtimeRate = rate * 1.5;
        return (double) hours * rate + (double) overtime * overtimeRate;
    }
}
