package storeManager;

/**
 * Models an employee in a retail store.
 */
public class Employee {

    // Constructors:

    /**
     * Create a new Employee.
     */
    public Employee () {}

    // Queries:

    /**
     * The Employee's pay for the week.
     * @require    hours >= 0
     *             rate >= 0
     * @ensure     result >= hours * rate &&
     *             result < hours * 1.5 * rate
     */
    public double pay (int hours, double rate) {
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
