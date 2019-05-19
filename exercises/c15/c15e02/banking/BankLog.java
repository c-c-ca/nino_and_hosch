package banking;

public class BankLog {

    public BankLog () {}

    public void logWithdrawal (
        int accountNumber, int amount)
        throws LogFailureException {
        throw new LogFailureException();
    }
}
