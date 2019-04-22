package store;

/**
 * Models a PayCalculator that determines the payment
 * earned during regular hours.
 */
public class PayRegular implements PayCalculator {

    // Named constants:

    private static final double RATE = 7.25;

    /**
     * Calculate the payment for the specified hours and
     * rate during regular hours.
     */
    public double calculatePayment (int hours) {
        return (double) hours * RATE;
    }
}
