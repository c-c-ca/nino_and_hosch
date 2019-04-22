package store;

/**
 * Models a PayCalculator that determines the payment
 * earned during overtime hours.
 */
public class PayOvertime implements PayCalculator {

    // Named constants:

    private static final double RATE = 7.25 * 1.5;

    /**
     * Calculate the payment for the specified hours and
     * rate during overtime hours.
     */
    public double calculatePayment (int hours) {
        return (double) hours * RATE;
    }
}
