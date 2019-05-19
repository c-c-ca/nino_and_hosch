package store;

/**
 * Models an employee in a retail store.
 */
public class Employee {

    // Private components:

    private String name;    // this Employee's name
    private int hours;      // hours worked in the
                            // pay period
    private double rate;    // the hourly rate for
                            // this Employee

    // Constructors:

    /**
     * Create a new Employee.
     */
    public Employee (String name, int hours,
                     double rate) {
        this.name = name;
        this.hours = hours;
        this.rate = rate;
    }

    // Queries:

    /**
     * This Employee's name.
     */
    public String name () {
        return name;
    }

    /**
     * The number of hours this Employee has worked in
     * the current pay period.
     */
    public int hours () {
        return hours;
    }

    /**
     * The hourly rate for this Employee.
     */
    public double rate () {
        return rate;
    }

    /**
     * This Employee's pay for the current period in
     * dollars.
     */
    public double pay () {
        return 0.0;
    }
}
