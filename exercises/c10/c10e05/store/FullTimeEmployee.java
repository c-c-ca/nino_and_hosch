package store;

/**
 * Models a full-time employee in a retail store.
 */
public class FullTimeEmployee extends Employee {

    // Named constants:

    private static final int MAX_REG_HOURS = 40;

    // Constructors:

    /**
     * Create a new FullTimeEmployee.
     */
    public FullTimeEmployee (String name, int hours,
                             double rate) {
        super(name,hours,rate);
    }

     // Queries:

    /**
     * This Employee's pay for the current period in
     * dollars.
     */
    public double pay () {
        int hours, regular, overtime;
        double rate;
        hours = hours();
        rate = rate();
        if (hours > MAX_REG_HOURS) {
            regular = MAX_REG_HOURS;
            overtime = hours - MAX_REG_HOURS;
        } else {
            regular = hours;
            overtime = 0;
        }
        return (double) regular * rate +
            (double) overtime * rate * 1.5;
    }
}
