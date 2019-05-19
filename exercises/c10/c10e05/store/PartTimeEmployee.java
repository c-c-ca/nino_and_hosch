package store;

/**
 * Models a part-time employee in a retail store.
 */
public class PartTimeEmployee extends Employee {

    // Constructors:

    /**
     * Create a new PartTimeEmployee.
     */
    public PartTimeEmployee (String name, int hours,
                             double rate) {
        super(name,hours,rate);
    }

     // Queries:

    /**
     * This Employee's pay for the current period in
     * dollars.
     */
    public double pay () {
        return (double) hours() * rate();
    }
}
