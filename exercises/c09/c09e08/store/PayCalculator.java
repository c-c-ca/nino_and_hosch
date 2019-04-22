package store;

/**
 * Models a calculator that performs a pay calculation.
 */
public interface PayCalculator {

    /**
     * Calculate the payment for the specified hours and
     * rate.
     */
    public double calculatePayment (int hours);
}
